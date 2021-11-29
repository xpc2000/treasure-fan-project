package com.example.firstapplication.utils;

import com.example.firstapplication.model.BlogDetail;
import com.example.firstapplication.model.CommentShow;

import java.util.List;

public class StaticComments {
    public static List<CommentShow> list;

    public static void assignComments(List<CommentShow> commentShows){
        list=commentShows;
    }
}
