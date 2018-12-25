package com.learn;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 张伟
 * @version V1.0.0
 * @projectName learn_parent
 * @title MyBatisPlusPlugins
 * @package com.learn
 * @description 插件
 * @date 2018/12/25 15:28
 */
@Configuration
public class MyBatisPlusPlugins {

    /**
     * com.learn.MyBatisPlusPlugins.paginationInterceptor
     * @description mybatis分页插件 <BR>
     * @return PaginationInterceptor mybatis分页插件
     * @author 张伟
     * @createTime 2018/12/25 16:41
     * @version V1.0.0
     */
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }
}
