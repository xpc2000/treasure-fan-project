package com.example.firstapplication.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.firstapplication.R;
import com.example.firstapplication.model.CommentShow;

import java.util.ArrayList;
import java.util.List;

public class CommentAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater layoutInflater;
    private List<CommentShow> commentList =new ArrayList<>();

    public CommentAdapter(Context context, List<CommentShow> list){
        this.context=context;
        layoutInflater=LayoutInflater.from(context);
        commentList =list;
    }

    @Override
    public int getCount() {
        return commentList.size();
    }

    @Override
    public Object getItem(int position) {
        return commentList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    static class ViewHolder{
        public ImageView imageView;
        public TextView blogTitle,blogDate,blogSummary;
    }


    @SuppressLint("InflateParams")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CommentAdapter.ViewHolder viewHolder=new CommentAdapter.ViewHolder();
        if(convertView==null){
            convertView=layoutInflater.inflate(R.layout.list_item,null);
            viewHolder.imageView=convertView.findViewById(R.id.blog_image);
            viewHolder.blogTitle=convertView.findViewById(R.id.blog_title);
            viewHolder.blogDate=convertView.findViewById(R.id.blog_time);
            viewHolder.blogSummary=convertView.findViewById(R.id.blog_summary);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder=(CommentAdapter.ViewHolder) convertView.getTag();
        }
        viewHolder.blogTitle.setText(commentList.get(position).getUserId());
        viewHolder.blogDate.setText(commentList.get(position).getDate());
        viewHolder.blogSummary.setText(commentList.get(position).getContent());
        return convertView;
    }
}
