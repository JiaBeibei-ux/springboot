package com.atguigu.config;

import com.atguigu.interceptor.MyInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Slf4j
public class MvcConfig implements WebMvcConfigurer {

    //注册到 加入到容器中
    @Bean
    public MyInterceptor myInterceptor(){
        log.debug("MyInterceptor...");
        return new MyInterceptor();
    }
    //将自定义拦截器添加到拦截器链中
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptor()).addPathPatterns("/*");
    }
}
