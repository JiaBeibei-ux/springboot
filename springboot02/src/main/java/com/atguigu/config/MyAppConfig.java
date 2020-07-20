package com.atguigu.config;

import com.atguigu.interceptor.MyInterceptor;
import com.atguigu.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyAppConfig {

    @Bean
    public HelloService helloService(){
        System.out.println("配置类@Bean给容器中添加组建了");
        return new HelloService();
    }

}
