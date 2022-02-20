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

    /**
     * 根据账户查询用户
     * @param account
     * @return
     */
    SysUser findUserByAccount(String account);

    /**
     * 保存用户
     * @param sysUser
     */
    void save(SysUser sysUser);
}
