package com.example.myapplication;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import com.google.vr.sdk.widgets.pano.VrPanoramaView;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;

    private VrPanoramaView mVRPanoramaView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mVRPanoramaView = (VrPanoramaView) findViewById(R.id.vrPanoramaView);
        loadPhotoSphere();

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

//       if (savedInstanceState == null) {
//           getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ExtraCurriculars()).commit();
//           navigationView.setCheckedItem(R.id.nav_ExtraCurriculars);
//       }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item){
        switch (item.getItemId()){
            case R.id.nav_ExtraCurriculars:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ExtraCurriculars()).commit();
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

    private void loadPhotoSphere() {
        VrPanoramaView.Options options = new VrPanoramaView.Options();
        InputStream inputStream = null;

        AssetManager assetManager = getAssets();
        try {
            inputStream = assetManager.open("vrtest.jpg");
            options.inputType = VrPanoramaView.Options.TYPE_MONO;
            mVRPanoramaView.loadImageFromBitmap(BitmapFactory.decodeStream(inputStream), options);
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}