package com.example.firstapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.firstapplication.model.vo.LoginUserVo;
import com.example.firstapplication.utils.OkHttpUtils;
import com.example.firstapplication.utils.ResponseCallBack;

import org.json.JSONException;

public class Test extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.net_test);
        Button submit=findViewById(R.id.submit_request);
        Button post=findViewById(R.id.submit_post);
        textView=findViewById(R.id.result_show);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendInfo();
            }
        });
        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendPost();
            }
        });
    }

    public void sendInfo(){
        OkHttpUtils.getAsync("http://192.168.1.102:8081/main/test?id=13624&name=Steve", new ResponseCallBack() {
            @Override
            public void success(String json) throws JSONException {
                textView.setText(json);
            }
            @Override
            public void error(String json) {
            }
        });
    }

    public void sendPost(){
        LoginUserVo loginUserVo=new LoginUserVo();
        loginUserVo.setUsername("xpc");
        loginUserVo.setPassword("afafdasfasdf");
        OkHttpUtils.postAsync("http://192.168.1.102:8081/main/testPost?ticket=jiknkjn", new ResponseCallBack() {
            @Override
            public void success(String json) throws JSONException {
                textView.setText(json);
            }
            @Override
            public void error(String json) {

            }
        },loginUserVo);
    }
}