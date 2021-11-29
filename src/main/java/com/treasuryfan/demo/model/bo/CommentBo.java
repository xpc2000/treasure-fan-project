package com.treasuryfan.demo.model.bo;

import java.util.Date;

/**
 * @Auther: HXY
 * @Date: 2021/11/24
 * @Description: com.treasuryfan.demo.model.bo
 * @version: 1.0
 */
public class CommentBo {

    private String content;
    private Date creat_date;
    private Long commentid;

    public CommentBo(){}

    public Long getCommentid() {
        return commentid;
    }

    public void setCommentid(Long commentid) {
        this.commentid = commentid;
    }

    public CommentBo( String content, Date creat_date){

        this.content=content;
        this.creat_date=creat_date;
    }



    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreat_date() {
        return creat_date;
    }

    public void setCreat_date(Date creat_date) {
        this.creat_date = creat_date;
    }
}
