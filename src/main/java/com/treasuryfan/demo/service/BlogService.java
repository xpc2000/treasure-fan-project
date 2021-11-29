package com.treasuryfan.demo.service;

import com.treasuryfan.demo.model.pojo.Blog;
import com.treasuryfan.demo.model.vo.BlogVo;

import java.util.List;

/**
 * author:夏海龙
 * date：11/24
 */
public interface BlogService {
    int upBlog(BlogVo blogVo);
    List<Blog> showBlogs();
    int deleteBlog(Long blogid);
    List<Blog> personalBlogs(Long userid);
    Blog showDesignateBlog(Long blogid);
    Long findUserid(Long blogid);

}