package com.atguigu.springboot;

import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

public class BootTest {
    @Resource
    private static RedisTemplate redisTemplate;

    public static void main(String[] args) {
            redisTemplate.opsForValue().append("msg","hello");
    }
}
