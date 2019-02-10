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

    private Stack<Fragment> history = new Stack<Fragment>();

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
                history.push(f);
                break;
            case R.id.nav_byoc:
                f = new basicFragment(R.layout.individual_byoc);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,f).commit();
                history.push(f);
                break;
            case R.id.nav_coop:
                f = new basicFragment(R.layout.individual_ri3d);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,f).commit();
                history.push(f);
                break;
            case R.id.nav_durhamtransit:
                f = new basicFragment(R.layout.individual_durhamtransfer);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,f).commit();
                history.push(f);
                break;
            case R.id.nav_ewb:
                f = new basicFragment(R.layout.individual_ewb);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,f).commit();
                history.push(f);
                break;
            case R.id.nav_forensic:
                f = new basicFragment(R.layout.individual_forensic);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,f).commit();
                history.push(f);
                break;
            case R.id.nav_iot:
                f = new basicFragment(R.layout.individual_iot);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,f).commit();
                history.push(f);
                break;
            case R.id.nav_library:
                f = new basicFragment(R.layout.individual_library);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,f).commit();
                history.push(f);
                break;
            case R.id.nav_motorsports:
                f = new basicFragment(R.layout.individual_motorsports);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,f).commit();
                history.push(f);
                break;
            case R.id.nav_nuclear:
                f = new basicFragment(R.layout.individual_erc);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,f).commit();
                history.push(f);
                break;
            case R.id.nav_polonsky:
                f = new VirtualTourPolonsky();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,f).commit();
                history.push(f);
                break;
            case R.id.nav_research:
                f = new basicFragment(R.layout.individual_research);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,f).commit();
                history.push(f);
                break;
            case R.id.nav_ri3d:
                f = new basicFragment(R.layout.individual_ri3d);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,f).commit();
                history.push(f);
                break;
            case R.id.nav_sami:
                f = new basicFragment(R.layout.individual_sami);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,f).commit();
                history.push(f);
                break;
            case R.id.nav_teaching:
                f = new basicFragment(R.layout.individual_teaching);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,f).commit();
                history.push(f);
                break;
            case R.id.nav_tele:
                f = new basicFragment(R.layout.individual_tele);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,f).commit();
                history.push(f);
                break;
            case R.id.nav_testimonials:
                f = new basicFragment(R.layout.individual_testimonials);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,f).commit();
                history.push(f);
                break;
            case R.id.nav_wie:
                f = new basicFragment(R.layout.individual_wie);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,f).commit();
                history.push(f);
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

    public void launchBYOC (View y){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://events.uoit.ca/submit-event.php"));
        startActivity(browserIntent);
    }

    public void launchDonate(View v){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://uoit.ca/payment_gateways/advancement/donations/index.php"));
        startActivity(browserIntent);
    }

    public void launchSurvey(View z){
        Fragment f;
        f = new basicFragment(R.layout.app_bar_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,f).commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item){
        Fragment f;
        switch (item.getItemId()){
            case R.id.nav_Home:
                f = new basicFragment(R.layout.app_bar_main);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,f).commit();
                history.push(f);
                break;
            case R.id.nav_BrilliantYoungMinds:
                f = new basicFragment(R.layout.youngminds);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,f).commit();
                history.push(f);
                break;
            case R.id.nav_WorldClassTalent:
                f = new basicFragment(R.layout.worldclass);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,f).commit();
                history.push(f);
                break;
            case R.id.nav_HighTechFacilities:
                f = new basicFragment(R.layout.techfocus);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,f).commit();
                history.push(f);
                break;
            case R.id.nav_OneOfAKindResearch:
                f = new basicFragment(R.layout.oneofakind);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,f).commit();
                history.push(f);
                break;
            case R.id.nav_Survey:
                f = new basicFragment(R.layout.individual_survey);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,f).commit();
                history.push(f);
                break;
            case R.id.nav_Map:
                f = new Map();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,f).commit();
                history.push(f);
                break;
            case R.id.nav_Donate:
                f = new basicFragment(R.layout.individual_donate);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,f).commit();
                history.push(f);
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
            //if (history.size() > 0){
            //    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,history.pop()).commit();
            //}
            //super.onBackPressed();
        }
    }
}