package com.example.non_suicidal_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;

public class artical_click extends AppCompatActivity {
RecyclerView rv;
artical_data_adapter myadpter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artical_click);
rv=findViewById(R.id.artical_recyclerview);
rv.setLayoutManager(new LinearLayoutManager(this));
        FirestoreRecyclerOptions<yoga_retrival_class> options= new FirestoreRecyclerOptions.Builder<yoga_retrival_class>()
                .setQuery(FirebaseFirestore.getInstance().collection("data").whereEqualTo("category","artical"),yoga_retrival_class.class)
                .build();
        myadpter=new artical_data_adapter(options);
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
}