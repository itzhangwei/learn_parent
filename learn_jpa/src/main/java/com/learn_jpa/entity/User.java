package com.learn_jpa.entity;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity//标记实体类,可以自定义指定实体类的名称,不指定默认是类名称
@Table(name = "user") //指定实体类关联的表的名称
public class User {
    //列的注解可以标记在属性的头上,也可以标记在get方法的头上
    @Id         //指定id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//指定主键的生成策略,默认是AUTO这样的,自动增长,
    // IDENTITY根据底层数据库自己决定主键增长策略
    private Long uid;

    @Column(name = "username"/**,unique = false,nullable = false,insertable = true*/,
            length = 20
    )/*name:对应数据库列的名称,unique是否唯一,nullable是否可以为null,
    insertable在执行插入的SQL语句时是否需要插入该列的值,
    length:允许的最大长度*/
    private String name;

    @Column(name = "sex")
    private char sex;

    @Column(name = "age")
    private Integer age;

    @Column(name = "birthday")
    @Temporal(TemporalType.DATE)//时间类型注解,TemporalType.DATE精确到年月日,time精确到时分秒,TIMESTAMP默认,年月日时分秒
    private Date birthday;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }


}
