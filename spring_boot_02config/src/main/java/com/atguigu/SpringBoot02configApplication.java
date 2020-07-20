package com.atguigu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
//   @ImportResource(value ="classpath:bean.xml")
public class SpringBoot02configApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot02configApplication.class, args);
    }

}
