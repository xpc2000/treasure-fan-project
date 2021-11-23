package com.treasuryfan.demo.service.impl;

import com.treasuryfan.demo.dao.TicketDao;
import com.treasuryfan.demo.model.bo.TicketBo;
import com.treasuryfan.demo.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    TicketDao ticketDao;
    /**
     * @Author: 谢沛辰
     * @Date: 2021/11/23
      *@Param: String userName
     *@Return: String ticket
     *@Description: 创建ticket
     */
    @Override
    public String createTicket(String userName) {
        //先找到之前的ticket，然后把之前的ticket删除，再创建一个新的ticket
        TicketBo ticketBo=ticketDao.findTicketByName(userName);
        int daoResult=0;
        if (ticketBo!=null)
            daoResult = ticketDao.DeleteTicket(ticketBo.getTicket());

        return ticketDao.addTicket(userName);
    }

    /**
     * @Author: 谢沛辰
     * @Date: 2021/11/23
      *@Param: String ticket
     *@Return: boolean
     *@Description: 检验ticket是否有效
     */
    @Override
    public boolean checkTicket(String ticket) {
        Date date=new Date();
        Date expired=ticketDao.getExpiredtime(ticket);
        if(date.after(expired)) {
            int i = ticketDao.DeleteTicket(ticket);
            return false;
        }
        return true;
    }

    /**
     * @Author: 谢沛辰
     * @Date: 2021/11/23
      *@Param: String ticket
     *@Return: int
     *@Description: 退出时注销ticket
     */
    @Override
    public void deleteTicket(String ticket) {
        ticketDao.DeleteTicket(ticket);
    }

}
