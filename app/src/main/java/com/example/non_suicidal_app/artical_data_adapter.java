package com.example.non_suicidal_app;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.squareup.picasso.Picasso;

public class artical_data_adapter extends FirestoreRecyclerAdapter<yoga_retrival_class,artical_data_adapter.myholder> {
    public artical_data_adapter(@NonNull FirestoreRecyclerOptions<yoga_retrival_class> options) {
        super(options);
    }


    @Override
    protected void onBindViewHolder(@NonNull myholder holder, int position, @NonNull yoga_retrival_class model) {
        Picasso.get().load(model.getUrl()).into(holder.i);
        holder.t.setText(model.getName());
        holder.cd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(v.getContext(),after_artical_select.class);
                i.putExtra("Name",model.getName());
                i.putExtra("Description",model.getDescription());
                v.getContext().startActivity(i);
            }
        });
    }


    @NonNull
    @Override
    public myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_artical_entities,parent,false);
        return new myholder(view);
    }

    class myholder extends RecyclerView.ViewHolder{
        ImageView i;
        CardView cd;
        TextView t;
        public myholder(@NonNull View itemview){
            super(itemview);
            i=itemview.findViewById(R.id.image_artical_ui);
            cd=itemview.findViewById(R.id.card_artical_ui);
            t=itemview.findViewById(R.id.static_name_artical);

        }
    }
}