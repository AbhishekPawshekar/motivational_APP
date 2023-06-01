package com.example.non_suicidal_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class after_yoga_select extends AppCompatActivity {
TextView tip,description,header;
ImageView image;
String name,url,des,tip1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_yoga_select);
        Intent i=getIntent();
       name= i.getStringExtra("Name");
        url=i.getStringExtra("Url");
       des= i.getStringExtra("Description");
        tip1=i.getStringExtra("Tip");

        image=findViewById(R.id.image_yoga_select);
        tip=findViewById(R.id.tip);
        description=findViewById(R.id.description);
        header=findViewById(R.id.headering_yoga);

        Picasso.get().load(url).into(image);
        header.setText(name);
        description.setText(des);
        tip.setText(tip1);
    }
}