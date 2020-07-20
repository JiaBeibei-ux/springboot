package com.atguigu.springboot.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {

    //@Scheduled(cron = "0/3 * * * * ?")
    //@Scheduled(cron="0,1,2,3,4 * * * * MON-SAT")
    //@Scheduled(cron="0-4 * * * * MON-SAT")
    @Scheduled(cron="0/2 * * * * MON-SAT")
    public void hello(){
        System.out.println("hello。。。");
    }
}
