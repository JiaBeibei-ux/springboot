package com.atguigu.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController {
    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "Hello World!";
    }
    /*@RequestMapping({"/","/index.html"})
    public String index(){
        return "index";
    }*/

    @RequestMapping("/success")
    public String success(Map<String,Object> map){
        //classpath:/templates/
        map.put("hello","<h3>你好</h3>");
        map.put("users", Arrays.asList("Jack","Rose"));
        return "success";
    }
}
