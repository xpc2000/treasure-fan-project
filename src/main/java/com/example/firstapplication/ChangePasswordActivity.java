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
import com.example.firstapplication.model.vo.InfoVo;
import com.example.firstapplication.utils.OkHttpUtils;
import com.example.firstapplication.utils.ResponseCallBack;
import com.google.gson.Gson;

import org.json.JSONException;

public class ChangePasswordActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_change);
        EditText oldPasseord=findViewById(R.id.editOldPassword);
        EditText newPassword=findViewById(R.id.editNewPassword);
        EditText newPassword2=findViewById(R.id.editNewPassword2);
        oldPasseord.setText(AccountInfo.getPassword());
        Button submit=findViewById(R.id.submitNewPassword);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!newPassword.getText().toString().equals(newPassword2.getText().toString())){
                    Toast.makeText(getApplicationContext(), "请保证两次填写的新密码一致", Toast.LENGTH_SHORT).show();
                }
                else if(newPassword.getText().toString().equals(oldPasseord.getText().toString())){
                    Toast.makeText(getApplicationContext(), "新密码不得与旧密码相同", Toast.LENGTH_SHORT).show();
                }
                else{
                    //网络传输修改密码
                    InfoVo infoVo=new InfoVo(Long.valueOf(AccountInfo.getUserId()),oldPasseord.getText().toString(),newPassword.getText().toString());
                    OkHttpUtils.postAsync(getResources().getString(R.string.url)+"/user/updatepassword?ticket=" + AccountInfo.getTicket(), new ResponseCallBack() {
                        @Override
                        public void success(String json) throws JSONException {
                            Gson gson=new Gson();
                            Result result=gson.fromJson(json,Result.class);
                            if(result.getConde()==0){
                                AccountInfo.setPassword(newPassword.getText().toString());
                                Toast.makeText(getApplicationContext(), "修改成功", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                            else
                                Toast.makeText(getApplicationContext(), result.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                        @Override
                        public void error(String json) {
                        }
                    },infoVo);
                }
            }
        });
    }

}
