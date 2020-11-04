package com.project.oop.bitsgo.fragment;

import com.google.android.gms.maps.model.LatLng;

import java.sql.Time;
import java.util.ArrayList;

public class Adventure extends Place {
        private ArrayList<Integer>safetyRatings;
        private ArrayList<Integer>sceneryRatings;
        private ArrayList<Integer>difficultyRatings;
        private Time bestTime;
        public Adventure(LatLng latLng, String name, String initReview, int initTravelRating, int initOverallRating,
            /* Additions : */ int initSafety, int initScenery, int initDifficulty, Time bestTime) {
            super(latLng, name, initReview, initTravelRating, initOverallRating);

            this.safetyRatings=new ArrayList<>(); this.safetyRatings.add(initSafety);
            this.sceneryRatings=new ArrayList<>(); this.sceneryRatings.add(initScenery);
            this.difficultyRatings=new ArrayList<>(); this.difficultyRatings.add(initDifficulty);
            this.bestTime=bestTime;
        }

        /* Add getter (and maybe later, setter) for all these properties */
        /*  Or change the methods to default directly */
    }
