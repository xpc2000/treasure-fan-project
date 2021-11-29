package com.example.firstapplication.model;

public class AccountInfo {
    static private String ticket;
    static private String userId;
    static private String userName;
    static private String email;
    static private String password;

    public static String getTicket() {
        return ticket;
    }

    public static String getUserId() {
        return userId;
    }

    public static void setTicket(String ticketId) {
        AccountInfo.ticket = ticketId;
    }

    public static void setUserId(String userId) {
        AccountInfo.userId = userId;
    }

    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        AccountInfo.userName = userName;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        AccountInfo.email = email;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        AccountInfo.password = password;
    }
}
