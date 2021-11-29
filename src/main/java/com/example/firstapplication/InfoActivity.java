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

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        Init();
        Button changeUsername=findViewById(R.id.usernameChange);
        Button changePassword=findViewById(R.id.passwordChange);
        Intent intent=new Intent();
        changePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.setClass(InfoActivity.this,ChangePasswordActivity.class);
                startActivity(intent);
            }
        });

        changeUsername.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "不支持该功能", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void Init(){
        EditText email=findViewById(R.id.EmailAddress);
        email.setText(AccountInfo.getEmail());
        email.setEnabled(false);
        EditText password=findViewById(R.id.unchangedPassword);
        password.setText(AccountInfo.getPassword());
        password.setEnabled(false);
        EditText name=findViewById(R.id.editTextTextPersonName);
        name.setText(AccountInfo.getUserName());
    }

}
