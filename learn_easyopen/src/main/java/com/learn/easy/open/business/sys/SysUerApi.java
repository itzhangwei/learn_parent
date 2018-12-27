package com.learn.easy.open.business.sys;

import com.baomidou.mybatisplus.core.conditions.query.EmptyWrapper;
import com.gitee.easyopen.annotation.Api;
import com.gitee.easyopen.annotation.ApiService;
import com.gitee.easyopen.doc.annotation.ApiDocMethod;
import com.learn.entity.SysUser;
import com.learn.mapper.sys.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 张伟
 * @version V1.0.0
 * @projectName learn_parent
 * @title SysUerApi
 * @package com.learn.easy.open.sys
 * @description 用户
 * @date 2018/12/25 17:49
 */
@ApiService
@Transactional
public class SysUerApi {

    private final SysUserMapper userMapper;

    @Autowired
    public SysUerApi(SysUserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Api(name = "findUserList")
    @ApiDocMethod(description = "获取用户列表")
    public List<SysUser> findUserList(){
        return userMapper.selectList(new EmptyWrapper<>());
    }
}
