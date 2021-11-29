package com.example.firstapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.firstapplication.model.AccountInfo;
import com.example.firstapplication.model.response.Result;
import com.example.firstapplication.model.vo.RegisterUserVo;
import com.example.firstapplication.utils.OkHttpUtils;
import com.example.firstapplication.utils.ResponseCallBack;
import com.google.gson.Gson;

import org.json.JSONException;

public class RegisterActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        EditText email=findViewById(R.id.editEmailAddress);
        EditText userName=findViewById(R.id.editPersonName);
        EditText password1=findViewById(R.id.editPassword1);
        EditText password2=findViewById(R.id.editPassword2);
        Button submit=findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!password1.getText().toString().equals(password2.getText().toString())){
                    Toast.makeText(getApplicationContext(), "请保证两次输入的密码一致", Toast.LENGTH_SHORT).show();
                }
                else{
                    //传输email，用户名和密码，等待返回结果,如果通过直接finish，否则弹出Toast；
                    RegisterUserVo registerUserVo=new RegisterUserVo(email.getText().toString(), userName.getText().toString(),password1.getText().toString());
                    OkHttpUtils.postAsync(getResources().getString(R.string.url)+"/user/register", new
                            ResponseCallBack() {
                        @Override
                        public void success(String json) throws JSONException {
                            Gson gson=new Gson();
                            Result result=gson.fromJson(json,Result.class);
                            if(result.getConde()!=0){
                                Toast.makeText(getApplicationContext(), result.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                            else{
                                Toast.makeText(getApplicationContext(), "注册成功", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        }
                        @Override
                        public void error(String json) {

                        }
                    },registerUserVo);

                }

            }
        });
    }

    @Override
    protected void onPause() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        super.onPause();
    }
}
