package com.example.firstapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.firstapplication.model.AccountInfo;
import com.example.firstapplication.model.BlogPreview;
import com.example.firstapplication.model.response.Result;
import com.example.firstapplication.model.response.ReturnPreviews;
import com.example.firstapplication.utils.OkHttpUtils;
import com.example.firstapplication.utils.ResponseCallBack;
import com.example.firstapplication.utils.StaticResource;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;

import java.util.List;
import java.util.Objects;

public class FirstActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        Intent intent=new Intent();
        Button infoButtion=findViewById(R.id.person_info_access);
        Button gainAllBlog=findViewById(R.id.gain_all_blog);
        Button gainMyBlog=findViewById(R.id.gain_personal_blog);
        Button allListButton=findViewById(R.id.look_all_blogs);
        Button myListButton=findViewById(R.id.look_personal_blogs);
        Button exitButton=findViewById(R.id.exit);
        Button publish=findViewById(R.id.publish_blog);
        Button test=findViewById(R.id.test);
        gainAllBlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OkHttpUtils.getAsync(getResources().getString(R.string.url) + "/article/querylist?ticket=" + AccountInfo.getTicket(), new ResponseCallBack() {
                    @Override
                    public void success(String json) throws JSONException {
                        Gson gson=new Gson();
                        ReturnPreviews result=gson.fromJson(json,ReturnPreviews.class);
                        if(json.contains("timestamp")){
                            Toast.makeText(getApplicationContext(), "后台出错", Toast.LENGTH_SHORT).show();
                        }
                        else if(result.getConde()==0){
                            String[] results=json.split(",\"data\":");
                            results[1]=results[1].substring(0,results[1].length()-1);
                            List<BlogPreview> previewList=gson.fromJson(results[1],new TypeToken<List<BlogPreview>>(){}.getType());
                            StaticResource.assignPreviews(previewList);
                            if(!Objects.equals(StaticResource.getPreviews(),null)){
                                Toast.makeText(getApplicationContext(), "获取到所有公开博文", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else if(result.getConde()==601){
                            Toast.makeText(getApplicationContext(), result.getMessage(), Toast.LENGTH_SHORT).show();
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

        gainMyBlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OkHttpUtils.getAsync(getResources().getString(R.string.url) + "/article/mine?ticket=" + AccountInfo.getTicket()+"&userId="+AccountInfo.getUserId(), new ResponseCallBack() {
                    @Override
                    public void success(String json) throws JSONException {
                        Gson gson=new Gson();
                        ReturnPreviews result=gson.fromJson(json,ReturnPreviews.class);
                        if(json.contains("timestamp")){
                            Toast.makeText(getApplicationContext(), "后台出错", Toast.LENGTH_SHORT).show();
                        }
                        else if(result.getConde()==0){
                            String[] results=json.split(",\"data\":");
                            results[1]=results[1].substring(0,results[1].length()-1);
                            List<BlogPreview> previewList=gson.fromJson(results[1],new TypeToken<List<BlogPreview>>(){}.getType());
                            for(int i=0;i<previewList.size();i++){System.out.print(previewList.get(i).getBlogId()+" "+
                                    previewList.get(i).getTitle()+" "+previewList.get(i).getSummary()+" "+
                                    previewList.get(i).getDate()+"\n");}
                            StaticResource.assignPreviews(previewList);
                            if(!Objects.equals(StaticResource.getPreviews(),null)){
                                Toast.makeText(getApplicationContext(), "获取到所有个人博文", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else if(result.getConde()==601){
                            Toast.makeText(getApplicationContext(), result.getMessage(), Toast.LENGTH_SHORT).show();
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

        infoButtion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.setClass(FirstActivity.this,InfoActivity.class);
                startActivity(intent);
            }
        });

        allListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (StaticResource.getPreviewsCount()!=-1){
                    intent.setClass(FirstActivity.this,AllListActivity.class);
                    startActivity(intent);
                }
                else
                    Toast.makeText(getApplicationContext(), "尚未获取博文列表", Toast.LENGTH_SHORT).show();
            }
        });

        myListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.setClass(FirstActivity.this,MyListActivity.class);
                startActivity(intent);
            }
        });

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OkHttpUtils.delteAsync(getResources().getString(R.string.url)+"/user/logout?ticket=" + AccountInfo.getTicket(), new ResponseCallBack() {
                    @Override
                    public void success(String json) throws JSONException {
                        Gson gson=new Gson();
                        Result result=gson.fromJson(json,Result.class);
                        if (result.getConde()==0){
                            AccountInfo.setTicket("null");
                            AccountInfo.setUserId("null");
                            AccountInfo.setUserName("null");
                            AccountInfo.setPassword("null");
                            AccountInfo.setEmail("null");
                            Toast.makeText(getApplicationContext(), "您已退出", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }

                    @Override
                    public void error(String json) {

                    }
                });

            }
        });




        publish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.setClass(FirstActivity.this,PublishActivity.class);
                startActivity(intent);
            }
        });

        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.setClass(FirstActivity.this,Test.class);
                startActivity(intent);
            }
        });
    }
}
