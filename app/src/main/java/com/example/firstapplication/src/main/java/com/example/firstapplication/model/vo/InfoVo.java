package com.example.firstapplication.model.vo;

import android.icu.text.IDNA;

public class InfoVo {
    private Long userid;
    private String password;
    private String modifyPassword;

    public InfoVo(Long userid,String password,String modifyPassword){
        this.userid=userid;
        this.password=password;
        this.modifyPassword=modifyPassword;
    }
}
