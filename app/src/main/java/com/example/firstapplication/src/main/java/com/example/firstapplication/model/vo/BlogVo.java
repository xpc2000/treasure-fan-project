package com.example.firstapplication.model.vo;

public class BlogVo {
    private String userId;
    private String title;
    private String summary;
    private String content;


    public BlogVo(String userId,String title,String summary,String content){
        this.userId=userId;
        this.title=title;
        this.summary=summary;
        this.content=content;
    }

    public String getUserid() {
        return userId;
    }

    public void setUserid(String userid) {
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
