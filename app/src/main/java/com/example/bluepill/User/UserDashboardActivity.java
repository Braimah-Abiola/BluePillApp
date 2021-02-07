package com.example.bluepill.User;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.example.bluepill.Other.AboutActivity;
import com.example.bluepill.R;
import com.google.android.material.navigation.NavigationView;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class UserDashboardActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //Variables
    static final float END_SCALE = 0.7f;

    ChipNavigationBar chipNavigationBar;
    RelativeLayout contentView;
    ImageView menuIcon;

    //Drawer Menu
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_dashboard);

        chipNavigationBar = findViewById(R.id.bottom_nav_menu);
        chipNavigationBar.setItemSelected(R.id.bottom_nav_home, true);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new UserHomeFragment()).commit();
        bottomMenu();

        //Hooks
        contentView = findViewById(R.id.fragment_container);

        //Menu Hooks
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        menuIcon = findViewById(R.id.menu_icon);

        navigationDrawer();

    }

    // Navigation Drawer Functions
    private void navigationDrawer() {

        //Navigation Drawer
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);

        menuIcon.setOnClickListener(view -> {
            if (drawerLayout.isDrawerVisible(GravityCompat.START))
                drawerLayout.closeDrawer(GravityCompat.START);
            else drawerLayout.openDrawer(GravityCompat.START);
        });

        animateNavigationDrawer();

    }

    private void animateNavigationDrawer() {

        drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

                // Scale the View based on current slide offset
                final float diffScaledOffset = slideOffset * (1 - END_SCALE);
                final float offsetScale = 1 - diffScaledOffset;
                contentView.setScaleX(offsetScale);
                contentView.setScaleY(offsetScale);

                // Translate the view, accounting for the scaled width
                final float xOffset = drawerView.getWidth() * slideOffset;
                final float xOffsetDiff = contentView.getWidth() * diffScaledOffset / 2;
                final float xTranslation = xOffset - xOffsetDiff;
                contentView.setTranslationX(xTranslation);
            }

        });

    }

    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else
            super.onBackPressed();
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {

            case R.id.nav_home:
                Intent home = new Intent(getApplicationContext(), UserDashboardActivity.class);
                startActivity(home);
                break;
            case R.id.fleming_lens:
                Intent intent = new Intent(getApplicationContext(), FlemingLens.class);
                startActivity(intent);
                break;
            case R.id.settings:
                Intent settings = new Intent(getApplicationContext(), Settings.class);
                startActivity(settings);
                break;
            case R.id.nav_health_articles:
                Intent articles = new Intent(getApplicationContext(), Articles.class);
                startActivity(articles);
                break;
            case R.id.nav_search:
                Intent search = new Intent(getApplicationContext(), Search.class);
                startActivity(search);
                break;
            case R.id.nav_feedback:
                Intent feedback = new Intent(getApplicationContext(), Feedback.class);
                startActivity(feedback);
                break;
            case R.id.nav_about:
                Intent about = new Intent(getApplicationContext(), AboutActivity.class);
                startActivity(about);
                break;
            case R.id.nav_profile:
                Intent profile = new Intent(getApplicationContext(), UserProfile.class);
                startActivity(profile);
                break;
        }

        return true;
    }


    @SuppressLint("NonConstantResourceId")
    private void bottomMenu() {

        chipNavigationBar.setOnItemSelectedListener(i -> {
            Fragment fragment = null;
            switch (i) {
                case R.id.bottom_nav_home:
                    fragment = new UserHomeFragment();
                    break;
                case R.id.bottom_nav_fleming:
                    fragment = new UserFlemingFragment();
                    break;
                case R.id.bottom_nav_tele_medicine:
                    fragment = new UserTelemedFragment();
                    break;
                case R.id.bottom_nav_dashboard:
                    fragment = new UserDashboardFragment();
                    break;
                case R.id.bottom_nav_explore:
                    fragment = new UserExploreFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
        });

    }

}