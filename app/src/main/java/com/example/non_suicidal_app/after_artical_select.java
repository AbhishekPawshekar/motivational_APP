package com.example.non_suicidal_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class after_artical_select extends AppCompatActivity {
TextView t1,t2;
String name,des;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_artical_select);
        Intent i=getIntent();
       name= i.getStringExtra("Name");
        des=i.getStringExtra("Description");
        t1=findViewById(R.id.header_artical);
        t2=findViewById(R.id.description_artical);
        t1.setText(name);
        t2.setText(des);
    }
}