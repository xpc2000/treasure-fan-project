package com.example.firstapplication.model;

import java.io.Serializable;

public class CommentShow implements Serializable {
    private String content;
    private String userId;
    private String blog_id;
    private String date;
    private String commentId;

    public CommentShow(String content,String userId,String blog_id,String date,String commentId){
        this.content=content;
        this.userId=userId;
        this.blog_id=blog_id;
        this.date=date;
        this.commentId=commentId;
    }

    public String getDate() {
        return date;
    }

    public String getUserId() {
        return userId;
    }

    public String getBlog_id() {
        return blog_id;
    }

    public String getCommentId() {
        return commentId;
    }

    public String getContent() {
        return content;
    }
}
