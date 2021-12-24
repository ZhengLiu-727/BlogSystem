package site.liuzheng.service;

import site.liuzheng.dao.pojo.SysUser;
import site.liuzheng.vo.Result;
import site.liuzheng.vo.params.LoginParams;

/**
 * @author liuzheng
 */
public interface LoginService {
    /**
     * 登陆功能
     * @param loginParams
     * @return
     */
    Result login(LoginParams loginParams);

    SysUser checkToken(String token);
}