package com.example.firstapplication.model.response;

import com.example.firstapplication.model.BlogDetail;
import com.example.firstapplication.model.CommentShow;

import java.util.List;

public class ReturnDetails {
    private Integer conde;
    private String message;
    private BlogDetail blogDetail;
    private List<CommentShow> commentShows;

    public void setConde(Integer conde) {
        this.conde = conde;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setBlogDetail(BlogDetail blogDetail) {
        this.blogDetail = blogDetail;
    }

    public void setCommentShows(List<CommentShow> commentShows) {
        this.commentShows = commentShows;
    }

    public Integer getConde() {
        return conde;
    }

    public String getMessage() {
        return message;
    }

    public BlogDetail getBlogDetail() {
        return blogDetail;
    }

    public List<CommentShow> getCommentShows() {
        return commentShows;
    }
}
