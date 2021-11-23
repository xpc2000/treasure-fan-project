package com.treasuryfan.demo.model.bo;

import com.treasuryfan.demo.model.pojo.Ticket;

import java.util.Date;

public class TicketBo {
    private Long id;

    private String username;

    private Date expireTime;

    private Integer state;

    private String ticket;

    public TicketBo(String username,Date expiredTime,Integer state,String ticket,Long id){
        this.username=username;
        this.expireTime=expiredTime;
        this.state=state;
        this.ticket=ticket;
        this.id=id;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket == null ? null : ticket.trim();
    }
}
