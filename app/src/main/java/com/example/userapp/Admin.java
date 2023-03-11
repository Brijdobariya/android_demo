package com.example.userapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Admin extends AppCompatActivity {
Button button;
EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        button=findViewById(R.id.submit);
        editText=findViewById(R.id.password);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //String A ="Brij@8115";
               String edit = editText.getEditableText().toString();
                if(edit.equals("81158115")){
                    Intent intent =new Intent(Admin.this,MainActivity.class);
                    startActivity(intent);
                }else {

                }

            }
        });



    }
}