package com.example.firstapplication.model.vo;

public class CommentUserVo {
    private String content;
    private Long blogid;
    private Long userId;

    public Long getUerId() {
        return userId;
    }

    public String getContent() {
        return content;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getBlogid() {
        return blogid;
    }

    public CommentUserVo(String content,Long blogid,Long userId){
        this.content=content;
        this.blogid=blogid;
        this.userId=userId;
    }
}
