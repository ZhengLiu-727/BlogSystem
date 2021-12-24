package site.liuzheng.service;

import site.liuzheng.dao.pojo.SysUser;
import site.liuzheng.vo.Result;

/**
 * @author liuzheng
 */
public interface SysUserService {
    /**
     *
     * @param id
     * @return
     */
    SysUser findUserById(Long id);

    /**
     *
     * @param account
     * @param password
     * @return
     */
    SysUser findUser(String account, String password);

    /**
     * 根据token查询用户信息
     * @param token
     * @return
     */
    Result findUserByToken(String token);
}
