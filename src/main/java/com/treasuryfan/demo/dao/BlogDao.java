package com.treasuryfan.demo.dao;


import com.treasuryfan.demo.mapper.BlogMapper;
import com.treasuryfan.demo.mapper.UserMapper;
import com.treasuryfan.demo.model.pojo.*;
import com.treasuryfan.demo.model.vo.BlogVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class BlogDao {
    @Autowired
    BlogMapper blogMapper;
    @Autowired
    UserMapper userMapper;


    /**
     * @Author: 夏海龙
     * @Date: 2021/11/24
     * @param blogVo
     * @return
     * @Description：添加博文；
     */
    public int addBlog(BlogVo blogVo){
        Blog blog = new Blog();
        blog.setTitle(blogVo.getTitle());
        blog.setSummary(blogVo.getSummary());
        blog.setContent(blogVo.getContent());
        blog.setUserid(blogVo.getUserid());
        Date date = new Date();
        blog.setCreateDate(date);
        blog.setCommentNum(0L);
        blogMapper.insertSelective(blog);
        return 0;

    }
    /**
     * @Author: 夏海龙
     * @Date: 2021/11/24
     * @param blogid
     * @return
     * @Description：删除博文；
     */
    public int deleteBlog(Long blogid){
        blogMapper.deleteByPrimaryKey(blogid);
        return 0;
    }
    /**
     * @Author: 夏海龙
     * @Date: 2021/11/24
     * @param
     * @return
     * @Description：拉取所有博文；
     */
    public List<Blog> showAllBlogs(){
        BlogExample blogExample = new BlogExample();
        BlogExample.Criteria criteria = blogExample.createCriteria();
        criteria.andBlogidIsNotNull();
        List<Blog> blogs = blogMapper.selectByExample(blogExample);
        //为防止某属性为空的现象再次发生，打上补丁，逐个搜索，若问题解决以下代码可删除
        List<Blog> blogs1=new ArrayList<>();
        for (Blog blog : blogs) {blogs1.add(blogMapper.selectByPrimaryKey(blog.getBlogid()));}
        return blogs1;
    }
    /**
     * @Author: xhl
     * @Date: 2021/11/24
     * @param userid
     * @return
     * @Description：查看个人博文；
     */
    public List<Blog> viewPersonalBlog(Long userid){
        BlogExample blogExample = new BlogExample();
        BlogExample.Criteria criteria = blogExample.createCriteria();
        criteria.andUseridEqualTo(userid);
        List<Blog> blogs = blogMapper.selectByExample(blogExample);
        //为防止某属性为空的现象再次发生，打上补丁，逐个搜索，若问题解决以下代码可删除
        List<Blog> blogs1=new ArrayList<>();
        for (Blog blog : blogs) {blogs1.add(blogMapper.selectByPrimaryKey(blog.getBlogid()));}
        return blogs1;
    }
//    public List<Blog> viewPersonalBlog(String username){
//        UserExample userExample = new UserExample();
//        UserExample.Criteria criteria = userExample.createCriteria();
//        criteria.andUsernameEqualTo(username);
//        List<User> users = userMapper.selectByExample(userExample);
//        Long userid = users.get(0).getUserid();
//        BlogExample blogExample = new BlogExample();
//        BlogExample.Criteria criteriaa = blogExample.createCriteria();
//        criteria.andUseridEqualTo(userid);
//        List<Blog> blogs = blogMapper.selectByExample(blogExample);
//
//        return blogs;
//
//    }
    /**
     * @Author: xhl
     * @Date: 2021/11/24
     * @param blogid
     * @return
     * @Description：查看指定博文；
     */
    public Blog designateBlog(Long blogid){
        return blogMapper.selectByPrimaryKey(blogid);
    }
    /**
     * @Author: xhl
     * @Date: 2021/11/24
     * @param blogid
     * @return
     * @Description：寻找博文作者名称；
     */

    public Long findBlogAuthorId(Long blogid){
        Blog blog = blogMapper.selectByPrimaryKey(blogid);
        return blog.getUserid();
    }

}
