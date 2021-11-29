package com.treasuryfan.demo.service;

import com.treasuryfan.demo.model.vo.LoginUserVo;
import com.treasuryfan.demo.model.vo.RegisterUserVo;

public interface UserService {
    int addUser(RegisterUserVo userVo);
    boolean accountCheck(LoginUserVo userVo);
    String findUserid(LoginUserVo userVo);
    String findEmail(LoginUserVo userVo);

}
