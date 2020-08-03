package com.atguigu;

import com.atguigu.bean.Person;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;


public class BootTest {

    @Resource
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Test
    public void test(){
        Person person = new Person();
        System.out.println(person);
    }

    //字符串
    @Test
    public void test2(){
        stringRedisTemplate.opsForValue().append("msg","hello");
    }
}
