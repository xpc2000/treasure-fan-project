package com.treasuryfan.demo.dao;

import com.treasuryfan.demo.mapper.TicketMapper;
import com.treasuryfan.demo.model.bo.TicketBo;
import com.treasuryfan.demo.model.pojo.Ticket;
import com.treasuryfan.demo.model.pojo.TicketExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
public class TicketDao {
    @Autowired
    TicketMapper ticketMapper;

    /**
     * @Author: 谢沛辰
     * @Date: 2021/11/23
      *@Param: String userName
     *@Return: TicketBo
     *@Description: 通过用户名查找Ticket
     */
    public TicketBo findTicketByName(String userName){
        TicketExample ticketExample =new TicketExample();
        TicketExample.Criteria criteria=ticketExample.createCriteria();
        criteria.andUsernameEqualTo(userName);
        List<Ticket> tickets= ticketMapper.selectByExample(ticketExample);
        if(tickets.size()==0)
            return null;

        return new TicketBo(tickets.get(0).getUsername(),
                tickets.get(0).getExpireTime(),
                tickets.get(0).getState(),
                tickets.get(0).getTicket(),
                tickets.get(0).getTicketid()
        );
    }

    /**
     * @Author: 谢沛辰
     * @Date: 2021/11/23
      *@Param: String ticket
     *@Return: TicketBo
     *@Description: 通过Ticket查找Ticket
     */
    public TicketBo findTicketByTicket(String ticket){
        TicketExample ticketExample =new TicketExample();
        TicketExample.Criteria criteria=ticketExample.createCriteria();
        criteria.andUsernameEqualTo(ticket);
        List<Ticket> tickets= ticketMapper.selectByExample(ticketExample);
        if(tickets.size()==0)
            return null;

        return new TicketBo(tickets.get(0).getUsername(),
                tickets.get(0).getExpireTime(),
                tickets.get(0).getState(),
                tickets.get(0).getTicket(),
                tickets.get(0).getTicketid()
        );
    }

    /**
     * @Author: 谢沛辰
     * @Date: 2021/11/23
      *@Param: String userName
     *@Return: String
     *@Description: 登录时创建ticket
     */
    public String addTicket(String userName){
        Ticket ticket=new Ticket();
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        ticket.setTicket(uuid);
        ticket.setState(0);
        ticket.setUsername(userName);
        Date date= new Date();
        date.setTime(date.getTime()+30*60*1000);
        ticket.setExpireTime(date);
        ticketMapper.insertSelective(ticket);
        return uuid;
    }

    /**
     * @Author:
     * @Date: 2021/11/22
      *@Param: String ticket
     *@Return: Date
     *@Description: 获取ticket的有效截至时间
     */
    public Date getExpiredtime(String ticket){
        TicketExample ticketExample=new TicketExample();
        TicketExample.Criteria criteria = ticketExample.createCriteria();
        criteria.andTicketEqualTo(ticket);
        criteria.andStateEqualTo(0);
        List<Ticket> tickets=ticketMapper.selectByExample(ticketExample);
        if(tickets.size()==0)
            return null;
        return tickets.get(0).getExpireTime();
    }

    /**
     * @Author:
     * @Date: 2021/11/22
      *@Param:
     *@Return:
     *@Description: 登录时删除重复ticket或退出时删除ticket
     */
    public int DeleteTicket(String ticket){
        TicketExample ticketExample=new TicketExample();
        TicketExample.Criteria criteria =ticketExample.createCriteria();
        criteria.andTicketEqualTo(ticket);
        List<Ticket> tickets = ticketMapper.selectByExample(ticketExample);
        if (tickets.size()==0)
            return 0;
        Ticket oldTicket= tickets.get(0);
        Ticket newTicket= new Ticket();
        newTicket.setTicket(oldTicket.getTicket());
        newTicket.setUsername(oldTicket.getUsername());
        newTicket.setState(1);
        newTicket.setExpireTime(oldTicket.getExpireTime());
        newTicket.setTicketid(oldTicket.getTicketid());
        //注：返回值为0意味着失败，其他意味着成功
        return ticketMapper.updateByPrimaryKey(newTicket);
    }

}
