package com.project.oop.bitsgo.fragment;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public abstract class Place {
        private LatLng placeLatLng;
        private String name;
        private ArrayList<String>listOfReviews;
        private ArrayList<Integer>listOfTravelRatings;
        private ArrayList<Integer>listOfOverallRatings;
        private int averageOverallRating;

        public Place(LatLng latLng , String name, String initReview, int initTravelRating, int initOverallRating){
            this.placeLatLng=latLng;
            this.name=name;
            this.listOfReviews=new ArrayList<>(); this.listOfReviews.add(initReview);
            this.listOfOverallRatings=new ArrayList<>(); this.listOfOverallRatings.add(initOverallRating);
            this.listOfTravelRatings=new ArrayList<>(); this.listOfTravelRatings.add(initTravelRating);

            int sum=0;
            for(Integer i:this.listOfOverallRatings){
                sum+=i;
            }
            this.averageOverallRating=sum/this.listOfOverallRatings.size();

        }

        /* Add getter (and maybe later, setter) for all these properties */
        /*  Or change the methods to default directly */
    }
