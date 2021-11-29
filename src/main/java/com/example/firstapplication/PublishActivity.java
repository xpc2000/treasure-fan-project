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
import com.example.firstapplication.model.vo.BlogVo;
import com.example.firstapplication.utils.OkHttpUtils;
import com.example.firstapplication.utils.ResponseCallBack;
import com.google.gson.Gson;

import org.json.JSONException;

public class PublishActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publish);
        EditText title=findViewById(R.id.edit_title);
        EditText summary=findViewById(R.id.edit_summary);
        EditText content=findViewById(R.id.edit_content);
        Button publish=findViewById(R.id.publish);
        publish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //上传新建博文的信息
                Gson gson=new Gson();
                BlogVo blogVo=new BlogVo(AccountInfo.getUserId()+"L",title.getText().toString(),summary.getText().toString(),content.getText().toString());
                String json=gson.toJson(blogVo);
                System.out.println(json);
                OkHttpUtils.postAsync(getResources().getString(R.string.url)+"/article/add?ticket=" + AccountInfo.getTicket()+"&userId="+AccountInfo.getUserId(), new ResponseCallBack() {
                    @Override
                    public void success(String json) throws JSONException {
                        Result result= gson.fromJson(json,Result.class);
                        if(json.contains("timestamp")){
                            Toast.makeText(getApplicationContext(), "后台出错", Toast.LENGTH_SHORT).show();
                        }
                        else if(result.getConde()==0){
                            Toast.makeText(getApplicationContext(), "发布成功", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                        else
                            Toast.makeText(getApplicationContext(), result.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void error(String json) { }
                },blogVo);
            }
        });
    }
}
