package com.example.demo.user.service;

import com.example.demo.user.entity.User;

public interface UserService {
    User getUserByName(String  userName);
    Integer getUserIdByName(String userName);
    void addUser(User user);

}
