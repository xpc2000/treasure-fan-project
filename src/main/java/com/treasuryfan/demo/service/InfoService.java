package com.treasuryfan.demo.service;


import com.treasuryfan.demo.model.vo.InfoVo;


public interface InfoService {
    boolean checkPassword(InfoVo infoVo);
    int updatePassword(InfoVo infoVo);



}
