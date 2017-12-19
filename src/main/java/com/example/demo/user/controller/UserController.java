package com.example.demo.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @RequestMapping("/getUser")
        public String getUser(){
            return "test user controller";

        }

}
