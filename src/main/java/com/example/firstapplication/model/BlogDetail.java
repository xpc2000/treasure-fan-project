package com.example.firstapplication.model;

import java.io.Serializable;
import java.util.List;

public class BlogDetail implements Serializable {
    private String blogId;
    private String title;
    private String content;
    private List<CommentShow> commentShowList;

    public BlogDetail(){

    }

    public BlogDetail(String blogId,String title,String content){
        this.blogId=blogId;
        this.title=title;
        this.content=content;
    }
    public String getBlogId() {
        return blogId;
    }

    public String getTitle(){
        return this.title;
    }

    public String getContent(){
        return content;
    }

    public List<CommentShow> getCommentShowList() {
        return commentShowList;
    }

    public void setBlogId(String blogId) {
        this.blogId = blogId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCommentShowList(List<CommentShow> commentShowList) {
        this.commentShowList = commentShowList;
    }
}
