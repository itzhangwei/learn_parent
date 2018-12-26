package com.learn.entity;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author 张伟
 * @version V1.0.0
 * @projectName learn_parent
 * @title SysUser
 * @package com.learn.entity
 * @description
 * @date 2018/12/25 15:56
 */
@Data
public class SysUser {
    private String id;
    private String companyId;
    private String officeId;
    private String loginName;
    private String password;
    private String no;
    private String name;
    private String email;
    private String phone;
    private String mobile;
    private String userType;
    private String photo;
    private String loginIp;
    private Timestamp loginDate;
    private String loginFlag;
    private String createBy;
    private Timestamp createDate;
    private String updateBy;
    private Timestamp updateDate;
    private String remarks;
    private String delFlag;
    private String qrcode;

}
