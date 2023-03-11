package com.example.userapp;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    public EditText Tvname,Tvimg,Url;
    public Button Upload,tvchannal;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Tvname =findViewById(R.id.tvname);
        Tvimg = findViewById(R.id.tvimg);
        Url =findViewById(R.id.url);
        Upload =findViewById(R.id.upload);
        tvchannal =findViewById(R.id.tvchannal);




        tvchannal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Tvchannal.class);
                startActivity(intent);
            }
        });

        Upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rootNode =FirebaseDatabase.getInstance();
                reference= rootNode.getReference("LiveTv");
                String Tvname_ = Tvname.getEditableText().toString();
                String Tvimg_ = Tvimg.getEditableText().toString();
                String Url_ = Url.getEditableText().toString();
                UserHelperClass userHelperClass = new UserHelperClass(Tvname_,Tvimg_,Url_);
                reference.child(Tvname_).setValue(userHelperClass);
            }
        });

    }
}