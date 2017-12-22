package com.example.demo.user.controller;


import com.example.demo.user.entity.JsonResult;
import com.example.demo.user.entity.User;
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
    @RequestMapping("/getUser")
    public String getUser() {
        return "test user controller";
    }
    @RequestMapping(value="/{id}",method= RequestMethod.GET)
    public ResponseEntity<JsonResult> getUserById(@PathVariable(value="id")Integer id) {
        JsonResult r=new JsonResult();
        try{
            User user=userServiceImpl.getUserById(id);
            r.setResult(user);
            r.setStatus("ok");
        }catch(Exception e){
            r.setResult(e.getClass().getName()+":"+e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
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
            else if(userServiceImpl.getUserIdByName(userName)!=null){
                r.setResult("The userName has already existed!");
                r.setStatus("ok");
            }
            else{
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
            Integer id=userServiceImpl.getUserIdByName(userName);
            if(id==null){
                r.setResult("User "+userName+" does not exist!");
            }
            else{
                User user=userServiceImpl.getUserById(id);
                if(user.getPassword().equals(password)==false){
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
