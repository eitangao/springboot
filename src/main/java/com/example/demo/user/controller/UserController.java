package com.example.demo.user.controller;


import com.example.demo.user.entity.JsonResult;
import com.example.demo.user.entity.User;
import com.example.demo.user.service.DESCryptography;
import com.example.demo.user.service.DESCryptographyImpl;
import com.example.demo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

@RestController
@RequestMapping(value = "/user")
public class UserController implements Serializable{
    @Autowired
    private UserService userServiceImpl;
    @Autowired
    private DESCryptography desCryptographyImpl;
    String key="01234567";
    @RequestMapping("/getUser")
    public String getUser() {
        return "test user controller";
    }
    @RequestMapping(value="/register/{userName}/{password}/{password2}")
    public ResponseEntity<JsonResult> register(@PathVariable(value = "userName") String userName,
                                               @PathVariable(value = "password") String password,
                                               @PathVariable(value = "password2") String password2){
        JsonResult r=new JsonResult();
        try{
            if(password.equals(password2)==false){
                r.setStatus("ok");
                r.setResult("Please enter the same password!");
            }
            else if(userServiceImpl.getUserByName(userName)!=null){
                r.setResult("The userName has already existed!");
                r.setStatus("ok");
            }
            else{
//                password=desCryptographyImpl.byteToHexString
//                        (desCryptographyImpl.encrypt(password.getBytes(),key.getBytes()));
                password=new String(desCryptographyImpl.encrypt(password.getBytes(),key.getBytes()));
                User user=new User(userName,password);
                userServiceImpl.addUser(user);
                r.setResult("Register successfully!");
                r.setStatus("ok");
            }
        }catch(Exception e){
            r.setResult(e.getClass().getName()+":"+e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);

    }
    @RequestMapping(value="/login/{userName}/{password}")
    public ResponseEntity<JsonResult> login(@PathVariable String userName,@PathVariable String password){
        JsonResult r=new JsonResult();
        try{
            User user=userServiceImpl.getUserByName(userName);
//            String decPassword=desCryptographyImpl.byteToHexString
//                    (desCryptographyImpl.decrypt(user.getPassword(),key.getBytes()));
            String decPassword=new String(desCryptographyImpl.decrypt(user.getPassword().getBytes(),key.getBytes()));
            if(user==null){
                r.setResult("User "+userName+" does not exist!");
            }
            else{
                if(decPassword.equals(password)==false){
                    r.setResult("Wrong password!");
                }
                else{
                    r.setResult("Login successfully!");
                }
            }
            r.setStatus("ok");
        }catch(Exception e){
            r.setResult(e.getClass().getName()+":"+e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

}
