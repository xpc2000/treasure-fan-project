package com.treasuryfan.demo.service.impl;

import com.treasuryfan.demo.dao.UserDao;
import com.treasuryfan.demo.model.bo.User;
import com.treasuryfan.demo.model.vo.LoginUserVo;
import com.treasuryfan.demo.model.vo.RegisterUserVo;
import com.treasuryfan.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public int addUser(RegisterUserVo userVo) {
        //检查邮箱与密码格式是否正确
        String emailFormat = "\\p{Alpha}\\w{2,15}[@][a-z0-9]{3,}[.]\\p{Lower}{2,}";
        if (!userVo.getEmail().matches(emailFormat))
            return 2;
        if (userVo.getPassword().length()<=8||userVo.getPassword()==null)
            return 3;
        //if (!password.matches(".*[a-z]{1,}.*") ||!password.matches(".*[A-Z]{1,}.*") || !password.matches(".*\\d{1,}.*")
        //				|| !password.matches(".*[~!@#$%^&*\\.?]{1,}.*")) {
        //UserMapper检查用户名是否被占用
        User userFound= userDao.findUser(userVo.getUserName());
        if(userFound!=null)
            return 1;
        return userDao.addUser(userVo);

    }

    @Override
    public boolean accountCheck(LoginUserVo userVo) {
        //UserDao查找用户名,确定用户名是否存在
        User userFound= userDao.findUser(userVo.getUsername());
        if (userFound==null)
            return false;
        else
            //用户名存在后，校验密码是否正确
            if (!Objects.equals(userFound.getPassword(), userVo.getPassword()))
                return false;
        return true;
    }
}
