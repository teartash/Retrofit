package com.raj.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerview;
    BookAdapter adapter;
    List<Books>list=new ArrayList<>();

    ApiInterface request;
    String url="http://192.168.1.104/retrofit/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        request=ApiClient.getApiClient(url).create(ApiInterface.class);

        recyclerview=findViewById(R.id.recyclerview);
        recyclerview.setHasFixedSize(true);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));

        request.getData().enqueue(new Callback<List<Books>>() {
            @Override
            public void onResponse(Call<List<Books>> call, Response<List<Books>> response) {
                list=response.body();
                adapter=new BookAdapter(getApplicationContext(),list);
                recyclerview.setAdapter(adapter);


            }

            @Override
            public void onFailure(Call<List<Books>> call, Throwable t) {


                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });



    }
}