package com.atguigu.config;

import com.atguigu.service.SysHelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 这是一个配置类
 */
@Configuration
public class MyappConfig {

    @Bean
    public SysHelloService sysHelloService(){
        System.out.println("配置类@Bean给容器。。。");
        return new SysHelloService();
    }
}
