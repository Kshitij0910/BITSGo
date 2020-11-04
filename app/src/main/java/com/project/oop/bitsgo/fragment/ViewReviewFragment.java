package com.project.oop.bitsgo.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.project.oop.bitsgo.R;


public class ViewReviewFragment extends Fragment {

    Button beach;
    Button restaurant;
    Button adventure;
    Button all;

    public ViewReviewFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_view_review, container, false);

        beach=v.findViewById(R.id.beach);
        restaurant=v.findViewById(R.id.restaurants);
        adventure=v.findViewById(R.id.adventure);
        all=v.findViewById(R.id.all);

        final FragmentManager fragmentManager=getParentFragmentManager();
        final Bundle bundle=new Bundle();
        beach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle.putString("placeType","beach");
                ShowReviews newShowReviews=new ShowReviews();
                newShowReviews.setArguments(bundle);
                fragmentManager.beginTransaction().replace(R.id.fragment_container,newShowReviews).commit();
            }
        });
        restaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle.putString("placeType","restaurant");
                ShowReviews newShowReviews=new ShowReviews();
                newShowReviews.setArguments(bundle);
                fragmentManager.beginTransaction().replace(R.id.fragment_container,newShowReviews).commit();
            }
        });
        adventure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle.putString("placeType","adventure");
                ShowReviews newShowReviews=new ShowReviews();
                newShowReviews.setArguments(bundle);
                fragmentManager.beginTransaction().replace(R.id.fragment_container,newShowReviews).commit();
            }
        });
        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle.putString("placeType","all");
                ShowReviews newShowReviews=new ShowReviews();
                newShowReviews.setArguments(bundle);
                fragmentManager.beginTransaction().replace(R.id.fragment_container,newShowReviews).commit();
            }
        });

        return v;
    }
}