package com.example.userapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyviewHolder> {

    Context context;
    ArrayList<UserHelperClass> list;

    public MyAdapter(Context context, ArrayList<UserHelperClass> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new MyviewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {


        UserHelperClass userHelperClass =list.get(position);
        holder.Tvname.setText(userHelperClass.getTVname());
        holder.Tvimgurl.setText(userHelperClass.getTVimgurl());
        holder.Videourl.setText(userHelperClass.getVideoUrl());
        holder.Tvname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,show.class);


                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyviewHolder extends RecyclerView.ViewHolder{
        TextView Tvname,Tvimgurl,Videourl;



        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            Tvname = itemView.findViewById(R.id.Tvname);
            Tvimgurl=itemView.findViewById(R.id.Tvimgurl);
            Videourl=itemView.findViewById(R.id.Videourl);



        }
    }
}
