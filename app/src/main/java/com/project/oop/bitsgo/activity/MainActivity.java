package com.project.oop.bitsgo.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;
import com.project.oop.bitsgo.R;
import com.project.oop.bitsgo.fragment.AccountFragment;
import com.project.oop.bitsgo.fragment.AddReviewFragment;
import com.project.oop.bitsgo.fragment.HomeFragment;
import com.project.oop.bitsgo.fragment.SOSFragment;
import com.project.oop.bitsgo.fragment.SettingsFragment;
import com.project.oop.bitsgo.fragment.ViewReviewFragment;

import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    private ChipNavigationBar bottomNavigationView;
    private FragmentManager fragmentManager;
    private NavigationView navigationView;

    //Change by Kushal.
    public void nothingSelected(){
        this.bottomNavigationView.setItemSelected(R.id.nav_home,true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        bottomNavigationView=findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(bottomNavListener);

        hideBottomBar(false);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }
    }

    public void hideBottomBar(boolean isHidden){
        bottomNavigationView.setVisibility(isHidden ? View.GONE : View.VISIBLE);
    }


    private ChipNavigationBar.OnItemSelectedListener bottomNavListener=new ChipNavigationBar.OnItemSelectedListener() {
        @Override
        public void onItemSelected(int i) {
            Fragment selectedFragment = null;
            switch (i) {
                case R.id.nav_add_review:
                    selectedFragment = new AddReviewFragment();
                    break;

                case R.id.nav_view_review:
                    selectedFragment = new ViewReviewFragment();
                    break;


                case R.id.nav_sos:
                    selectedFragment=new SOSFragment();
                    break;

            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
        }
    };




    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
                break;

            case R.id.nav_account:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AccountFragment())./*.addToBackStack(null).*/commit();
                break;

            case R.id.nav_settings:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SettingsFragment())./*.addToBackStack(null).*/commit();
                break;

            case R.id.nav_logout:
                Toast.makeText(this, "User Logging out!", Toast.LENGTH_SHORT).show();
                logout();
                break;



        }
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }

    private void logout() {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(MainActivity.this, LoginActivity.class));
    }


    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } /*else {
            super.onBackPressed();
        } */if(navigationView.getCheckedItem().getItemId() == R.id.nav_home){
            super.onBackPressed();
        } else {
            navigationView.setCheckedItem(R.id.nav_home);
            if(bottomNavigationView.getSelectedItemId() == R.id.nav_add_review)
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AddReviewFragment()).commit();
            else if(bottomNavigationView.getSelectedItemId() == R.id.nav_view_review)
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ViewReviewFragment()).commit();
            else if(bottomNavigationView.getSelectedItemId() == R.id.nav_sos)
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SOSFragment()).commit();
            else
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();

        }

        



    }




}