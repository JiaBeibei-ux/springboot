package com.atguigu.service;

import com.atguigu.bean.User;
import com.atguigu.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserService {
    @Autowired
    private UserMapper userMapper;

    //根据id查询的
    @GetMapping("/user/{id}")
    public User queryByid(@PathVariable Long id){
        return userMapper.selectByPrimaryKey(id);
    }
    @Transactional
    public void saveUser(User user){
        System.out.println("新增用户。。。。");
    }
}
