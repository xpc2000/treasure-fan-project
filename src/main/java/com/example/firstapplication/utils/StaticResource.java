package com.example.firstapplication.utils;

import com.example.firstapplication.model.BlogDetail;
import com.example.firstapplication.model.BlogPreview;
import com.example.firstapplication.model.CommentShow;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StaticResource {
    public static List<BlogPreview> previews=new ArrayList<>();
    public static BlogDetail detail=new BlogDetail();
    public static List<CommentShow> comments=new ArrayList<>();

    public static void assignPreviews(List<BlogPreview> list){
        previews=list;
    }

    public static void assignDetail(BlogDetail blog){
        detail=blog;
    }

    public static void assignComments(List<CommentShow> list){
        comments=list;
    }

    public static List<BlogPreview> getPreviews(){
        return previews;
    }

    public static String getBlogId(int index){
        return previews.get(index).getBlogId();
    }

    public static List<CommentShow> getComments(){
        return comments;
    }

    public static String getCommentId(int index){
        return comments.get(index).getCommentId();
    }

    public static int getPreviewsCount(){
        if(Objects.equals(null,previews)||previews.size()==0){
            return -1;
        }
        else
            return previews.size();
    }

    public static BlogDetail getDetail(){
        return detail;
    }

    public static void removeBlog(int index){
        previews.remove(index);
    }

    public static void setBlogId(String id){
        detail.setBlogId(id);
    }

    public static void setTitle(String title){
        detail.setTitle(title);
    }

    public static void setContent(String content){
        detail.setContent(content);
    }
}
