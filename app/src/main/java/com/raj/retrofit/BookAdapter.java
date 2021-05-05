package com.raj.retrofit;

import android.content.Context;
import android.content.Intent;
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

    public class myViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView txt_namebook,txt_author,txt_price;
        ImageView img_item;


        public myViewHolder(@NonNull View itemView) {

            super(itemView);

            txt_namebook=itemView.findViewById(R.id.txt_namebook);
            txt_author=itemView.findViewById(R.id.txt_author);
            txt_price=itemView.findViewById(R.id.txt_price);
            img_item=itemView.findViewById(R.id.img_item);

           itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent=new Intent(context,DetailsBook.class);
            intent.putExtra(DetailsBook.ID,data.get(getAdapterPosition()).getId());
            intent.putExtra("name",data.get(getAdapterPosition()).getName());
            intent.putExtra("desc",data.get(getAdapterPosition()).getDescription());
            intent.putExtra("genre",data.get(getAdapterPosition()).getGenre());
            intent.putExtra("author",data.get(getAdapterPosition()).getAuthor());
            intent.putExtra("publish",data.get(getAdapterPosition()).getPublished());
            intent.putExtra("price",data.get(getAdapterPosition()).getPrice());
            intent.putExtra("image",data.get(getAdapterPosition()).getLink_image());
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }
}
