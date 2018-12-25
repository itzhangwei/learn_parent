package com.learn;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 张伟
 * @version V1.0.0
 * @projectName learn_parent
 * @title DriverLearnEasy
 * @package com.learn
 * @description springboot启动类
 * @date 2018/12/25 17:39
 */
@SpringBootApplication
@EnableEncryptableProperties
@MapperScan(value = "com.learn.mapper.*")
public class DriverLearnEasy {
    public static void main(String[] args) {
        SpringApplication.run(DriverLearnEasy.class, args);
    }
}
