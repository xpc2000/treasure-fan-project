package com.treasuryfan.demo.controller;

import com.treasuryfan.demo.model.vo.CommentUserVo;
import com.treasuryfan.demo.service.CommentService;
import com.treasuryfan.demo.service.TicketService;
import com.treasuryfan.demo.util.ResponseCode;
import com.treasuryfan.demo.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/**
 * @Author：hxy
 * @Date: 2021.11.24
 * @Description:评论控制器
 */
@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;
    @Autowired
    private TicketService ticketService;

    /**
     * @Author：hxy
     * @Date: 2021/11/24
     * @Param: CommentUserVo
     * @Return: Result
     * @Description:添加评论接口
     */
    @RequestMapping(value="/add",method= RequestMethod.POST)
    public Result add(@RequestParam("ticket")String ticket,@RequestParam("userId") Long userId,
                      @RequestParam("blogId")Long blogId,@RequestBody CommentUserVo commentVo){
        boolean serviceResult=ticketService.checkTicket(ticket);
        if(serviceResult){
            commentVo.setBlogid(blogId);
            commentVo.setUserId(userId);
            int newComment=commentService.addComment(commentVo);
            if (newComment==0){
                return new Result(ResponseCode.OK);
            }
            else return new Result(ResponseCode.UnknownFailure);
        }else
            return new Result(ResponseCode.LoginFailure);
    }
    /**
     * @Author：hxy
     * @Date: 2021/11/24
     * @Param: CommentUserVo
     * @Return: Result
     * @Description:删除评论接口
     */
    @RequestMapping(value="/del",method=RequestMethod.DELETE)
    public Result del(@RequestParam("ticket")String ticket,@RequestParam("commentId")long commentid){
        boolean result=ticketService.checkTicket(ticket);
        if (result){
//            Long re=commentVo.getUserId();
//            if (Objects.equals(re, commentVo.getBlogid())){
//                commentService.deleteComment(commentid);
//                return new Result(ResponseCode.OK);
//            }else{
//                return new Result(ResponseCode.InsufficientPermissionsDeleteComment);
//            }
            int res = commentService.deleteComment(commentid);
            return new Result(ResponseCode.OK);
        }else return new Result(ResponseCode.NoLogin);
    }
}

/**
 * @Author:
 * @Date: 2021/11/22
 *@Param:
 *@Return:
 *@Description:
 * 发表评论：Comment（pojo-->MySQL）:blogId，userId，username，content(用户由前端提交)，
 * state/createdTime(后台生成)，commentId（MySQL，意味着insertSelective）
 * Dao：insert(Object)
 * Service：接收到controller来的数据，state/createdTime-->Dao
 * Controller：接收blogId，userId，username，content,先验证登录，如果在线，即可操作增添评论-->service
 * 删除特定评论：MySQL需要CommentId，Dao接收commitId
 * 删除某博文下的全部评论：service接收blogId，blogId传到Dao,Dao回传CommentId的集合List，List
 * 查看某特定博文下的全部评论：
 * MySQL需要BlogId，
 * Dao：接收BlogId，组建CommentExample和对应的Criteria
 * Service：接受BlogId--》Dao
 * Controller：接收BlogId--》Service（海龙要写的）；前端：content，user_Id，createdDate，blog_id,commentId
 *
 *  /**
 *      * @Author：hxy
 *      * @Date: 2021/11/24
 *      * @Param: CommentUserVo
 *      * @Return: Result
 *      * @Description:删除特定评论接口
 *      */
