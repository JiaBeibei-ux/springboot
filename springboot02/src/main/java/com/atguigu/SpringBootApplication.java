package com.atguigu;

import org.springframework.boot.SpringApplication;
import tk.mybatis.spring.annotation.MapperScan;

@org.springframework.boot.autoconfigure.SpringBootApplication
@MapperScan("com.atguigu.mapper")
public class SpringBootApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringBootApplication.class,args);
    }
}
