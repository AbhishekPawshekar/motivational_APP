package com.example.non_suicidal_app;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class adminview extends AppCompatActivity {
    RecyclerView rv;
    customer_adapter myadpter;
    TextView logout;
    FirebaseAuth fa=FirebaseAuth.getInstance();
    FirebaseUser fu=fa.getCurrentUser();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminview);
        rv=findViewById(R.id.admin_recycler);
        logout=findViewById(R.id.admin_logout);
        rv.setLayoutManager(new LinearLayoutManager(this));
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fu != null) {
                    Intent i = new Intent(getApplicationContext(), login_page.class);
                    fa.signOut();
                    startActivity(i);
                } else {
                    Toast.makeText(getApplicationContext(), "already Logout", Toast.LENGTH_SHORT).show();
                }
            }
        });
        FirestoreRecyclerOptions<customer_data_retrive_class> options= new FirestoreRecyclerOptions.Builder<customer_data_retrive_class>()
                .setQuery(FirebaseFirestore.getInstance().collection("defaulter"),customer_data_retrive_class.class)
                .build();
        myadpter=new customer_adapter(options);
        rv.setAdapter(myadpter);

    }
    @Override
    public void onStart() {
        super.onStart();
        myadpter.startListening();
    }
    @Override
    public void onStop() {
        super.onStop();
        myadpter.stopListening();
    }
    public void onBackPressed() {

        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setMessage("Are You Sure You Want To Exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(Intent.ACTION_MAIN);
                        intent.addCategory(Intent.CATEGORY_HOME);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        finish();

                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alertDialog=builder.create();
        alertDialog.show();
    }

}