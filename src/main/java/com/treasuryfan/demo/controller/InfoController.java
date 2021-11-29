package com.treasuryfan.demo.controller;


import com.treasuryfan.demo.model.vo.InfoVo;
import com.treasuryfan.demo.service.InfoService;
import com.treasuryfan.demo.service.TicketService;
import com.treasuryfan.demo.util.ResponseCode;
import com.treasuryfan.demo.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class InfoController {
    @Autowired
    private TicketService ticketService;
    @Autowired
    private InfoService infoService;

    /**
     * @Author：ps
     * @Date: 2021.11.24
     * @Description: 修改密码
     */
    @RequestMapping(value = "/updatepassword",method = RequestMethod.POST)
    public Result changePassword(@RequestParam("ticket")String ticket,@RequestBody InfoVo infoVo){
       boolean checkPassword = infoService.checkPassword(infoVo);
       boolean checkTicket = ticketService.checkTicket(ticket);
       if(checkPassword & checkTicket){
           infoService.updatePassword(infoVo);
           return new Result(ResponseCode.OK);
        } else {
            return new Result(ResponseCode.LoginFailure);
        }
    }

}