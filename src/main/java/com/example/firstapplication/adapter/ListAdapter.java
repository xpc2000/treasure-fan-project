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
import com.example.firstapplication.model.BlogPreview;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    private List<BlogPreview> blogPreviewList=new ArrayList<>();

    public ListAdapter(Context context,List<BlogPreview> list){
        this.context=context;
        layoutInflater=LayoutInflater.from(context);
        blogPreviewList=list;
    }

    @Override
    public int getCount() {
        return blogPreviewList.size();
    }

    @Override
    public Object getItem(int position) {
        return blogPreviewList.get(position);
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
        ViewHolder viewHolder=new ViewHolder();
        if(convertView==null){
            convertView=layoutInflater.inflate(R.layout.list_item,null);
            viewHolder.imageView=convertView.findViewById(R.id.blog_image);
            viewHolder.blogTitle=convertView.findViewById(R.id.blog_title);
            viewHolder.blogDate=convertView.findViewById(R.id.blog_time);
            viewHolder.blogSummary=convertView.findViewById(R.id.blog_summary);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder=(ViewHolder) convertView.getTag();
        }
        viewHolder.blogTitle.setText(blogPreviewList.get(position).getTitle());
        String[] date=blogPreviewList.get(position).getDate().split("No");
        viewHolder.blogDate.setText(date[0]);
        viewHolder.blogSummary.setText(blogPreviewList.get(position).getSummary());
        return convertView;
    }
}
