package com.example.myapplication;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    private Button playButton;
    private VideoView videoview;
    private MediaController mediaController;

    public void switchScreen(View button){
        switch(button.getId()){
            case R.id.nav_motorsports:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new basicFragment(R.layout.individual_motorsports)).commit();
                break;
            case R.id.nav_durham:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new basicFragment(R.layout.individual_durhamtransfer)).commit();
                break;
            //case R.id.
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
           getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new basicFragment(R.layout.app_bar_main)).commit();
           navigationView.setCheckedItem(R.id.nav_Home);
       }
    }

    public void playVideo(View v){
        playButton = (Button) findViewById(R.id.playButton);
        videoview = (VideoView) findViewById(R.id.videoview);
        mediaController = new MediaController(this);
        mediaController.setAnchorView(videoview);
        videoview.setMediaController(mediaController);
        videoview.setKeepScreenOn(true);
        String videoPath = "android.resource://com.example.myapplication/"+R.raw.btf_promo;
        Uri uri = Uri.parse(videoPath);
        videoview.setVideoURI(uri);
        videoview.start();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item){
        switch (item.getItemId()){
            case R.id.nav_Home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new basicFragment(R.layout.app_bar_main)).commit();
                break;
            case R.id.nav_Information:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new basicFragment(R.layout.information)).commit();
                break;
            case R.id.nav_ExtraCurriculars:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new basicFragment(R.layout.extracurriculars)).commit();
                break;
            case R.id.nav_TechFocus:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new basicFragment(R.layout.techfocus)).commit();
                break;
            case R.id.nav_MentalHealth:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new basicFragment(R.layout.mentalhealth)).commit();
                break;
            case R.id.nav_ConnectedCampus:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new basicFragment(R.layout.campusconnected)).commit();
                break;
            case R.id.nav_StudentLife:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new basicFragment(R.layout.studentlife)).commit();
                break;
            case R.id.nav_VirtualTour:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new VirtualTour()).commit();
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}