package com.treasuryfan.demo.service.impl;


import com.treasuryfan.demo.dao.BlogDao;
import com.treasuryfan.demo.dao.CommentDao;
import com.treasuryfan.demo.dao.UserDao;
import com.treasuryfan.demo.model.bo.CommentBo;
import com.treasuryfan.demo.model.pojo.Comment;
import com.treasuryfan.demo.model.vo.CommentUserVo;
import com.treasuryfan.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: HXY
 * @Date: 2021/11/25
 * @Description: com.treasuryfan.demo.service.impl
 * @version: 1.0
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentDao commentDao;
    @Autowired
    BlogDao blogDao;
    @Autowired
    UserDao userDao;

    /**
     * @Author: hxy
     * @Date: 2021/11/25
     *@Return: int
     *@Description: 添加评论
     * @return
     * @param commentVo
     */
    @Override
    public int addComment(CommentUserVo commentVo) {
        int i=commentDao.addComment(commentVo);
        if (i==0){
            return 0;
        }else return 1;
    }

    /**
     * @Author: hxy
     * @Date: 2021/11/25
     *@Param: CommentUserVo
     *@Return: int
     *@Description: 删除评论
     *
     * @return*/
    @Override
    public int deleteComment(Long commentId) {
        CommentBo comment = commentDao.findComment(commentId);
        if (comment == null) {
            return 1;
        }
        return commentDao.delComment(commentId);
    }

    @Override
    public int deleteAllComment(Long blogid) {
       commentDao.delAllComment(blogid);
       return 0;
    }

    @Override
    public List<Comment> showComments(Long blogid) {
        List<Comment> commentList=commentDao.showAllComment(blogid);
        return commentList;
    }

    @Override
    public List<Comment> findComment(Long blogid) {
        List<Comment> comments=commentDao.showAllComment(blogid);
        return comments;
    }

//    @Override
//    public Long findUserid(Long commentid) {
//        Long commentAuthorId=commentDao.findCommentAuthorId(commentid);
//        return commentAuthorId;
//    }


}
