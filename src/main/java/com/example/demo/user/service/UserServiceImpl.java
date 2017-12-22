package com.example.demo.user.service;

import com.example.demo.user.entity.User;
import com.example.demo.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;
    @Override
    public User getUserById(Integer id) {
        return userMapper.getUserById(id);
    }

    @Override
    public Integer getUserIdByName(String userName) {
        return userMapper.getUserIdByName(userName);
    }
    @Override
    public void addUser(User user) {
        userMapper.addUser(user);


    }

    {

    }
}
