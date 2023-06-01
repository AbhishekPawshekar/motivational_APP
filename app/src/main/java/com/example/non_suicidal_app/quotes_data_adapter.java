package com.example.non_suicidal_app;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

public class quotes_data_adapter extends FirestoreRecyclerAdapter<quotes_retrival_class,quotes_data_adapter.myholder> {
    public quotes_data_adapter(@NonNull FirestoreRecyclerOptions<quotes_retrival_class> options) {
        super(options);
    }


    @Override
    protected void onBindViewHolder(@NonNull myholder holder, int position, @NonNull quotes_retrival_class model) {
        Picasso.get().load(model.getUrl()).into(holder.i);
    }


    @NonNull
    @Override
    public myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_quotes_entities,parent,false);
        return new myholder(view);
    }

    class myholder extends RecyclerView.ViewHolder{
ImageView i;
        public myholder(@NonNull View itemview){
            super(itemview);
                i=itemview.findViewById(R.id.quotes_images);

        }
    }
}


