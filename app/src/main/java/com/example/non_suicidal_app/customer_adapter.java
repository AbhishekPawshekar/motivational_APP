package com.example.non_suicidal_app;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.squareup.picasso.Picasso;

public class customer_adapter extends FirestoreRecyclerAdapter<customer_data_retrive_class,customer_adapter.myholder> {
    public customer_adapter(@NonNull FirestoreRecyclerOptions<customer_data_retrive_class> options) {
        super(options);
    }


    @Override
    protected void onBindViewHolder(@NonNull myholder holder, int position, @NonNull customer_data_retrive_class model) {
        holder.t.setText(model.getName());
        holder.b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:"+model.getPhone1()));
                v.getContext().startActivity(i);
            }
        });
        holder.b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_DIAL);

                i.setData(Uri.parse("tel:"+model.getPhone2()));
                v.getContext().startActivity(i);
            }
        });
        holder.b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_DIAL);

                i.setData(Uri.parse("tel:"+model.getPhone3()));
                v.getContext().startActivity(i);
            }
        });
        holder.i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(v.getContext());
                builder.setMessage("Sure To Delete:"+model.getName())
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                FirebaseFirestore fbfs=FirebaseFirestore.getInstance();
                                fbfs.collection("defaulter").document(model.getEmail()).delete().addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if(task.isSuccessful()){
                                            Toast.makeText(v.getContext(),"!!.Deleted.",Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });


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
        });

            }



    @NonNull
    @Override
    public myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_admin_entities,parent,false);
        return new myholder(view);
    }

    class myholder extends RecyclerView.ViewHolder{
        ImageView i;
        Button b1,b2,b3;
        TextView t;
        public myholder(@NonNull View itemview){
            super(itemview);
            i=itemview.findViewById(R.id.delete);
            b1=itemview.findViewById(R.id.admin_phone_no1);
            b2=itemview.findViewById(R.id.admin_phone_no2);
            b3=itemview.findViewById(R.id.admin_phone_no3);
            t=itemview.findViewById(R.id.admin_name);

        }
    }
}