package com.treasuryfan.demo.controller;

import com.treasuryfan.demo.model.vo.LoginUserVo;
import com.treasuryfan.demo.model.vo.RegisterUserVo;
import com.treasuryfan.demo.service.TicketService;
import com.treasuryfan.demo.service.UserService;
import com.treasuryfan.demo.util.ResponseCode;
import com.treasuryfan.demo.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author：谢沛辰
 * @Date: 2021.11.22
 * @Description: 注册登录控制器
 */

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private TicketService ticketService;
    /**
     * @Author：xiepeichen
     * @Date: 2021/11/22
      * @Param: RegisterUserVo
     * @Return: Result
     * @Description:注册接口
     */
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public @ResponseBody Result register(@RequestBody RegisterUserVo userVo){
        int serviceResult= userService.addUser(userVo);
        //数据库写入成功
        if(serviceResult==0){
            return new Result(ResponseCode.OK);
        }
        //用户名重复
        else if(serviceResult==1){
            return new Result(ResponseCode.UserNameOccupied);
        }
        //邮箱信息错误
        else if(serviceResult==2){
            return new Result(ResponseCode.ErrorEmail);
        }
        //密码不规范
        else if(serviceResult==3){
            return new Result(ResponseCode.ErrorPassword);
        }
        //其他严重错误
        else
            return new Result(ResponseCode.UnknownFailure);

    }

    /**
     * @Author: 谢沛辰
     * @Date: 2021/11/22
      *@Param: LoginUserVo
     *@Return: Result
     *@Description: 登录
     */
    @RequestMapping(value = "/login",method=RequestMethod.POST)
    public @ResponseBody Result login(@RequestBody LoginUserVo userVo){
        boolean serviceResult=userService.accountCheck(userVo);
        if(serviceResult){
            Long oldTicket=ticketService.findTicket(userVo.getUsername());
            String newTicket=ticketService.createTicket(userVo.getUsername());
            return new Result(ResponseCode.OK,newTicket);
        }
        else
            return new Result(ResponseCode.LoginFailure);

    }

    /**
     * @Author: 谢沛辰
     * @Date: 2021/11/22
      *@Param: Long ticketID
     *@Return: Result
     *@Description: 退出
     */
    @RequestMapping(value = "logout", method = RequestMethod.DELETE)
    public @ResponseBody Result logout(@RequestBody String ticketId){
        ticketService.deleteTicket(ticketId);
        return new Result(ResponseCode.OK);
    }
}
