package site.liuzheng.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.liuzheng.dao.mapper.SysUserMapper;
import site.liuzheng.dao.pojo.SysUser;
import site.liuzheng.service.SysUserService;

/**
 * @author liuzheng
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser findUserById(Long id) {
        SysUser sysUser = sysUserMapper.selectById(id);
        if (sysUser == null) {
            sysUser = new SysUser();
            sysUser.setNickname("liuzheng");
        }
        return sysUser;
    }
}
