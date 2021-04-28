package com.raj.retrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.myViewHolder> {
        Context context;
        List<Books>data;

    public BookAdapter(Context context, List<Books> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_books,parent,false);
        return new  myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.txt_namebook.setText(data.get(position).getName());
        holder.txt_author.setText(data.get(position).getAuthor());
        holder.txt_price.setText(data.get(position).getPrice());

        Picasso.get().load(data.get(position).getLink_image()).into(holder.img_item);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {

        TextView txt_namebook,txt_author,txt_price;
        ImageView img_item;


        public myViewHolder(@NonNull View itemView) {

            super(itemView);

            txt_namebook=itemView.findViewById(R.id.txt_namebook);
            txt_author=itemView.findViewById(R.id.txt_author);
            txt_price=itemView.findViewById(R.id.txt_price);
            img_item=itemView.findViewById(R.id.img_item);
        }
    }
}
