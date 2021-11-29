package com.example.firstapplication.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BlogPreview implements Serializable {
    private String blogId;
    private String title;
    private String createDate;
    private String summary;


//    public BlogPreview(String blogId,String title, String date,String abstractContent){
//        this.blogId=blogId;
//        this.title=title;
//        this.createDate=date;
//        this.summary =abstractContent;
//    }

    public String getBlogId() {
        return blogId;
    }

    public String getTitle() {
        return title;
    }

    public String getSummary() {
        return summary;
    }

    public String getDate() {
        return createDate;
    }

}
