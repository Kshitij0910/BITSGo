package com.project.oop.bitsgo.fragment;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public class Beach extends Place {
        private ArrayList<Integer> safetyRatings;
        private ArrayList<Integer> waterSportsRatings;
        private ArrayList<Integer> crowdRatings;
        private ArrayList<Integer> eatOutsRatings;
        public Beach(LatLng latLng, String name,  String initReview, int initTravel, int initRating,
                /* Additions: */ int initSafety, int initCrowd, int initWaterSports, int initEatOuts) {
            super(latLng, name, initReview, initTravel, initRating);

            this.crowdRatings=new ArrayList<>(); this.crowdRatings.add(initCrowd);
            this.waterSportsRatings=new ArrayList<>(); this.waterSportsRatings.add(initWaterSports);
            this.safetyRatings=new ArrayList<>(); this.safetyRatings.add(initSafety);
            this.eatOutsRatings=new ArrayList<>(); this.eatOutsRatings.add(initEatOuts);

        }

        /* Add getter (and maybe later, setter) for all these properties */
        /*  Or change the methods to default directly */
    }
