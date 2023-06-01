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

public class searchview_adapter extends FirestoreRecyclerAdapter<yoga_retrival_class,searchview_adapter.myholder> {
    public searchview_adapter(@NonNull FirestoreRecyclerOptions<yoga_retrival_class> options) {
        super(options);
    }

String category;
    @Override
    protected void onBindViewHolder(@NonNull myholder holder, int position, @NonNull yoga_retrival_class model) {
        Picasso.get().load(model.getUrl()).into(holder.i);
        holder.t.setText(model.getName());
        category=model.getCategory();
        holder.cd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(category.equals("yoga")){
                Intent i=new Intent(v.getContext(),after_yoga_select.class);
                i.putExtra("Name",model.getName());
                i.putExtra("Url",model.url);
                i.putExtra("Description",model.getDescription());
                i.putExtra("Tip",model.getTip());
                v.getContext().startActivity(i);
                }
                else if(model.getName().equals("Yoga")){
                v.getContext().startActivity(new Intent(v.getContext(),yoga_click.class));
                }
               else if(model.getName().equals("Motivation")){
                    v.getContext().startActivity(new Intent(v.getContext(),motivation_click.class));
                }
                else if(model.getName().equals("Meditation")){
                    v.getContext().startActivity(new Intent(v.getContext(),meditation_click.class));
                }
                else if(model.getName().equals("Artical")){
                    v.getContext().startActivity(new Intent(v.getContext(),artical_click.class));
                }

                else if (category.equals("artical")){
                    Intent i=new Intent(v.getContext(),after_artical_select.class);
                    i.putExtra("Name",model.getName());
                    i.putExtra("Description",model.getDescription());
                    v.getContext().startActivity(i);
                }
            }
        });
    }


    @NonNull
    @Override
    public myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_yoga_entities,parent,false);
        return new myholder(view);
    }

    class myholder extends RecyclerView.ViewHolder{
        ImageView i;
        CardView cd;
        TextView t;
        public myholder(@NonNull View itemview){
            super(itemview);
            i=itemview.findViewById(R.id.image_yoga_ui);
            cd=itemview.findViewById(R.id.yoga_card_ui);
            t=itemview.findViewById(R.id.static_name_yoga);

        }
    }
}


