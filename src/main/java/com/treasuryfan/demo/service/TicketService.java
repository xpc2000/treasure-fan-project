package com.treasuryfan.demo.service;

public interface TicketService {
    String createTicket(String userName);
    boolean checkTicket(String ticketId);
    void deleteTicket(String ticket);
}
