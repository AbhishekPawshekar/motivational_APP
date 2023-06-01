package com.example.non_suicidal_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class after_search_find_wrong_input extends AppCompatActivity {
TextView motivation,meditation,yoga,artical,helpline,hobbies;
FirebaseAuth fa=FirebaseAuth.getInstance();
FirebaseUser fbu=fa.getCurrentUser();
FirebaseFirestore fbfs=FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_search_find_wrong_input);
        motivation=findViewById(R.id.get_motivated);
        meditation=findViewById(R.id.do_meditation);
        yoga=findViewById(R.id.do_yoga);
        helpline=findViewById(R.id.helpline_no);
        artical=findViewById(R.id.read_artical);
        hobbies=findViewById(R.id.hobbies_text);
        motivation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),motivation_click.class));
            }
        });
        meditation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),meditation_click.class));
            }
        });
        yoga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),yoga_click.class));
            }
        });
        artical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),artical_click.class));
            }
        });
        helpline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:9820466726"));
                v.getContext().startActivity(i);
            }
        });
        fbfs.collection("Customer").document(fbu.getEmail()).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
           if(task.isSuccessful()){
               hobbies.setText((String) task.getResult().get("Hobbies"));

           }
            }
        });

    }
}