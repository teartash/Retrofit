package com.raj.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.net.InetAddress;

public class LoginActivity extends AppCompatActivity {
    Button btn_Login;
    TextView txt_noacount;
    TextInputEditText et_password,et_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        InetAddress inetAddress;


        et_password=findViewById(R.id.et_password);
        et_email=findViewById(R.id.et_email);
        btn_Login=findViewById(R.id.btn_Login);
        txt_noacount=findViewById(R.id.txt_noacount);


        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        txt_noacount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }
        });
    }
}