package com.treasuryfan.demo.dao;

import com.treasuryfan.demo.mapper.CommentMapper;
import com.treasuryfan.demo.mapper.UserMapper;
import com.treasuryfan.demo.model.bo.CommentBo;
import com.treasuryfan.demo.model.pojo.Comment;
import com.treasuryfan.demo.model.pojo.CommentExample;
import com.treasuryfan.demo.model.vo.CommentUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class CommentDao {
    @Autowired
    CommentMapper commentMapper;
    @Autowired
    UserMapper userMapper;


    /**
     * @param commentVo
     * @Author: hxy
     * @Date: 2021/11/24
     * @Return: int
     * @Description: 添加评论
     */
    public int addComment(CommentUserVo commentVo) {
        Comment comment = new Comment();
        comment.setContent(commentVo.getContent());
        Date date=new Date();
        comment.setCreateTime(date);
        comment.setBlogid(commentVo.getBlogid());
        comment.setUserid(commentVo.getUserId());
        commentMapper.insertSelective(comment);
        return 0;
    }

    /**
     * @Author: hxy
     * @Date: 2021/11/24
     * @Param: String commentid
     * @Return: CommentBo
     * @Description: 查找评论
     */
    public CommentBo findComment(Long commentid) {
        CommentExample commentExample = new CommentExample();
        CommentExample.Criteria criteria = commentExample.createCriteria();
        criteria.andCommentidEqualTo(commentid);
        List<com.treasuryfan.demo.model.pojo.Comment> commentList = commentMapper.selectByExample(commentExample);
        if (commentList.size() == 0)
            return null;
        return new CommentBo(commentList.get(0).getContent(), commentList.get(0).getCreateTime());
    }

    /**
     * @Author: hxy
     * @Date: 2021/11/24
     * @Param: String
     * @Return: CommentBo commentBo
     * @Description: 删除特定评论
     */
    public int delComment(Long commentid) {
        commentMapper.deleteByPrimaryKey(commentid);
        return 0;
    }

    /**
     * @Author: ps
     * @Date: 2021.11.26
     * @Description：删除文章所有评论
     */
    public int delAllComment(Long blogid){
        CommentExample CommentExample = new CommentExample();
        CommentExample.Criteria criteria = CommentExample.createCriteria();
        criteria.andBlogidEqualTo(blogid);
        List<Comment> list=commentMapper.selectByExample(CommentExample);
        for(int i=0;i<list.size();i++){

            commentMapper.deleteByPrimaryKey(list.get(i).getCommentid());
        }
        return 0;
    }

    /**
     * @Author: ps
     * @Date: 2021.11.24
     * @Description：查看文章所有评论
     */
    public List<Comment> showAllComment(Long blogid) {
        CommentExample CommentExample = new CommentExample();
        CommentExample.Criteria criteria = CommentExample.createCriteria();
        criteria.andBlogidEqualTo(blogid);
        List<Comment> comments = commentMapper.selectByExample(CommentExample);
        List<Comment> comments1=new ArrayList<>();
        for(int i=0;i<comments.size();i++){ comments1.add(commentMapper.selectByPrimaryKey(comments.get(i).getCommentid()));}
        return comments1;

    }

    public Long findCommentAuthorId(Long commentid) {
        Comment comment=commentMapper.selectByPrimaryKey(commentid);
        return comment.getUserid();
    }




}
