package com.treasuryfan.demo.dao;

import com.treasuryfan.demo.mapper.UserMapper;
import com.treasuryfan.demo.model.bo.UserBo;
import com.treasuryfan.demo.model.pojo.User;
import com.treasuryfan.demo.model.pojo.UserExample;
import com.treasuryfan.demo.model.vo.RegisterUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {

    @Autowired
    UserMapper userMapper;
    /**
     * @Author: 谢沛辰
     * @Date: 2021/11/23
      *@Param: String userName
     *@Return: UserBo
     *@Description: 查找用户
     */
    public UserBo findUser(String userName){
        //用Mapper去查找,参数为UserExample
        UserExample userExample=new UserExample();
        UserExample.Criteria criteria=userExample.createCriteria();
        criteria.andUsernameEqualTo(userName);
        List<User> userList=userMapper.selectByExample(userExample);
        if (userList.size()==0)
            return null;
        //选取User列表中的第一个回传
        return new UserBo(userList.get(0).getUsername(),userList.get(0).getPassword());

    }

    /**
     * @Author: 谢沛辰
     * @Date: 2021/11/23
      *@Param: RegisterUserVo
     *@Return: int
     *@Description: 注册时添加用户
     */
    public int addUser(RegisterUserVo userVo){
        //先将Vo转换成对应的pojo，而后用mapper去完成insert
        User user=new User();
        user.setUsername(userVo.getUserName());
        user.setPassword(userVo.getPassword());
        user.setEmail(userVo.getEmail());
        user.setAvatar("https://www.XXXX.com/user");
        userMapper.insertSelective(user);
        return 0;
    }

    /**
     * @Author：ps
     * @Date: 2021.11.24
     * @Description: 根据用户名查找用户id，返回一个long id
     */

    public User findUserByUsername(String username) {
        UserExample userExample=new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(username);

        List<User> userList=userMapper.selectByExample(userExample);

        return userList.get(0);
    }




}
