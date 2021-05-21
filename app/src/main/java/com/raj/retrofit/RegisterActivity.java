package com.raj.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    ApiInterface request;

    TextInputEditText et_username,et_password,et_email,et_phone;
    Button btn_register;
    TextView txt_haveacount;
    String url="http://192.168.1.104/retrofit/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if (restoreStateUser()){
            startActivity(new Intent(RegisterActivity.this,MainActivity.class));
            finish();
        }
        setContentView(R.layout.activity_register);

        request=ApiClient.getApiClient(url).create(ApiInterface.class);


        et_username=findViewById(R.id.et_username);
        et_password=findViewById(R.id.et_password);
        et_email=findViewById(R.id.et_email);
        et_phone=findViewById(R.id.et_phone);
        btn_register=findViewById(R.id.btn_register);
        txt_haveacount=findViewById(R.id.txt_haveacount);



        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getuser();

            }
        });



        txt_haveacount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });

    }

    private void getuser(){
        String name=et_username.getText().toString();
        String password=et_password.getText().toString();
        String email=et_email.getText().toString();
        String phone=et_phone.getText().toString();

        Call<users>call=request.RegisterAccount(name,password,email,phone);
        call.enqueue(new Callback<users>() {
            @Override
            public void onResponse(Call<users> call, Response<users> response) {
                if (response.body().getResponse().equals("USER_REGISTER")){
                    Toast.makeText(RegisterActivity.this, "you are registered", Toast.LENGTH_SHORT).show();
                    txt_haveacount.setVisibility(View.VISIBLE);

                }else if (response.body().getResponse().equals("SUCCESS")){

                    Toast.makeText(RegisterActivity.this, "SUCCESS", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(RegisterActivity.this,MainActivity.class));
                    finish();

                }else if (response.body().getResponse().equals("WRONG")){

                    Toast.makeText(RegisterActivity.this, "Error in register data", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<users> call, Throwable t) {

                Toast.makeText(RegisterActivity.this, t.getMessage()+"", Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void saveStateUser(){
        SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("prefUser",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putBoolean("user_state",true);
        editor.apply();
    }

    private boolean restoreStateUser(){
        SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("prefUser",MODE_PRIVATE);
        boolean StateUser;
        StateUser=sharedPreferences.getBoolean("user_state",false);
        return StateUser;

    }

}