package site.liuzheng.service.impl;

import com.alibaba.fastjson.JSON;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import site.liuzheng.dao.pojo.SysUser;
import site.liuzheng.service.LoginService;
import site.liuzheng.service.SysUserService;
import site.liuzheng.utils.JWTUtils;
import site.liuzheng.vo.ErrorCode;
import site.liuzheng.vo.Result;
import site.liuzheng.vo.params.LoginParams;

import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author liuzheng
 */
@Service
public class LoginServiceImpl implements LoginService {

    //加密盐用于加密
    private static final String SLAT = "mszlu!@#";

    @Autowired
    private SysUserService sysUserService;

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public Result login(LoginParams loginParams) {
        /*
          1. 检测参数是否合法
          2. 根据用户名和密码去user表中查询是否存在
          3. 如果不存在，登陆失败
          4. 如果存在，使用jwt生成token返回给前端
          5. token放入redis中，token：user信息，设置过期时间
            （登陆认证的时候，先验证token字符串是否合法，去redis验证是否存在）
         */
        String account = loginParams.getAccount();
        String password = loginParams.getPassword();
        if (StringUtils.isBlank(account) || StringUtils.isBlank(password)) {
            return Result.fail(ErrorCode.PARAMS_ERROR.getCode(), "参数不合法");
        }
        String pwd = DigestUtils.md5Hex(password + SLAT);
        SysUser sysUser = sysUserService.findUser(account,pwd);
        if (sysUser == null){
            return Result.fail(ErrorCode.ACCOUNT_PWD_NOT_EXIST.getCode(),ErrorCode.ACCOUNT_PWD_NOT_EXIST.getMsg());
        }
        // 登录成功，使用JWT生成token，返回token和redis中
        String token = JWTUtils.createToken(sysUser.getId());
        // JSON.toJSONString 用法    https://blog.csdn.net/antony9118/article/details/71023009
        // 过期时间是一百天
        // redisTemplate用法  https://blog.csdn.net/lydms/article/details/105224210
        redisTemplate.opsForValue().set("TOKEN_"+token, JSON.toJSONString(sysUser),100, TimeUnit.DAYS);
        return Result.success(token);
    }

    @Override
    public SysUser checkToken(String token) {
        //token为空返回null
        if(StringUtils.isBlank(token)){
            return null;
        }
        Map<String, Object> stringObjectMap = JWTUtils.checkToken(token);
        //解析失败
        if(stringObjectMap ==null){
            return null;
        }
        //如果成功
        String userJson =  redisTemplate.opsForValue().get("TOKEN_"+token);
        if (StringUtils.isBlank(userJson)) {
            return null;
        }
        //解析回sysUser对象
        SysUser sysUser = JSON.parseObject(userJson, SysUser.class);
        return sysUser;
    }

    @Override
    public Result logout(String token) {
        redisTemplate.delete("TOKEN_"+token);
        return Result.success(null);
    }
}
