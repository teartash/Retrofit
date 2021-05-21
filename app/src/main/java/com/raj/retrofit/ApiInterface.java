package com.raj.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("getData.php")
    Call<List<Books>>getData();


    @POST("register.php")
    Call<users> RegisterAccount(@Query("name")String name,
                         @Query("password")String password,
                         @Query("email")String email,
                         @Query("phone")String phone);

    @GET("login.php")
    Call<users>LoginAccount(@Query("email")String email,
                            @Query("password")String password);



    }
