package com.atguigu.springbootpmd.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResponseController {

    @GetMapping("/hello")
    public String test(){
        return "Hello World!";
    }
}
