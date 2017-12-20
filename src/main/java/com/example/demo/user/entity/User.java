package com.example.demo.user.entity;

import java.util.Date;

public class User {
    int id;
    String userName;
    String password;
    Date ctm;
    public User(){
    }
    public User(String userName,String password){
        this.userName=userName;
        this.password=password;
        this.ctm=new Date();
    }

    public Date getCtm() {
        return ctm;
    }

    public void setCtm(Date ctm) {
        this.ctm = ctm;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
