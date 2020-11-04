package com.project.oop.bitsgo.fragment;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public class Restaurant extends Place {
        private String cuisine;
        private ArrayList<Integer>ambienceRatings;
        private ArrayList<Integer>serviceRatings;
        private ArrayList<Integer>priceRange;
        private java.sql.Time openTime;
        private java.sql.Time closeTime;
        public Restaurant(LatLng latLng, String name, String initReview, int initTravel, int initRating,
            /* Additions: */ String cuisine, int initAmbience, int initService, int initPrice, java.sql.Time openTime, java.sql.Time closeTime) {
            super(latLng, name, initReview, initTravel, initRating);
            this.cuisine=cuisine;
            this.ambienceRatings=new ArrayList<>(); this.ambienceRatings.add(initAmbience);
            this.serviceRatings=new ArrayList<>(); this.serviceRatings.add(initService);
            this.priceRange=new ArrayList<>(); this.priceRange.add(initPrice);
            this.openTime=openTime;
            this.closeTime=closeTime;
        }

        /* Add getter (and maybe later, setter) for all these properties */
        /*  Or change the methods to default directly */
    }
