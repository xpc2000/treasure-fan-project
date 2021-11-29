package com.treasuryfan.demo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.*;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
class BlogControllerTest {
private MockMvc mvc;
@Autowired
private WebApplicationContext wac;
    @Test
    void allBlogs() {
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();
        RequestBuilder request = MockMvcRequestBuilders.get("http://127.0.0.1:8081/article/querylist?ticket=9008bui56gl6ikp0j9ik789ll");
        try {
            String response = mvc.perform(request).andReturn().getResponse().getContentAsString();
            System.out.println(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void add() {

    }

    @Test
    void delete() {
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();
        RequestBuilder request = MockMvcRequestBuilders.delete("http://127.0.0.1:8081/article/del?ticket=9008bui56gl6ikp0j9ik789ll");
        try {
            String response = mvc.perform(request).andReturn().getResponse().getContentAsString();
            System.out.println(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void personalBlogs() {
    }

    @Test
    void designateBlog() {
    }
}