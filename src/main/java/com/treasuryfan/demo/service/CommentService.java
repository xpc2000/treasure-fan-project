package com.treasuryfan.demo.service;

import com.treasuryfan.demo.model.pojo.Comment;
import com.treasuryfan.demo.model.vo.CommentUserVo;

import java.util.List;

public interface CommentService {
    int addComment(CommentUserVo commentVo);
    int deleteComment(Long commentId);
    int deleteAllComment(Long blogid);
    List<Comment> showComments(Long blogid);
    List<Comment> findComment(Long blogid);
//    Long findUserid(Long userid);

}