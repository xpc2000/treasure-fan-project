package com.treasuryfan.demo.model.bo;

import java.util.Date;

public class CommentShow {
    //    private String username;
    private String content;
    private String userid;
    private String blogid;
    private String date;
    private String commentid;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getBlogid() {
        return blogid;
    }

    public void setBlogid(String blogid) {
        this.blogid = blogid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCommentid() {
        return commentid;
    }

    public void setCommentid(String commentid) {
        this.commentid = commentid;
    }

    public CommentShow(String content, String userid, String blogid, String date, String commentid) {
        this.content = content;
        this.userid = userid;
        this.blogid = blogid;
        this.date = date;
        this.commentid = commentid;
    }

    @Override
    public String toString() {
        return "CommentShow{" +
                "content='" + content + '\'' +
                ", userid=" + userid +
                ", blogid=" + blogid +
                ", date=" + date +
                ", commentid=" + commentid +
                '}';
    }
}