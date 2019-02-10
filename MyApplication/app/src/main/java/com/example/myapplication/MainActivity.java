package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
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

    private Stack<Fragment> history;

    private DrawerLayout drawer;
    private Button playButton;
    private VideoView videoview;
    private MediaController mediaController;

    public void back(View button){
        if (history.size() > 0){
           getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,history.pop()).commit();
        }
    }

        public void switchScreen(View button){
        Fragment f;
        switch(button.getId()){
            case R.id.nav_ace:
                f = new VirtualTourAce();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,f).commit();
                //history.push(f);
                break;
            case R.id.nav_byoc:
                f = new basicFragment(R.layout.individual_byoc);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,f).commit();
                //history.push(f);
                break;
            case R.id.nav_coop:
                f = new basicFragment(R.layout.individual_ri3d);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,f).commit();
                //history.push(f);
                break;
            case R.id.nav_durhamtransit:
                f = new basicFragment(R.layout.individual_durhamtransfer);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,f).commit();
                //history.push(f);
                break;
            case R.id.nav_ewb:
                f = new basicFragment(R.layout.individual_ewb);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,f).commit();
                //history.push(f);
                break;
            case R.id.nav_forensic:
                f = new basicFragment(R.layout.individual_forensic);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,f).commit();
                //history.push(f);
                break;
            case R.id.nav_iot:
                f = new basicFragment(R.layout.individual_iot);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,f).commit();
                //history.push(f);
                break;
            case R.id.nav_library:
                f = new basicFragment(R.layout.individual_library);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,f).commit();
                //history.push(f);
                break;
            case R.id.nav_motorsports:
                f = new basicFragment(R.layout.individual_motorsports);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,f).commit();
                //history.push(f);
                break;
            case R.id.nav_nuclear:
                f = new basicFragment(R.layout.individual_erc);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,f).commit();
                //history.push(f);
                break;
            case R.id.nav_research:
                f = new basicFragment(R.layout.individual_research);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,f).commit();
                //history.push(f);
                break;
            case R.id.nav_ri3d:
                f = new basicFragment(R.layout.individual_ri3d);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,f).commit();
                //history.push(f);
                break;
            case R.id.nav_sami:
                f = new basicFragment(R.layout.individual_sami);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,f).commit();
                //history.push(f);
                break;
            case R.id.nav_teaching:
                f = new basicFragment(R.layout.individual_teaching);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,f).commit();
                //history.push(f);
                break;
            case R.id.nav_testimonials:
                f = new basicFragment(R.layout.individual_testimonials);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,f).commit();
                //history.push(f);
                break;
            case R.id.nav_wie:
                f = new basicFragment(R.layout.individual_wie);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,f).commit();
                //history.push(f);
                break;
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

    public Fragment pagetoLayoutObject(Pages p){
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
                return new basicFragment(R.layout.individual_library);
            case FORENSIC_BULDING:
                return new basicFragment(R.layout.individual_forensic);
            case NUCLEAR_POWER:
                return new basicFragment(R.layout.individual_erc);
            case ACE:
                new VirtualTourAce();
            case ONE_OF_A_KIND_RESEARCH:
                return new basicFragment(R.layout.oneofakind);
            case RI3D:
                return new basicFragment(R.layout.individual_ri3d);
            case RESEARCH_PROFESSORS:
                return new basicFragment(R.layout.individual_research);
            case IOT:
                return new basicFragment(R.layout.individual_iot);
        }
        return null;
    }

    public enum Pages {
        HOME, YOUNG_MINDS, WIE, TESTIMONIALS, BRING_YOUR_ON_CHANGE, SAMI, DURHAM_TRANSFER_PROGRAMS, WORLD_CLASS, EWB, COOP, TEACHING_PROFESSORS, HIGH_TECH_FACILITIES,
        MOTORSPORTS, TELE, LIBRARY, FORENSIC_BULDING, NUCLEAR_POWER, ACE, ONE_OF_A_KIND_RESEARCH, RI3D, RESEARCH_PROFESSORS, IOT, ML
    }
}