package com.atguigu.springboot.controller;

import com.atguigu.bean.Person2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@RestController
//@ImportResource(value = {"classpath:bean.xml"})
public class HelloController {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private Person2 person2;
    @Autowired
    private ApplicationContext ioc;
    @RequestMapping("/hello")
    public String hello(){
        System.out.println("dataSource :"+dataSource);
        boolean b = ioc.containsBean("helloService");
        System.out.println(b);
        System.out.println(person2);
        return "Hello World!";
    }
}
