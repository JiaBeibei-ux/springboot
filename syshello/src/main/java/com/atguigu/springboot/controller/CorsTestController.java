package com.atguigu.springboot.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CorsTestController {
    @GetMapping("/sysHello")
    //@CrossOrigin("https://blog.csdn.net")
    public String sysHello(){
        return "Hello World!--2";
    }
}
