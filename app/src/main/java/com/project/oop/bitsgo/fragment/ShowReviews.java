package com.project.oop.bitsgo.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.project.oop.bitsgo.R;

import java.util.ArrayList;

public class ShowReviews extends Fragment {

    ArrayList<Place> toBeShown;


    public ShowReviews() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_show_reviews, container, false);

        Bundle bundle=getArguments();
        toBeShown=new ArrayList<>();
        /*Remove later*/Toast.makeText(getContext(), bundle.getString("placeType"), Toast.LENGTH_SHORT).show();

        if(bundle.getString("placeType").matches("beach")){
            /*
               Retrieve from database, all Beach places. For now store them in an ArrayList of Places that ive created
               Later if needed we can use a better recycler view or something
            */
        } else if(bundle.getString("placeType").matches("restaurant")){
            /*
               Retrieve from database, all Restaurant places. For now store them in an ArrayList of Places that ive created
               Later if needed we can use a better recycler view or something
            */
        }else if(bundle.getString("placeType").matches("adventure")){
            /*
               Retrieve from database, all Adventure places. For now store them in an ArrayList of Places that ive created
               Later if needed we can use a better recycler view or something
            */
        }else if(bundle.getString("placeType").matches("all")){
            /*
               Retrieve from database, All places. For now store them in an ArrayList of Places that ive created
               Later if needed we can use a better recycler view or something
            */
        }else{
            // OOPS. Something went wrong.
        }


        return v;


    }
}