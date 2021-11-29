package com.treasuryfan.demo.service.impl;


import com.treasuryfan.demo.dao.InfoDao;
import com.treasuryfan.demo.model.vo.InfoVo;
import com.treasuryfan.demo.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Service
public class InfoServiceImpl implements InfoService {
    @Autowired
    InfoDao infoDao;


    @Override
    public int updatePassword(InfoVo infoVo) {
        int result = infoDao.updatePassword(infoVo);
        if (result==0){
            return 0;
        }else {
            return 1;
        }
    }

    /**
     * @Author：ps
     * @Date: 2021.11.24
     * @Description: 验证输入的密码与登录密码是否匹配
     */
    @Override
    public boolean checkPassword(InfoVo infoVo) {

        boolean b = (Objects.equals(infoVo.getPassword(), infoDao.findUser(infoVo.getUserid()).getPassword()));
        if (b) {
            return true;
        }else {
            return false;
        }



    }





}
