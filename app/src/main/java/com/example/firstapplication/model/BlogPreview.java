package com.example.firstapplication.model;

public class BlogPreview {
    private String title;
    private String date;
    private String summary;

    public BlogPreview(String title, String date,String abstractContent){
        this.title=title;
        this.date=date;
        this.summary =abstractContent;
    }

    public String getTitle() {
        return title;
    }

    public String getSummary() {
        return summary;
    }

    public String getDate() {
        return date;
    }
}
