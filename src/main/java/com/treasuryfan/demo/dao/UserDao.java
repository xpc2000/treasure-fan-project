package com.treasuryfan.demo.dao;

import com.treasuryfan.demo.model.bo.User;
import com.treasuryfan.demo.model.vo.RegisterUserVo;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    public User findUser(String userName){
        //用Mapper去查找
        return new User();
    }

    public int addUser(RegisterUserVo userVo){
        //先将Vo转换成对应的pojo，而后用mapper去完成insert，根据不同情况返回不同的int值
        return 0;
    }
}
