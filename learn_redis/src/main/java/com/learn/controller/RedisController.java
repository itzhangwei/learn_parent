package com.learn.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedisController {
    @RequestMapping("/talkJsp")
    public String talkJsp(){
        return "talk";
    }
}
