package com.treasuryfan.demo.util;

public enum ResponseCode {
    OK(0, "成功"),
    NoLogin(601, "未登录，无法进行该操作"),
    UserNameOccupied(602, "用户名已被占用"),
    ErrorEmail(603, "邮箱错误"),
    ErrorPassword(604, "密码格式不符合要求"),
    LoginFailure(605, "用户名或密码错误"),
    AlreadyLogin(606,"请不要重复登录"),

    UnknownFailure(900, "未知错误");

    private int code;
    private String message;

    ResponseCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
