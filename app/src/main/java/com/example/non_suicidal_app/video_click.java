package com.example.non_suicidal_app;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link video_click#newInstance} factory method to
 * create an instance of this fragment.
 */
public class video_click extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public video_click() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment video_click.
     */
    // TODO: Rename and change types and number of parameters
    public static video_click newInstance(String param1, String param2) {
        video_click fragment = new video_click();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        RecyclerView rv;
        View view=inflater.inflate(R.layout.fragment_video_click, container, false);
        rv=view.findViewById(R.id.video_recycler);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        FirestoreRecyclerOptions<yoga_retrival_class> options= new FirestoreRecyclerOptions.Builder<yoga_retrival_class>()
                .setQuery(FirebaseFirestore.getInstance().collection("data").whereEqualTo("category","video"),yoga_retrival_class.class)
                .build();
        FirestoreRecyclerAdapter <yoga_retrival_class,viewholder> firestoreRecyclerAdapter=new FirestoreRecyclerAdapter<yoga_retrival_class, viewholder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull viewholder holder, int position, @NonNull yoga_retrival_class model) {
                holder.setExoplayer(getActivity().getApplication(),model.getName(),model.getUrl());
            }

            @NonNull
            @Override
            public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singal_video_entities,parent,false);
                return new viewholder(view);
            }
        };
        firestoreRecyclerAdapter.startListening();
        rv.setAdapter(firestoreRecyclerAdapter);
        return view;
    }


}