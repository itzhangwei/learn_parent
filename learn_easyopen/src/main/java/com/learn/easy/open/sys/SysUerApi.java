package com.learn.easy.open.sys;

import com.baomidou.mybatisplus.core.conditions.query.EmptyWrapper;
import com.gitee.easyopen.annotation.Api;
import com.gitee.easyopen.annotation.ApiService;
import com.gitee.easyopen.doc.annotation.ApiDocMethod;
import com.learn.entity.SysUserEntity;
import com.learn.mapper.sys.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;

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
@ApiService()
public class SysUerApi {

    private final SysUserMapper userMapper;

    @Autowired
    public SysUerApi(SysUserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Api(name = "findUserList")
    @ApiDocMethod(description = "获取用户列表")
    public List<SysUserEntity> findUserList(){
        return userMapper.selectList(new EmptyWrapper<>());
    }
}
