package com.example.firstapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.firstapplication.adapter.ListAdapter;
import com.example.firstapplication.model.AccountInfo;
import com.example.firstapplication.model.BlogDetail;
import com.example.firstapplication.model.BlogPreview;
import com.example.firstapplication.model.CommentShow;
import com.example.firstapplication.model.response.ReturnDetails;
import com.example.firstapplication.utils.OkHttpUtils;
import com.example.firstapplication.utils.ResponseCallBack;
import com.example.firstapplication.utils.StaticComments;
import com.example.firstapplication.utils.StaticResource;
import com.google.gson.Gson;

import org.json.JSONException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MyListActivity extends AppCompatActivity {
    private List<BlogPreview> blogPreviewList;
    private BlogDetail blogDetail;
    private List<CommentShow> commentShows=new ArrayList<>();
    private String jsonTransport;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
    }

    @Override
    protected void onStart() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        super.onStart();
        ListView listView=findViewById(R.id.list);
        //网络传输
        blogPreviewList= StaticResource.getPreviews();
        listView.setAdapter(new ListAdapter(MyListActivity.this,blogPreviewList));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String blogId=blogPreviewList.get(position).getDate().split("No")[1];
                OkHttpUtils.getAsync(getResources().getString(R.string.url) + "/article/someone?ticket="
                        + AccountInfo.getTicket() + "&blogId=" + blogId, new ResponseCallBack() {
                    @Override
                    public void success(String json) throws JSONException {
                        Gson gson=new Gson();
                        ReturnDetails returnDetails=gson.fromJson(json,ReturnDetails.class);
                        if(json.contains("timestamp")){
                            Toast.makeText(getApplicationContext(), "后台出错", Toast.LENGTH_SHORT).show();
                        }
                        Intent intent=new Intent();
                        intent.putExtra("index",position);
                        intent.putExtra("json",json);
                        intent.setClass(MyListActivity.this,MyBlogActivity.class);
                        startActivity(intent);
                    }
                    @Override
                    public void error(String json) { }
                });

            }
        });
    }

    public void setCommentShows(String[] resultLevel2){
        for(int i=0;i<resultLevel2.length;i+=10){
            commentShows.add(new CommentShow(resultLevel2[i+1],resultLevel2[i+3],
                    resultLevel2[i+5],resultLevel2[i+7],resultLevel2[i+9]));
        }
    }
}
