package com.project.oop.bitsgo.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.project.oop.bitsgo.R;
import com.project.oop.bitsgo.activity.MainActivity;

import java.lang.reflect.Type;
import java.sql.Time;

public class WriteReview extends Fragment {

    Button sendReview;
    TextView name;
    TextView typeText; // To be changed later to a multiple choice option.
    EditText review;
    EditText travelDetails;
    EditText rating; //Can (should) be changed later to a scrollbar or something.


    public WriteReview() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Bundle bundle=getArguments();
        String latLngJson=bundle.getString("LatLngJsonString");
        Gson gson=new Gson();
        Type type= new TypeToken<LatLng>(){}.getType();
        final LatLng latLng=gson.fromJson(latLngJson,type);

        View v=inflater.inflate(R.layout.fragment_write_review, container, false);
        sendReview=v.findViewById(R.id.sendReview);
        name=v.findViewById(R.id.name);
        typeText=v.findViewById(R.id.type);
        review=v.findViewById(R.id.review);
        travelDetails=v.findViewById(R.id.travelDetails);
        rating=v.findViewById(R.id.rating);


        MainActivity activity = (MainActivity) getActivity();
        if (activity != null)
            activity.hideBottomBar(true);


        sendReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Null field checks
                if(name.getText().toString().matches("") || typeText.getText().toString().matches("")||rating.getText().toString().matches("")
                ||review.getText().toString().matches("")||travelDetails.getText().toString().matches("")){
                    Toast.makeText(getContext(), "Please enter a name for your place along with its type and a numbered rating 1-10 and your own personalized review and travel details!", Toast.LENGTH_SHORT).show();
                }
                else if(Integer.parseInt(rating.getText().toString())>10 ||Integer.parseInt(rating.getText().toString())<0){
                    Toast.makeText(getContext(), "Please enter an integer between 0-10!", Toast.LENGTH_SHORT).show();
                }
                else{
                    new AlertDialog.Builder(getContext())
                            .setTitle("Submit review?")
                            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    if(typeText.getText().toString().matches("beach")){
                                        Beach newBeach=new Beach(latLng,name.getText().toString(),review.getText().toString(),Integer.parseInt(travelDetails.getText().toString()),Integer.parseInt(rating.getText().toString()),0,0,0,0);
                                        /* For now just keeping additional properties ==0, later if needed will create separate fragment or something*/

                                        /*
                                            Add this beach to database.
                                        */
                                    }else if(typeText.getText().toString().matches("restaurant")){
                                        Restaurant newRest=new Restaurant(latLng,name.getText().toString(),review.getText().toString(),Integer.parseInt(travelDetails.getText().toString()),Integer.parseInt(rating.getText().toString()),"PlaceHolder",0,0,0,new Time(0,0,0),new Time(0,0,0));
                                        /* For now just keeping additional properties ==0, later if needed will create separate fragment or something*/

                                        /*
                                            Add this restaurant to database.
                                        */
                                    }else if(typeText.getText().toString().matches("adventure")){
                                        Adventure newAdv=new Adventure(latLng,name.getText().toString(),review.getText().toString(),Integer.parseInt(travelDetails.getText().toString()),Integer.parseInt(rating.getText().toString()),0,0,0,new Time(0,0,0));
                                        /* For now just keeping additional properties ==0, later if needed will create separate fragment or something*/

                                        /*
                                            Add this restaurant to database.
                                        */
                                    }

                                    Toast.makeText(getContext(), "Review added!", Toast.LENGTH_SHORT).show();
                                    FragmentManager fragmentManager=getParentFragmentManager();
                                    fragmentManager.beginTransaction().replace(R.id.fragment_container,new HomeFragment()).commit();
                                }
                            })
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            }).show();
                }
            }
        });
        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        MainActivity activity = (MainActivity) getActivity();
        if (activity != null)
            activity.hideBottomBar(false);    // to show the bottom bar when
        // we destroy this fragment
    }
}