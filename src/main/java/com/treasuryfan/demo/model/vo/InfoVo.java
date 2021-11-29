package com.treasuryfan.demo.model.vo;


public class InfoVo {
    private Long userid;
//    private String ticket;//删去
    private String password;
    private String modifyPassword;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getModifyPassword() {
        return modifyPassword;
    }

    public void setModifyPassword(String modifyPassword) {
        this.modifyPassword = modifyPassword;
    }

//    public String getTicket() {
//        return ticket;
//    }
//
//    public void setTicket(String ticket) {
//        this.ticket = ticket;
//    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }


}
