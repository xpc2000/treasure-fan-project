package com.treasuryfan.demo.model.vo;

/**
 * @Auther: HXY
 * @Date: 2021/11/24
 * @Description: com.treasuryfan.demo.model.vo
 * @version: 1.0
 */
public class CommentUserVo {

    private  String content;
    private Long userId;
    private Long blogid;

//    public CommentUserVo(String content, Long userId, Long blogid) {
//        this.content = content;
//        this.userId = userId;
//        this.blogid = blogid;
//    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setBlogid(Long blogid) {
        this.blogid = blogid;
    }
    //    date属性要用Date
//    private static Date creat_date;//删去，由后台生成
//    private String ticket;
//    private Long commentid;//MySQL自动生成，删去




    public  String getContent() { return content; }

//    public static Date getCreat_date() {
//        return creat_date;
//    }



    public void setContent(String content) {
        this.content = content;
    }

//    public void setCreat_data(Date creat_data) {
//        this.creat_date = creat_data;
//    }

//    public String getTickets() {
//        return ticket;
//    }

    public Long getBlogid() {
        return blogid;
    }

//    public Long getCommentid() {
//        return commentid;
//    }

    public Long getUserId() {
        return userId;
    }

}
