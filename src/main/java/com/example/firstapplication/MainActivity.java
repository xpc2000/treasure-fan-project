package com.example.firstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.firstapplication.model.AccountInfo;
import com.example.firstapplication.model.vo.LoginUserVo;
import com.example.firstapplication.model.response.Result;
import com.example.firstapplication.utils.OkHttpUtils;
import com.example.firstapplication.utils.ResponseCallBack;
import com.google.gson.Gson;

import org.json.JSONException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editUser=findViewById(R.id.editUsername);
        EditText editPassword= findViewById(R.id.editPassword);
        Button login= findViewById(R.id.loginButton);
        Button register=findViewById(R.id.registerButton);
        Intent intent=new Intent();
        System.out.println(getResources().getString(R.string.url));
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.setClass(MainActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginUserVo loginUserVo=new LoginUserVo(editUser.getText().toString(),editPassword.getText().toString());
                OkHttpUtils.postAsync(getResources().getString(R.string.url)+"/user/login", new ResponseCallBack() {
                    @Override
                    public void success(String json) throws JSONException {
                        Gson gson=new Gson();
                        Result result=gson.fromJson(json,Result.class);
                        if(result.getConde()!=0){
                            Toast.makeText(getApplicationContext(), "用户名或密码出错", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            AccountInfo.setUserName(editUser.getText().toString());
                            AccountInfo.setPassword(editPassword.getText().toString());
                            String[] strings=result.getData().split("@#@");
                            AccountInfo.setTicket(strings[0]);
                            AccountInfo.setUserId(strings[1]);
                            AccountInfo.setEmail(strings[2]);
                            Toast.makeText(getApplicationContext(), "您已成功登录", Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent();
                            intent.setClass(MainActivity.this,FirstActivity.class);
                            startActivity(intent);
                        }
                    }
                    @Override
                    public void error(String json) {
                    }
                },loginUserVo);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}