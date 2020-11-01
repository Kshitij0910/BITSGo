package com.project.oop.bitsgo.fragment;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public class Place {
        LatLng placeLatLng;
        String name;
        ArrayList<String>listOfReviews;
        ArrayList<String>listOfTravelDetails;
        ArrayList<Integer>listOfNumberRatings;
        int averageRating;

        public Place(LatLng latLng , String name, String initReview, String intiTravel, int initRating){
            this.placeLatLng=latLng;
            this.name=name;
            this.listOfReviews=new ArrayList<>(); this.listOfReviews.add(initReview);
            this.listOfTravelDetails=new ArrayList<>(); this.listOfTravelDetails.add(intiTravel);
            this.listOfNumberRatings=new ArrayList<>(); this.listOfNumberRatings.add(initRating);
            this.averageRating=initRating;
        }


    }
