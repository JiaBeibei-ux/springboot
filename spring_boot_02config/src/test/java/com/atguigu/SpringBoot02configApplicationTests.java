package com.atguigu;

import com.atguigu.bean.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class SpringBoot02configApplicationTests {
    @Autowired
    Person person;
    @Autowired
    ApplicationContext ioc;
    @Test
    public void testHelloService(){
        boolean b = ioc.containsBean("sysHelloService");
        System.out.println(b);
    }
    @Test
    void contextLoads() {
        System.out.println(person);
    }

}
