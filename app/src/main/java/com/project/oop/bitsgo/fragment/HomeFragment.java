package com.project.oop.bitsgo.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.oop.bitsgo.R;
import com.project.oop.bitsgo.activity.MainActivity;


public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View homeView = inflater.inflate(R.layout.fragment_home, container, false);
        MainActivity activity = (MainActivity) getActivity();
        if (activity != null)
            activity.nothingSelected();
        //Change by Kushal. Above done so that once we go back to a Home fragment, no bottom tab is selected.
        return homeView;
    }
}