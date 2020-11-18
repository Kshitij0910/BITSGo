package com.project.oop.bitsgo.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.project.oop.bitsgo.R;
import com.project.oop.bitsgo.activity.MainActivity;


public class AccountFragment extends Fragment {

    private TextView mNameTextView;
    private TextView mEmailTextView;
    private FirebaseAuth mAuth;

    public AccountFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View accountView = inflater.inflate(R.layout.fragment_account, container, false);

        mAuth = FirebaseAuth.getInstance();

        MainActivity activity = (MainActivity) getActivity();
        if (activity != null)
            activity.hideBottomBar(true);

        return accountView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        FirebaseUser user = mAuth.getCurrentUser();

        if(user!=null){
            String name= user.getDisplayName();
            String email= user.getEmail();

            mNameTextView= requireActivity().findViewById(R.id.account_name_textview);
            mEmailTextView= requireActivity().findViewById(R.id.account_email_textview);

            mEmailTextView.setText(email);
            mNameTextView.setText(name);
        }
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