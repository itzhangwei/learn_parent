package com.learn_jpa.controller;

import com.learn_jpa.entity.User;
import com.learn_jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserRepository repository;

    @RequestMapping("/user/save")
    @ResponseBody
    public User saveUser() {
        User user = new User();
        user.setAge(20);
        user.setBirthday(new Date());
        user.setName("lisi");
        user.setSex('1');
        //调用方法
        User saveUser = repository.save(user);
        return saveUser;
    }

    @RequestMapping("/user/findByAge")
    @ResponseBody
    public List<User> findUserByAge() {
        List<User> list = repository.findByAgeBetween(18, 20);
        return list;
    }

    @RequestMapping("/user/all")
    @ResponseBody
    public List<User> findAll() {
        List<User> list = repository.myAll();
        return list;
    }
}
