package com.learn.mapper.sys;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.learn.entity.SysUser;
import org.springframework.stereotype.Repository;

/**
 * @author 张伟
 * @version V1.0.0
 * @projectName learn_parent
 * @title SysUserMapper
 * @package com.learn.mapper.sys
 * @description 后台用户mapper接口
 * @date 2018/12/25 16:05
 */
@Repository
public interface SysUserMapper extends BaseMapper<SysUser> {

}
