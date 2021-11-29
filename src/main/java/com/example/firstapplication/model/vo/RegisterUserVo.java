package com.example.firstapplication.model.vo;

public class RegisterUserVo {
    private String email;
    private String userName;
    private String password;

    public RegisterUserVo(String email,String userName,String password){
        this.email=email;
        this.userName=userName;
        this.password=password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
