package com.example.firstapplication.model.vo;

public class LoginUserVo {
    private String username;
    private String password;

    public LoginUserVo(){

    }

    public LoginUserVo(String username,String password){
        this.username=username;
        this.password=password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
