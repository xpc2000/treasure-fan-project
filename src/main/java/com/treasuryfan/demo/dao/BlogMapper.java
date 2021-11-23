package com.treasuryfan.demo.dao;

import com.treasuryfan.demo.model.pojo.Blog;

public interface BlogMapper {
    int deleteByPrimaryKey(Long blogid);

    int insert(Blog record);

    int insertSelective(Blog record);

    Blog selectByPrimaryKey(Long blogid);

    int updateByPrimaryKeySelective(Blog record);

    int updateByPrimaryKeyWithBLOBs(Blog record);

    int updateByPrimaryKey(Blog record);
}