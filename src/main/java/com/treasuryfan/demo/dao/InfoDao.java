package com.treasuryfan.demo.dao;

import com.treasuryfan.demo.mapper.UserMapper;
import com.treasuryfan.demo.model.pojo.User;
import com.treasuryfan.demo.model.pojo.UserExample;
import com.treasuryfan.demo.model.vo.InfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InfoDao {
    @Autowired
    UserMapper userMapper;

    /**
     * @Author：ps
     * @Date: 2021.11.24
     * @Description: 根据用户id查找用户，返回一个user对象
     */

    public User findUser(long userid) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUseridEqualTo(userid);

        List<User> userList = userMapper.selectByExample(userExample);

        return userList.get(0);
    }

    /**
     * @Author：ps
     * @Date: 2021.11.26
     * @Description: 更改用户密码
     */
    public int updatePassword(InfoVo infoVo) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUseridEqualTo(infoVo.getUserid());
        User user = new User();
        user.setPassword(infoVo.getModifyPassword());
        user.setUserid(infoVo.getUserid());
        userMapper.updateByExampleSelective(user,userExample);
        return 0;



    }
}
