package com.example.non_suicidal_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class account_click extends AppCompatActivity {
    TextView nameaccount,useraccount,phoneaccount,emailaccount,phoneaccount1,phoneaccount2;
    FirebaseAuth fba;
    FirebaseUser fbu;
    FirebaseFirestore fbfs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_click);
        fba=FirebaseAuth.getInstance();
        fbu=fba.getCurrentUser();
        fbfs=FirebaseFirestore.getInstance();
        nameaccount=findViewById(R.id.enternameaccount);
        useraccount=findViewById(R.id.enteruseraccount);
        phoneaccount=findViewById(R.id.enterphoneaccount);
        phoneaccount1=findViewById(R.id.enterphoneaccount1);
        phoneaccount2=findViewById(R.id.enterphoneaccount2);
        emailaccount=findViewById(R.id.enteremailaccount);
        fbfs.collection("Customer").document(fbu.getEmail()).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.isSuccessful()){
                    nameaccount.setText((String) task.getResult().get("First_Name")+" "+task.getResult().get("Last_Name"));
                    useraccount.setText((String)task.getResult().get("User_Name"));
                    phoneaccount.setText((String) task.getResult().get("Phone1"));
                    phoneaccount1.setText((String) task.getResult().get("Phone2"));
                    phoneaccount2.setText((String) task.getResult().get("Phone3"));
                    emailaccount.setText((String) task.getResult().get("Email"));
                }else{
                    Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}