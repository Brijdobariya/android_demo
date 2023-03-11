package com.example.userapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Tvchannal extends AppCompatActivity {
  RecyclerView recyclerView;
  DatabaseReference database;
  MyAdapter myAdapter;


  ArrayList<UserHelperClass> list;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tvchannal);


        recyclerView = findViewById(R.id.userList);
        database = FirebaseDatabase.getInstance().getReference("LiveTv");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list= new ArrayList<>();
        myAdapter =new MyAdapter(this,list);
        recyclerView.setAdapter(myAdapter);
       database.addValueEventListener(new ValueEventListener() {
           @Override
           public void onDataChange(@NonNull DataSnapshot snapshot) {
               for (DataSnapshot dataSnapshot :snapshot.getChildren()){
               UserHelperClass userHelperClass =dataSnapshot.getValue(UserHelperClass.class);
               list.add(userHelperClass);

               }
               myAdapter.notifyDataSetChanged();
           }

           @Override
           public void onCancelled(@NonNull DatabaseError error) {

           }
       });
    }

}
