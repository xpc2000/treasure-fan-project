package com.treasuryfan.demo.dao;

import com.treasuryfan.demo.model.pojo.Ticket;

public interface TicketMapper {
    int deleteByPrimaryKey(Long ticketid);

    int insert(Ticket record);

    int insertSelective(Ticket record);

    Ticket selectByPrimaryKey(Long ticketid);

    int updateByPrimaryKeySelective(Ticket record);

    int updateByPrimaryKey(Ticket record);
}