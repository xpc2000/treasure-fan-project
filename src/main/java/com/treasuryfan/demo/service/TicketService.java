package com.treasuryfan.demo.service;

import com.treasuryfan.demo.model.pojo.Ticket;

public interface TicketService {
    String createTicket(String userName);
    boolean checkTicket(String ticketId);
    void deleteTicket(String ticket);
    String findUsernameByTicket(String ticket);

}
