package com.raj.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class DetailsBook extends AppCompatActivity {
    Toolbar toolbar;
    public static  String ID="id";
    int id;
    Bundle bundle;

    ImageView img_book;
    TextView txt_namebook, txt_description,txt_author,txt_published,txt_genre,txt_price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_book);


        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        bundle=getIntent().getExtras();
        id= Integer.parseInt(getIntent().getStringExtra(ID));
       // Toast.makeText(this,""+ id, Toast.LENGTH_LONG).show();



        txt_description=findViewById(R.id.txt_description);
        txt_author=findViewById(R.id.txt_author);
        txt_published=findViewById(R.id.txt_published);
        img_book=findViewById(R.id.img_book);
        txt_namebook=findViewById(R.id.txt_namebook);
        txt_genre=findViewById(R.id.txt_genre);
        txt_price=findViewById(R.id.txt_price);


        txt_namebook.setText(bundle.getString("name"));
        txt_author.setText(new StringBuilder("Author :  ")+ bundle.getString("author"));
        txt_published.setText(new StringBuilder("published :  ")+ bundle.getString("author"));
        txt_genre.setText(new StringBuilder("genre :  ")+ bundle.getString("genre"));
        txt_price.setText( bundle.getString("price"));
        txt_description.setText(new StringBuilder("          Description \n\n")+ bundle.getString("desc"));
        Picasso.get().load(bundle.getString("image")).into(img_book);


    }
}