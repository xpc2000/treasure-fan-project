package com.treasuryfan.demo.controller;


import com.treasuryfan.demo.model.bo.BlogDetail;
import com.treasuryfan.demo.model.bo.BlogPreview;
import com.treasuryfan.demo.model.bo.CommentShow;
import com.treasuryfan.demo.model.pojo.Blog;
import com.treasuryfan.demo.model.pojo.Comment;
import com.treasuryfan.demo.model.vo.BlogVo;
import com.treasuryfan.demo.service.BlogService;
import com.treasuryfan.demo.service.CommentService;
import com.treasuryfan.demo.service.TicketService;
import com.treasuryfan.demo.util.ResponseCode;
import com.treasuryfan.demo.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/article")
public class  BlogController {
    @Autowired
    private TicketService ticketService;
    @Autowired
    private BlogService blogService;
    @Autowired
    private CommentService commentService;
    /**
     * @Author：xhl
     * @Date: 2021/11/24
     * @Param: ticket
     * @Return:
     * @Description:返回所有文章；
     */
    @RequestMapping(value = "/querylist",method = RequestMethod.GET)
    public Result allBlogs(@RequestParam("ticket") String ticket ){
        boolean result = ticketService.checkTicket(ticket);
        if (result){
            List<Blog> blogs = blogService.showBlogs();
            List<BlogPreview> blogPreviews = new ArrayList<>();
            SimpleDateFormat sformat = new SimpleDateFormat("$yyyy年MM月dd日$");
            for (int i = 0; i < blogs.size(); i++) {
                BlogPreview blogPreview = new BlogPreview(
                        "No"+String.valueOf(blogs.get(i).getBlogid()),
                        blogs.get(i).getTitle(),
                        blogs.get(i).getSummary(),
                        sformat.format(blogs.get(i).getCreateDate())+
                                "No"+String.valueOf(blogs.get(i).getBlogid()));
                blogPreviews.add(i,blogPreview);
            }
            System.out.println(new Result(ResponseCode.OK,blogPreviews));
            return new Result(ResponseCode.OK,blogPreviews);
        }else return new Result(ResponseCode.NoLogin);
    }
    /**
     * @Author：xhl
     * @Date: 2021/11/24
     * @Param: BlogVo
     * @Return: Result
     * @Description:文章发布接口；
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Result add(@RequestParam("ticket")String ticket,@RequestParam("userId")Long userId,@RequestBody BlogVo blogVo){
        blogVo.setUserid(userId);
//        System.out.println(blogVo.getUserid());
        boolean result = ticketService.checkTicket(ticket);
        if (result){
            int res = blogService.upBlog(blogVo);
            if (res == 0){
                return new Result(ResponseCode.OK);
            }
            else return new Result(ResponseCode.UnknownFailure);
        }
        else return new Result(ResponseCode.NoLogin);
    }
    /**
     * @Author：xhl
     * @Date: 2021/11/24
     * @Param: BlogVo
     * @Return: Result
     * @Description:文章删除接口；
     */
    @RequestMapping(value = "/del",method = RequestMethod.DELETE)
    public Result delete(@RequestParam("ticket")String ticket,@RequestParam("blogId")Long blogid){

        boolean result = ticketService.checkTicket(ticket);
        if (result){
            blogService.deleteBlog(blogid);
            commentService.deleteAllComment(blogid);
            return new Result(ResponseCode.OK);
        }else return new Result(ResponseCode.UnknownFailure);
    }
    /**
     * @Author：xhl
     * @Date: 2021/11/24
     * @Param: ticket , userid
     * @Return: Result
     * @Description:查看个人文章；
     */

    @RequestMapping(value = "/mine",method = RequestMethod.GET)
    public Result personalBlogs(@RequestParam("ticket")String ticket,@RequestParam("userId")Long userid){
        if (ticketService.checkTicket(ticket)){
            List<Blog> blogs = blogService.personalBlogs(userid);
            List<BlogPreview> blogPreviews = new ArrayList<>();
            SimpleDateFormat sformat = new SimpleDateFormat("$yyyy年MM月dd日$");
            //转换数据格式；
            for (int i = 0; i < blogs.size(); i++) {
                BlogPreview blogPreview = new BlogPreview(
                        "No"+String.valueOf(blogs.get(i).getBlogid()),
                        blogs.get(i).getTitle(),
                        blogs.get(i).getSummary(),
                        sformat.format(blogs.get(i).getCreateDate())
                                +"No"+String.valueOf(blogs.get(i).getBlogid()));
                blogPreviews.add(i,blogPreview);
            }
            return new Result(ResponseCode.OK,blogPreviews);
        }else return new Result(ResponseCode.NoLogin);
    }
    /**
     * @Author：xhl
     * @Date: 2021/11/24
     * @Param: ticket , blogid
     * @Return: Result
     * @Description:查看指定文章；
     */

    @RequestMapping(value = "/someone",method = RequestMethod.GET)
    public Result designateBlog(@RequestParam("ticket")String ticket,@RequestParam("blogId")Long blogid){
        if (ticketService.checkTicket(ticket)){
            Blog blog = blogService.showDesignateBlog(blogid);
            //要调用星宇的service里面查看该博文下所有评论的接口
            SimpleDateFormat sformat = new SimpleDateFormat("$yyyy年MM月dd日$");
            List<Comment> comments = commentService.showComments(blogid);
            List<CommentShow> commentShowList = new ArrayList<>();
            for (int i = 0; i < comments.size(); i++) {
                CommentShow commentShow = new CommentShow(comments.get(i).getContent(),
                        String.valueOf(comments.get(i).getUserid()),
                        String.valueOf(comments.get(i).getBlogid()),
                        sformat.format(comments.get(i).getCreateTime()),
                        String.valueOf(comments.get(i).getCommentid()));
                commentShowList.add(i,commentShow);
            }
            BlogDetail blogDetail = new BlogDetail(
                    blog.getBlogid(),
                    blog.getTitle(),
                    blog.getContent(),
                    commentShowList);

            return new Result(ResponseCode.OK,blogDetail);
        }else return new Result(ResponseCode.NoLogin);
    }
}

