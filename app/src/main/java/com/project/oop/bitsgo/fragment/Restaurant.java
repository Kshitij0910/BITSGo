package com.project.oop.bitsgo.fragment;

import com.google.android.gms.maps.model.LatLng;

    public class Restaurant extends Beach {
        String cuisine;
        public Restaurant(LatLng latLng, String name, String initReview, String intiTravel, int initRating,String cuisine) {
            super(latLng, name, initReview, intiTravel, initRating);
            this.cuisine=cuisine;
        }
        //More to be added later
    }
