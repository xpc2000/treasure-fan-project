package com.example.firstapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
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
import com.example.firstapplication.model.vo.CommentUserVo;
import com.example.firstapplication.utils.OkHttpUtils;
import com.example.firstapplication.utils.ResponseCallBack;
import com.example.firstapplication.utils.StaticResource;
import com.google.gson.Gson;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class DetailActivity extends AppCompatActivity {
    BlogDetail blogDetail;
    List<CommentShow> commentShows=new ArrayList<>();
    String json;
    ListView listView;
    int index;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blogdetails);
        Button comment=findViewById(R.id.comment);
        EditText editComment=findViewById(R.id.edit_comment);
        Intent intent=getIntent();
        index=intent.getIntExtra("Index",0);
        json=intent.getStringExtra("json");
        processJson(json);
        comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent=new Intent();
//                intent.setClass(DetailActivity.this,CommentActivity.class);
//                startActivity(intent);
                CommentUserVo commentUserVo=new CommentUserVo(editComment.getText().toString(),
                        Long.valueOf(blogDetail.getBlogId()),Long.valueOf(AccountInfo.getUserId()));
                OkHttpUtils.postAsync(getResources().getString(R.string.url)+"/comment/add?ticket=" + AccountInfo.getTicket()+
                        "&userId="+AccountInfo.getUserId()+"&blogId="+blogDetail.getBlogId(),new ResponseCallBack() {
                    @Override
                    public void success(String json) throws JSONException {
                        Gson gson=new Gson();
                        Result result=gson.fromJson(json,Result.class);
                        if(json.contains("timestamp"))
                            Toast.makeText(getApplicationContext(), "后台错误", Toast.LENGTH_SHORT).show();
                        else if(result.getConde()==0){
                            Toast.makeText(getApplicationContext(), "成功评论", Toast.LENGTH_SHORT).show();
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
                    public void error(String json) {

                    }
                },commentUserVo);
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
//        blogDetail= StaticResource.getDetail();
        TextView titel=findViewById(R.id.blog_tile_show);
        TextView content=findViewById(R.id.blog_content_show);
        titel.setText(blogDetail.getTitle());
        content.setText(blogDetail.getContent());
//        List<CommentShow> commentShows= StaticResource.getComments();
        listView=findViewById(R.id.listComment);
        listView.setAdapter(new CommentAdapter(DetailActivity.this,commentShows));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(commentShows.size()!=0)
                    deleteComment(commentShows.get(position).getUserId(),commentShows.get(position).getCommentId());
            }
        });
    }

    public void deleteComment(String userId,String commentId){
        if(userId.equals(AccountInfo.getUserId())){
            OkHttpUtils.delteAsync(getResources().getString(R.string.url) + "/comment/del?ticket=" + AccountInfo.getTicket() + "&commentId=" + commentId, new ResponseCallBack() {
                @Override
                public void success(String json) throws JSONException {
                    Gson gson=new Gson();
                    Result result=gson.fromJson(json,Result.class);
                    if(result.getConde()==0){
                        Toast.makeText(getApplicationContext(), "成功删除评论", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                    else
                        Toast.makeText(getApplicationContext(),result.getMessage(),Toast.LENGTH_SHORT).show();
                }
                @Override
                public void error(String json) { }
            });
        }
        else
            Toast.makeText(getApplicationContext(), "您无权删除他人的评论", Toast.LENGTH_SHORT).show();
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
//        System.out.println(commentShows);
    }
}
