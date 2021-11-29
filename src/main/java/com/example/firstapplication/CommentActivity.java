package com.example.firstapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.firstapplication.model.AccountInfo;
import com.example.firstapplication.model.response.Result;
import com.example.firstapplication.model.vo.CommentUserVo;
import com.example.firstapplication.utils.OkHttpUtils;
import com.example.firstapplication.utils.ResponseCallBack;
import com.google.gson.Gson;

import org.json.JSONException;

public class CommentActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Intent intent=getIntent();
        String blogId=intent.getStringExtra("blogId");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        EditText comment = findViewById(R.id.edit_comment);
        Button submit=findViewById(R.id.submit_comment);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //网络传输提交评论
//                CommentUserVo commentUserVo=new CommentUserVo(AccountInfo.getUserName(),
//                        comment.getText().toString(),Long.valueOf(blogId),Long.valueOf(AccountInfo.getUserId()));
//                OkHttpUtils.postAsync(getResources().getString(R.string.url)+"/comment/add?ticket=" + AccountInfo.getTicket(), new ResponseCallBack() {
//                    @Override
//                    public void success(String json) throws JSONException {
//                        Gson gson=new Gson();
//                        Result result=gson.fromJson(json,Result.class);
//                        if(result.getConde()==0){
//                            Toast.makeText(getApplicationContext(), "成功评论", Toast.LENGTH_SHORT).show();
//                            finish();
//                        }
//                        else if(result.getConde()==601){
//                            Toast.makeText(getApplicationContext(),result.getMessage(),Toast.LENGTH_SHORT).show();
//                            finish();
//                        }
//                        else
//                            Toast.makeText(getApplicationContext(), result.getMessage(), Toast.LENGTH_SHORT).show();
//                    }
//                    @Override
//                    public void error(String json) {
//
//                    }
//                },commentUserVo);
//                Toast.makeText(getApplicationContext(), "评论成功", Toast.LENGTH_SHORT).show();
//                finish();
            }
        });

    }
}
