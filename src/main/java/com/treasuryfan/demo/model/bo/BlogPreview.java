package com.treasuryfan.demo.model.bo;

import java.util.Date;
//返回给前端的预览文章类；
public class BlogPreview {
    private String blogId;
    private String title;
    private String summary;
    private String createDate;

    @Override
    public String toString() {
        return "BlogPreview{" +
                "blogid=" + blogId +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", createDate=" + createDate +
                '}';
    }

    public String getBlogid() {
        return blogId;
    }

    public void setBlogid(String blogId) {
        this.blogId = blogId;
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

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public BlogPreview(String blogId, String title, String summary, String createDate) {
        this.blogId = blogId;
        this.title = title;
        this.summary = summary;
        this.createDate = createDate;
    }
}
