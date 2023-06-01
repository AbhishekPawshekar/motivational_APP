package com.example.non_suicidal_app;

import android.content.Intent;
import android.os.Bundle;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class search_text extends AppCompatActivity {
RecyclerView rv;
SearchView searchView;
searchview_adapter myadpter;
FirebaseFirestore fbs=FirebaseFirestore.getInstance();
FirebaseAuth fa=FirebaseAuth.getInstance();
FirebaseUser fu=fa.getCurrentUser();
String name,phone1,phone2,phone3;
List<String> list;
@Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_search_text);
    searchView = findViewById(R.id.texttosearch);
    rv = findViewById(R.id.searchingrecyclerview);
    rv.setLayoutManager(new LinearLayoutManager(this));
    list = new ArrayList();
    list.add("self-destruction");
    list.add("self-murder");
    list.add(" self-slaughter");
    list.add("martyrdom");
    list.add("blood");
    list.add("foul play");
    list.add("homicide");
    list.add("rubout");
    list.add("slaying");
    list.add("killing");
    list.add("murder");
    list.add("depressed");
    list.add("destructive");
    list.add("deadly");
    list.add("self sacrifice");
    list.add("suicide");
    searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String query) {
            String query1=query.toLowerCase().trim();
            if (list.contains(query1)) {
                Toast.makeText(getApplicationContext(), "Prohabited For Searching " + query, Toast.LENGTH_LONG).show();
                fbs.collection("Customer").document(fu.getEmail()).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()) {
                            name = (String) task.getResult().get("Full_Name").toString();
                            phone1 = (String) task.getResult().get("Phone1").toString();
                            phone2 = (String) task.getResult().get("Phone2").toString();
                            phone3 = (String) task.getResult().get("Phone3").toString();
                            Map<String, String> data = new HashMap<>();
                            data.put("name", name);
                            data.put("phone1", phone1);
                            data.put("phone2", phone2);
                            data.put("email", fu.getEmail());
                            data.put("phone3", phone3);

                            fbs.collection("defaulter").document(fu.getEmail()).set(data).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {

                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(getApplicationContext(), "Error:" + e, Toast.LENGTH_LONG).show();
                                }
                            });
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(), "Error:" + e, Toast.LENGTH_LONG).show();
                    }
                });
                startActivity(new Intent(getApplicationContext(), after_search_find_wrong_input.class));
            }
            else if (query1.equals("yoga")) {
                startActivity(new Intent(getApplicationContext(),yoga_click.class));
            }
            else if (query1.equals("meditation")) {
                startActivity(new Intent(getApplicationContext(), meditation_click.class));
            }
            else if (query1.equals("motivation")) {
                startActivity(new Intent(getApplicationContext(), motivation_click.class));
            }
            else if (query1.equals("artical")) {
                startActivity(new Intent(getApplicationContext(), artical_click.class));
            }
            startsearch(query1);
            return false;
        }

        @Override
        public boolean onQueryTextChange(String newText) {
            startsearch(newText.toLowerCase());
            return false;
        }
    });
}
    private void startsearch(String newText) {
        FirestoreRecyclerOptions<yoga_retrival_class> options = new FirestoreRecyclerOptions.Builder<yoga_retrival_class>()
                .setQuery(FirebaseFirestore.getInstance().collection("data").orderBy("name1").startAt(newText).endAt(newText+"\uf8ff"), yoga_retrival_class.class)
                .build();
        myadpter=new searchview_adapter(options);
        myadpter.startListening();
        rv.setAdapter(myadpter);

    }

    @Override
    public void onStop() {
        super.onStop();
        myadpter.stopListening();
    }
}