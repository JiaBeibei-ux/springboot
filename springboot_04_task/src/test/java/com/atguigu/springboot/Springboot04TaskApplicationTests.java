package com.atguigu.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class Springboot04TaskApplicationTests {

    @Autowired
    JavaMailSenderImpl mailSender;
    @Test
    void contextLoads() {
        SimpleMailMessage message = new SimpleMailMessage();
        //邮件设置
        message.setSubject("通知——今晚开会");
        message.setText("今晚7:30开会");
        message.setTo("18336987535@163.com");
        message.setFrom("2855923051@qq.com");
        mailSender.send(message);
    }

    @Test
    public void test2() throws Exception{
        //复杂消息邮件
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        //SimpleMailMessage message = new SimpleMailMessage();
        //邮件设置
        helper.setSubject("通知——今晚开会");
        helper.setText("<b style='color:red'>今晚7:30开会</b>",true);
        helper.setTo("18336987535@163.com");
        helper.setFrom("2855923051@qq.com");
        //上传附件
        helper.addAttachment("1.jpg",new File("D:\\yk_temp\\quartz2.JPG"));
        mailSender.send(message);
    }
}
