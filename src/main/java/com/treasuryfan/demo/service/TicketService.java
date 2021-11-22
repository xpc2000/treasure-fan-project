package com.treasuryfan.demo.service;

public interface TicketService {
    Long createTicket(String userName);
    boolean checkTicket(Long ticketId);
    void deleteTicket(Long ticketID);
    Long findTicket(String userName);
}
