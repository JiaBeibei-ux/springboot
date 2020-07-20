package com.atguigu.springboot;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot03LoggingApplicationTests {
    //记录器
    Logger logger = LoggerFactory.getLogger(getClass());
    @Test
    void contextLoads() {
        //System.out.println(""); 日志级别
        logger.trace("轨迹");
        logger.debug("调试");
        //默认级别
        logger.info("信息");
        logger.warn("警告");
        logger.error("错误");
    }

}
