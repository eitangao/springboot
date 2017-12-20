package com.example.demo.user.mapper;

import com.example.demo.user.entity.User;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper {
//    @Select("select id,username from user where username=#{username}")
//    User findByUsername(@Param(value="username") String username);
    @Select("select * from user where id=#{id}")
    User getUserById(Integer id);
}
