package site.liuzheng.service;

import site.liuzheng.dao.pojo.SysUser;

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
}
