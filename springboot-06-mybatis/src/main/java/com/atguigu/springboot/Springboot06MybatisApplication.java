package com.atguigu.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.atguigu.springboot.mapper")
public class Springboot06MybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot06MybatisApplication.class, args);
    }

}
