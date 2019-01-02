package com.learn;

import com.gitee.easyopen.ApiConfig;
import com.gitee.easyopen.interceptor.ApiInterceptor;
import com.learn.easy.open.config.interceptor.LogInterceptor;
import com.learn.easy.open.config.result.MyResultCreator;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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


    /**
     * 构造函数，注入该类下需要spring注入的一些依赖对象
     * @param apiConfig easy open的核心配置对象
     */
    @Autowired
    public DriverLearnEasy(ApiConfig apiConfig) {
        this.apiConfig = apiConfig;
    }

    /*
     * easy open的核心配置对象
     */
    private final ApiConfig apiConfig;
    


    /**
     * 增强，使用自定义easyOpen配置
     */
    @Bean
    public void strengthenApiConfig() {

        //使用自定义返回类
        apiConfig.setResultCreator(new MyResultCreator());

        //使用拦截器
        apiConfig.setInterceptors(
                new ApiInterceptor[]{new LogInterceptor()}
        );
    }
}
