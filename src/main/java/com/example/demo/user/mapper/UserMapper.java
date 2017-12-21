package com.example.demo.user.mapper;

import com.example.demo.user.entity.User;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper {
//    @Select("select id,username from user where username=#{username}")
//    User findByUsername(@Param(value="username") String username);
    @Select("select * from user where id=#{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "password", column = "password"),
            @Result(property = "ctm", column = "create_time")
    })
    User getUserById(Integer id);
}
