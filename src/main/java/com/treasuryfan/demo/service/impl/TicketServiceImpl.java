package com.treasuryfan.demo.service.impl;

import com.treasuryfan.demo.service.TicketService;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements TicketService {
    @Override
    public Long createTicket(String userName) {
        return null;
    }

    @Override
    public boolean checkTicket(Long ticketId) {
        return false;
    }



    @Override
    public void deleteTicket(Long ticketID) {

    }

    @Override
    public Long findTicket(String userName) {
        return null;
    }
}
