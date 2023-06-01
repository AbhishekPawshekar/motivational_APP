package com.example.non_suicidal_app;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link home_click#newInstance} factory method to
 * create an instance of this fragment.
 */
public class home_click extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public home_click() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment home_click.
     */
    // TODO: Rename and change types and number of parameters
    public static home_click newInstance(String param1, String param2) {
        home_click fragment = new home_click();
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
    ImageSlider imageSlider;
    TextView searchview;
    ImageView motivation_sample_icon,meditation_sample_icon,yoga_sample_icon,artical_sample_icon,search_image;
    CardView motivation_card,motivation_card_icon,meditation_card,meditation_card_icon, yoga_card,yoga_card_icon,artical_card,artical_card_icon;
    RelativeLayout motivation_relative,meditation_relative,yoga_relative,artical_relative;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_home_click, container, false);
        imageSlider=view.findViewById(R.id.imageSlider);
        motivation_sample_icon=view.findViewById(R.id.motivation_sample_icon);
        meditation_sample_icon=view.findViewById(R.id.meditation_sample_icon);
        yoga_sample_icon=view.findViewById(R.id.yoga_sample_icon);
        artical_sample_icon=view.findViewById(R.id.artical_sample_icon);

        meditation_card_icon=view.findViewById(R.id.meditation_card_icon);
        motivation_card_icon=view.findViewById(R.id.motivation_card_icon);
        yoga_card_icon=view.findViewById(R.id.yoga_card_icon);
        artical_card_icon=view.findViewById(R.id.artical_card_icon);

        meditation_card=view.findViewById(R.id.meditation_card);
        motivation_card=view.findViewById(R.id.motivation_card);
        yoga_card=view.findViewById(R.id.yoga_card);
        artical_card=view.findViewById(R.id.artical_card);

        motivation_relative=view.findViewById(R.id.motivation_reletive);
        meditation_relative=view.findViewById(R.id.meditation_reletive);
        yoga_relative=view.findViewById(R.id.yoga_reletive);
        artical_relative=view.findViewById(R.id.artical_reletive);

searchview=view.findViewById(R.id.searchview);
search_image=view.findViewById(R.id.searchview_image);
search_image.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(getContext(),search_text.class));
    }
});
searchview.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(getContext(),search_text.class));
    }
});
        List<SlideModel> imageList=new ArrayList<>();

        imageList.add(new SlideModel(R.drawable.motivational_background1));
        imageList.add(new SlideModel(R.drawable.motivation_background2));
        imageList.add(new SlideModel(R.drawable.motivation_background3));
        imageList.add(new SlideModel(R.drawable.motivation_background4));
        imageSlider.setImageList(imageList,false);

        motivation_sample_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),motivation_click.class));
            }
        });
        meditation_sample_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),meditation_click.class));
            }
        });
        yoga_sample_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),yoga_click.class));
            }
        });
        artical_sample_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),artical_click.class));
            }
        });
        motivation_card_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),motivation_click.class));
            }
        });
        meditation_card_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),meditation_click.class));
            }
        }); yoga_card_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),yoga_click.class));
            }
        });
        artical_card_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),artical_click.class));
            }
        });
        motivation_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),motivation_click.class));
            }
        }); meditation_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),meditation_click.class));
            }
        }); yoga_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),yoga_click.class));
            }
        }); artical_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),artical_click.class));
            }
        }); motivation_relative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),motivation_click.class));
            }
        }); meditation_relative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),meditation_click.class));
            }
        }); yoga_relative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),yoga_click.class));
            }
        }); artical_relative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),artical_click.class));
            }
        });

        return view;
    }


}