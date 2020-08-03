package com.atguigu.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * springboot默认支持两种技术来和es交
 * 1、jest（默认不生效）
 * 需要导入jest的工具包
 * 2、springboot es
 *   client clusterNodes clusterName
 *   esTemplate
 */
@SpringBootApplication
public class Springboot03DataEsApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot03DataEsApplication.class, args);
    }

}
