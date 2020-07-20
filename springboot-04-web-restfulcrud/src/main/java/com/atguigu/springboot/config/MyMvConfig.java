package com.atguigu.springboot.config;

import com.atguigu.springboot.component.MyLocalResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//@EnableWebMvc//全面接管springmvc
//使用WebMvcConfigurerAdapter扩展springmvc的功能
@Configuration
public class MyMvConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //super.addViewControllers(registry);
        //浏览器发送 /atguigu请求
        registry.addViewController("/atguigu").setViewName("success");
        //registry.addViewController("/index.html").setViewName("index");
    }
    //所有的webMvcConfigurerAdapter
    @Bean//作为组件加入容器
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter(){
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
            }
        };
        return adapter;
    }

    public LocaleResolver localeResolver(){
        return new MyLocalResolver();
    }
}
