package com.example.firstapplication.model.response;

import com.example.firstapplication.model.BlogPreview;

import java.util.List;

public class ReturnPreviews {
    private Integer conde;
    private String message;
    private List<BlogPreview> previews;

    public void setConde(Integer conde) {
        this.conde = conde;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setPreviews(List<BlogPreview> previews) {
        this.previews = previews;
    }

    public Integer getConde() {
        return conde;
    }

    public String getMessage() {
        return message;
    }

    public List<BlogPreview> getPreviews() {
        return previews;
    }
}
