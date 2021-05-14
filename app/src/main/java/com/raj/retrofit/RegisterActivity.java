package com.raj.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class RegisterActivity extends AppCompatActivity {

    TextInputEditText et_username,et_password,et_email,et_phone;
    Button btn_register;
    TextView txt_haveacount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        et_username=findViewById(R.id.et_username);
        et_password=findViewById(R.id.et_password);
        et_email=findViewById(R.id.et_email);
        et_phone=findViewById(R.id.et_phone);
        btn_register=findViewById(R.id.btn_register);
        txt_haveacount=findViewById(R.id.txt_haveacount);



        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });



        txt_haveacount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });

    }


}