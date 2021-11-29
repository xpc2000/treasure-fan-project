package com.treasuryfan.demo.model.bo;

import java.util.List;

public class BlogDetail {
    private Long blogid;
    private String title;
    private String content;
    private List<CommentShow> commentShowList;

    public Long getBlogid() {
        return blogid;
    }

    public void setBlogid(Long blogid) {
        this.blogid = blogid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<CommentShow> getCommentShowList() {
        return commentShowList;
    }

    public void setCommentShowList(List<CommentShow> commentShowList) {
        this.commentShowList = commentShowList;
    }

    public BlogDetail(Long blogid, String title, String content, List<CommentShow> commentShowList) {
        this.blogid = blogid;
        this.title = title;
        this.content = content;
        this.commentShowList = commentShowList;
    }

    @Override
    public String toString() {
        return "BlogDetail{" +
                "blogid=" + blogid +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", commentShowList=" + commentShowList +
                '}';
    }
}
