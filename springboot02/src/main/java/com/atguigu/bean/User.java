package com.atguigu.bean;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "user")
public class User {
    @Id
    //开启主键自动回填
    @KeySql(useGeneratedKeys = true)
    private Integer id;
    private String username;
    private String password;

}
