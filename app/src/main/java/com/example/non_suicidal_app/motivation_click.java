package com.example.non_suicidal_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class motivation_click extends AppCompatActivity {
TextView quotes,video;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motivation_click);
        quotes =findViewById(R.id.request_to_quotes);
        video = findViewById(R.id.request_to_video);
        quotes.setBackgroundColor(Color.argb(255, 1, 151, 243));
        quotes.setTextColor(Color.argb(255,255,255,255));
        getSupportFragmentManager().beginTransaction().replace(R.id.motivation_select_framelayout,new quotes_click()).commit();

        quotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                video.setBackgroundColor(Color.argb(255, 255, 255, 255));
                quotes.setBackgroundColor(Color.argb(255, 1, 151, 243));
                quotes.setTextColor(Color.argb(255,255,255,255));
                video.setTextColor(Color.argb(255,4,116,184));
                getSupportFragmentManager().beginTransaction().replace(R.id.motivation_select_framelayout,new quotes_click()).commit();


            }
        });
        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quotes.setBackgroundColor(Color.argb(255, 255, 255, 255));
                video.setBackgroundColor(Color.argb(255, 1, 151, 243));
                quotes.setTextColor(Color.argb(255,4,116,184));
                video.setTextColor(Color.argb(255,255,255,255));
                getSupportFragmentManager().beginTransaction().replace(R.id.motivation_select_framelayout,new video_click()).commit();


            }
        });

    }
}