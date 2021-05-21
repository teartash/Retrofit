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

import java.net.InetAddress;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    Button btn_Login;
    TextView txt_noacount;
    TextInputEditText et_password,et_email;
    ApiInterface request;
    String url="http://192.168.1.104/retrofit/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (restoreStateUser()){
            startActivity(new Intent(LoginActivity.this,MainActivity.class));
            finish();
        }
        setContentView(R.layout.activity_login);

        request=ApiClient.getApiClient(url).create(ApiInterface.class);



        et_password=findViewById(R.id.et_password);
        et_email=findViewById(R.id.et_email);
        btn_Login=findViewById(R.id.btn_Login);
        txt_noacount=findViewById(R.id.txt_noacount);


        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getuser();
                saveStateUser();

            }
        });


        txt_noacount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }
        });
    }

    private void getuser(){
        String email=et_email.getText().toString();
        String password=et_password.getText().toString();

        Call<users>call=request.LoginAccount(email,password);
        call.enqueue(new Callback<users>() {
            @Override
            public void onResponse(Call<users> call, Response<users> response) {

                if (response.body().getResponse().equals("USER_LOGIN")){
                    Toast.makeText(LoginActivity.this, "Login Success", Toast.LENGTH_SHORT).show();

                    startActivity(new Intent(LoginActivity.this,MainActivity.class));
                    finish();


                }else if (response.body().getResponse().equals("NO_ACCOUNT")){
                    Toast.makeText(LoginActivity.this, "you go to register", Toast.LENGTH_SHORT).show();
                    txt_noacount.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void onFailure(Call<users> call, Throwable t) {

                Toast.makeText(LoginActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();

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