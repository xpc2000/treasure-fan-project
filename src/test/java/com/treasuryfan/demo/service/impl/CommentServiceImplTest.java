package com.treasuryfan.demo.service.impl;

import com.treasuryfan.demo.model.pojo.Comment;
import com.treasuryfan.demo.model.vo.CommentUserVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CommentServiceImplTest {
@Autowired
private CommentServiceImpl commentService;
//    @Test
//    void addComment() {
//        commentService.addComment(new CommentUserVo("hello",1L,2L));
//    }

    @Test
    void deleteComment() {
        commentService.deleteAllComment(1L);
    }

    @Test
    void deleteAllComment() {
        commentService.deleteAllComment(2L);
    }

    @Test
    void showComments() {
        List<Comment> comments = commentService.showComments(2L);
        System.out.println(comments);
    }

    @Test
    void findComment() {
    }
}