package com.example.non_suicidal_app;

import android.os.Bundle;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.firestore.FirebaseFirestore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

public class yoga_click extends AppCompatActivity {
RecyclerView rv;
yoga_data_adapter myadpter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoga_click);
        rv=findViewById(R.id.yoga_recylerview);
        rv.setLayoutManager(new GridLayoutManager(this,2));
        FirestoreRecyclerOptions<yoga_retrival_class> options= new FirestoreRecyclerOptions.Builder<yoga_retrival_class>()
                .setQuery(FirebaseFirestore.getInstance().collection("data").whereEqualTo("category","yoga"),yoga_retrival_class.class)
                .build();
        myadpter=new yoga_data_adapter(options);
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