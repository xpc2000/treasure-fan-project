package com.treasuryfan.demo.dao;

import com.treasuryfan.demo.model.pojo.Comment;

public interface CommentMapper {
    int deleteByPrimaryKey(Long commentid);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Long commentid);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKeyWithBLOBs(Comment record);

    int updateByPrimaryKey(Comment record);
}