package com.treasuryfan.demo.service.impl;

import com.treasuryfan.demo.dao.BlogDao;
import com.treasuryfan.demo.dao.UserDao;
import com.treasuryfan.demo.model.pojo.Blog;
import com.treasuryfan.demo.model.vo.BlogVo;
import com.treasuryfan.demo.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogDao blogDao;
    @Autowired
    UserDao userDao;
    @Override
    public int upBlog(BlogVo blogVo) {
        int result = blogDao.addBlog(blogVo);
        if (result == 0){
            return 0;
        }else return 1;

    }

    @Override
    public List<Blog> showBlogs() {
        List<Blog> blogList = blogDao.showAllBlogs();
        return blogList;
    }

    @Override
    public int deleteBlog(Long blogid) {
        blogDao.deleteBlog(blogid);
        return 0;


    }

    @Override
    public List<Blog> personalBlogs(Long userid) {
        List<Blog> blogs = blogDao.viewPersonalBlog(userid);
        return blogs;
    }

    @Override
    public Blog showDesignateBlog(Long blogid) {
        return blogDao.designateBlog(blogid);
    }

    @Override
    public Long findUserid(Long blogid) {
        Long blogAuthorId = blogDao.findBlogAuthorId(blogid);
        return blogAuthorId;
    }

}
