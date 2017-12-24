package com.example.demo.user.mapper;

import com.example.demo.user.entity.User;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper {
//    @Select("select id,username from user where username=#{username}")
//    User findByUsername(@Param(value="username") String username);
    @Select("select * from user where user_name=#{userName}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "password", column = "password"),
            @Result(property = "ctm", column = "create_time")
    })
    User getUserByName(String  userName);
    @Select("select id from user where user_name=#{userName}")
    @Results({
            @Result(property = "id",column = "id")
    })
    Integer getUserIdByName(String userName);
    @Insert("insert into user(user_name,password,create_time) values(#{userName},#{password},#{ctm})")
    void addUser(User user);

}
