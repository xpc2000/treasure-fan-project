package com.treasuryfan.demo.model.bo;

public class UserBo {
    private String userName;
    private String password;

    public UserBo(){}

    public UserBo(String userName, String password){
        this.userName=userName;
        this.password=password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
