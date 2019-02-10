package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import java.util.Stack;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Stack<Pages> history;

    private DrawerLayout drawer;
    private Button playButton;
    private VideoView videoview;
    private MediaController mediaController;

    public void back(View button){
        if (history.size() > 0){
           //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new basicFragment(history.pop())).commit();
        }
    }

        public void switchScreen(View button){
        switch(button.getId()){
            //case R.id.nav_bravethefuture:
                //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new basicFragment(R.layout.individual_btf)).commit();
                //history.push(R.layout.individual_btf);
                //break;
//            case R.id.nav_studentlife:
//                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new basicFragment(R.layout.individual_durhamtransfer)).commit();
//                //history.push(R.layout.individual_durhamtransfer);
//                break;
            case R.id.nav_labs:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new basicFragment(R.layout.individual_labs)).commit();
                //history.push(R.layout.individual_labs);
                break;
            //case R.id.nav_motorsports:
                //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new basicFragment(R.layout.individual_motorsports)).commit();
                //history.push(R.layout.individual_motorsports);
                //break;
            //case R.id.nav_pass:
                //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new basicFragment(R.layout.individual_pass)).commit();
                //history.push(R.layout.individual_pass);
                //break;
            //case R.id.nav_ri3d:
                //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new basicFragment(R.layout.individual_ri3d)).commit();
                //history.push(R.layout.individual_ri3d);
                //break;
            //case R.id.nav_sami:
                //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new basicFragment(R.layout.individual_sami)).commit();
                //history.push(R.layout.individual_sami);
                //break;
            //case R.id.nav_schoolmap:
                //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Map()).commit();

                //break;
            case R.id.nav_software:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new VirtualTourAce()).commit();
                //history.push(R.layout.individual_soft);
                break;

            case R.id.nav_tele:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new basicFragment(R.layout.individual_tele)).commit();
                //history.push(R.layout.individual_tele);
                break;
            case R.id.nav_Donate:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new basicFragment(R.layout.individual_donate)).commit();

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

    public void launchDonate(View v){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://uoit.ca/payment_gateways/advancement/donations/index.php"));
        startActivity(browserIntent);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item){
        switch (item.getItemId()){
            case R.id.nav_Home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new basicFragment(R.layout.app_bar_main)).commit();
                break;
            case R.id.nav_BrilliantYoungMinds:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new basicFragment(R.layout.youngminds)).commit();
                break;
            case R.id.nav_WorldClassTalent:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new basicFragment(R.layout.worldclass)).commit();
                break;
            case R.id.nav_HighTechFacilities:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new basicFragment(R.layout.techfocus)).commit();
                break;
            case R.id.nav_OneOfAKindResearch:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new basicFragment(R.layout.oneofakind)).commit();
                break;
            case R.id.nav_Map:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Map()).commit();
                break;
            case R.id.nav_Donate:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new basicFragment(R.layout.individual_donate)).commit();
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

    public Object switchLayout(Pages p){
        switch (p){
            case HOME:
                return new basicFragment(R.layout.app_bar_main);
            case YOUNG_MINDS:
                return new basicFragment(R.layout.youngminds);
            case WIE:
                return new basicFragment(R.layout.individual_wie);
            case TESTIMONIALS:
                return new basicFragment(R.layout.individual_testimonials);
            case BRING_YOUR_ON_CHANGE:
                return new basicFragment(R.layout.individual_byoc);
            case SAMI:
                return new basicFragment(R.layout.individual_sami);
            case DURHAM_TRANSFER_PROGRAMS:
                return new basicFragment(R.layout.individual_durhamtransfer);
            case WORLD_CLASS:
                return new basicFragment(R.layout.worldclass);
            case EWB:
                return new basicFragment(R.layout.individual_ewb);
            case COOP:
                return new basicFragment(R.layout.individual_coop);
            case TEACHING_PROFESSORS:
                return new basicFragment(R.layout.individual_teaching);
            case HIGH_TECH_FACILITIES:
                return new basicFragment(R.layout.techfocus);
            case MOTORSPORTS:
                return new basicFragment(R.layout.individual_motorsports);
            case TELE:
                return new basicFragment(R.layout.individual_tele);
            case LIBRARY:
                //return new basicFragment(R.layout.library);
            case FORENSIC_BULDING:
                //return new basicFragment(R.layout.individal_forensicbuilding);
            case NUCLEAR_POWER:
                //return new basicFragment(R.layout.nuclearpower);
            case ACE:
                //return new basicFragment(R.layout.ace);
            case ONE_OF_A_KIND_RESEARCH:
                return new basicFragment(R.layout.oneofakind);
            case RI3D:
                return new basicFragment(R.layout.individual_ri3d);
            case RESEARCH_PROFESSORS:
                //return new basicFragment(R.layout.researching);
            case IOT:
                return new basicFragment(R.layout.individual_iot);
            case ML:
                //return new basicFragment(R.layout.ml);
        }
        return null;
    }

    public enum Pages {
        HOME, YOUNG_MINDS, WIE, TESTIMONIALS, BRING_YOUR_ON_CHANGE, SAMI, DURHAM_TRANSFER_PROGRAMS, WORLD_CLASS, EWB, COOP, TEACHING_PROFESSORS, HIGH_TECH_FACILITIES,
        MOTORSPORTS, TELE, LIBRARY, FORENSIC_BULDING, NUCLEAR_POWER, ACE, ONE_OF_A_KIND_RESEARCH, RI3D, RESEARCH_PROFESSORS, IOT, ML
    }
}