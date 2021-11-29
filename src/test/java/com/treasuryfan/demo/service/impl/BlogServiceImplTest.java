package com.treasuryfan.demo.service.impl;

import com.treasuryfan.demo.DemoApplication;
import com.treasuryfan.demo.model.vo.BlogVo;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = DemoApplication.class)

class BlogServiceImplTest {

    @Autowired
    private BlogServiceImpl blogService;

//    @Test
//    void upBlog() {
//        BlogVo blogVo=new BlogVo(1L,"黑色星期五","test","test");
//        System.out.println(blogService.upBlog(blogVo));
//    }
    @Test
    void deleteBlog(){
        System.out.println(blogService.deleteBlog(1L));
    }
    @Test
    void showPersonalBlogs(){
        System.out.println(blogService.personalBlogs(1L));
    }
    @Test
    void showDesignateBlog(){
        System.out.println(blogService.showDesignateBlog(2L));
    }
}