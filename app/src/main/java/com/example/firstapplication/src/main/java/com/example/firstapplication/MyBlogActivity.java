package com.example.firstapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.firstapplication.adapter.CommentAdapter;
import com.example.firstapplication.model.AccountInfo;
import com.example.firstapplication.model.BlogDetail;
import com.example.firstapplication.model.CommentShow;
import com.example.firstapplication.model.response.Result;
import com.example.firstapplication.utils.OkHttpUtils;
import com.example.firstapplication.utils.ResponseCallBack;
import com.example.firstapplication.utils.StaticResource;
import com.google.gson.Gson;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MyBlogActivity extends AppCompatActivity {
    BlogDetail blogDetail;
    List<CommentShow> commentShows=new ArrayList<>();
    String json;
    int index;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_blog);
        Button delete=findViewById(R.id.delete);
        Intent intent=getIntent();
        index=intent.getIntExtra("Index",0);
        json=intent.getStringExtra("json");
        processJson(json);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //网络传输被删除博文的信息
                OkHttpUtils.delteAsync(getResources().getString(R.string.url)+"/article/del?ticket=" + AccountInfo.getTicket()
                        +"&blogId="+blogDetail.getBlogId(), new ResponseCallBack() {
                    @Override
                    public void success(String json) throws JSONException {
                        Gson gson=new Gson();
                        Result result=gson.fromJson(json,Result.class);
                        if(result.getConde()==0){
                            Toast.makeText(getApplicationContext(), "成功删除博文", Toast.LENGTH_SHORT).show();
                            StaticResource.removeBlog(index);
                            finish();
                        }
                        else if(result.getConde()==601){
                            Toast.makeText(getApplicationContext(),result.getMessage(),Toast.LENGTH_SHORT).show();
                            finish();
                        }
                        else
                            Toast.makeText(getApplicationContext(), result.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void error(String json) { }
                });

            }
        });

    }

    @Override
    protected void onStart() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        super.onStart();
//        blogDetail=StaticResource.getDetail();
        TextView titel = findViewById(R.id.my_blog_tile_show);
        TextView content = findViewById(R.id.my_blog_content_show);
        titel.setText(blogDetail.getTitle());
//        titel.setText("bababa");
        content.setText(blogDetail.getContent());
//        content.setText("lalalalala");
        ListView listView = findViewById(R.id.comments2);
        listView.setAdapter(new CommentAdapter(MyBlogActivity.this, commentShows));
        System.out.println(commentShows);
    }

    public void processJson(String json){
        String[] resultLevel1=json.split("\",\"commentShowList\":");
        resultLevel1[0]=resultLevel1[0].substring(34);
        resultLevel1[0]=resultLevel1[0].replace("\"","");
        resultLevel1[0]=resultLevel1[0].replace(":",",");
        String[] details=resultLevel1[0].split(",");
        blogDetail= new BlogDetail(details[1],details[3],details[5]);
        if(!resultLevel1[1].equals("[]}}")){
            resultLevel1[1]=resultLevel1[1].substring(1,resultLevel1[1].length()-3);
            resultLevel1[1]=resultLevel1[1].replace("{","");
            resultLevel1[1]=resultLevel1[1].replace("}","");
            resultLevel1[1]=resultLevel1[1].replace("\"","");
            resultLevel1[1]=resultLevel1[1].replace(":",",");
            String[] resultLevel2=resultLevel1[1].split(",");
            for(int i=0;i<resultLevel2.length;i+=10){
                commentShows.add(new CommentShow(resultLevel2[i+1],resultLevel2[i+3],
                        resultLevel2[i+5],resultLevel2[i+7],resultLevel2[i+9]));
            }
        }
        System.out.println(commentShows);
    }
}
