package com.treasuryfan.demo.model.vo;

import com.treasuryfan.demo.model.pojo.Blog;
import jdk.jfr.DataAmount;
import lombok.Data;

import java.util.Date;

@Data
public class BlogVo {
    private Long userId;
    private String title;
    private String summary;
    private String content;

    public Long getUserid() {
        return userId;
    }

    public void setUserid(Long userid) {
        this.userId = userid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}


