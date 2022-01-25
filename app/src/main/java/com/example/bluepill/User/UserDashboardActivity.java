package com.example.bluepill.User;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.example.bluepill.Common.About;
import com.example.bluepill.Common.UserLogInSignUp.UserStartUpScreen;
import com.example.bluepill.R;
import com.example.bluepill.User.Features.Articles.Articles;
import com.example.bluepill.User.Features.FlemingLens.FlemingLens;
import com.example.bluepill.User.Features.NavigationActivity;
import com.example.bluepill.User.Features.Reminder.ReminderActivity;
import com.example.bluepill.User.Features.Search.Search;
import com.example.bluepill.User.Features.TeleMed.UserTelemedFragment;
import com.example.bluepill.User.Features.UserInfo.UserProfile;
import com.example.bluepill.User.Features.Videos.VideoActivity;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class UserDashboardActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //Variables
    static final float END_SCALE = 0.7f;
    Dialog dialog;

    ChipNavigationBar chipNavigationBar;
    RelativeLayout contentView, connectionView;
    ImageView menuIcon;
    Button positive, negative;

    //Drawer Menu
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_dashboard);

        chipNavigationBar = findViewById(R.id.bottom_nav_menu);
        chipNavigationBar.setItemSelected(R.id.bottom_nav_home, true);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new UserHomeFragment()).commit();
        bottomMenu();

        //Hooks
        contentView = findViewById(R.id.fragment_container);
        connectionView = findViewById(R.id.connection_status);

        //Menu Hooks
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        menuIcon = findViewById(R.id.menu_icon);

        // Instance of FirebaseAuth
        mAuth = FirebaseAuth.getInstance();

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
                home.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(home);
                break;
            case R.id.fleming_lens:
                Intent intent = new Intent(getApplicationContext(), FlemingLens.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                break;
            case R.id.reminder:
                Intent reminder = new Intent(getApplicationContext(), ReminderActivity.class);
                reminder.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(reminder);
                break;
            case R.id.settings:
                Intent settings = new Intent(getApplicationContext(), Settings.class);
                settings.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(settings);
                break;
            case R.id.nav_health_articles:
                Intent articles = new Intent(getApplicationContext(), Articles.class);
                articles.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(articles);
                break;
            case R.id.nav_search:
                Intent search = new Intent(getApplicationContext(), Search.class);
                search.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(search);
                break;
            case R.id.nav_feedback:
                Intent feedback = new Intent(getApplicationContext(), Feedback.class);
                feedback.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(feedback);
                break;
            case R.id.nav_profile:
                Intent profile = new Intent(getApplicationContext(), UserProfile.class);
                profile.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(profile);
                break;
            case R.id.nav_share:
                // Share Function
                shareApp();
                break;
            case R.id.nav_about:
                Intent about = new Intent(getApplicationContext(), About.class);
                startActivity(about);
                break;
            case R.id.nav_logout:
                logoutDialog();
                break;
            case R.id.nav_videos:
                Intent video = new Intent(getApplicationContext(), VideoActivity.class);
                video.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(video);
                break;
            case R.id.navigation:
                Intent navigation = new Intent(getApplicationContext(), NavigationActivity.class);
                navigation.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(navigation);
                break;
            case R.id.nav_rate:
                //Rate Function
                rateBluePillPopup();
                break;
        }

        return true;
    }

    private void rateBluePillPopup() {

        dialog = new Dialog(UserDashboardActivity.this, R.style.BottomSheetTheme);

        View dialogView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.rate_app_confirmation_dialog,
                findViewById(R.id.rate_popup));

        dialog.setContentView(dialogView);
        dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        dialog.show();

        //Hooks
        positive = dialogView.findViewById(R.id.positive);
        negative = dialogView.findViewById(R.id.negative);

        positive.setOnClickListener(v -> {
            rateBluePill();
            dialog.dismiss();
        });
        negative.setOnClickListener(v -> dialog.dismiss());
    }

    private void rateBluePill() {
        try {
            // Open App Page
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/")));
        } catch (ActivityNotFoundException e) {
            // Open Developer Page
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/")));
        }
    }

    private void shareApp() {

        // Show Share Bottom Sheet
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        String shareBodyText = "Download BluePill (Revolutionizing Healthcare)";
        String shareLink = "https://play.google.com/bluepill";
        shareIntent.putExtra(Intent.EXTRA_TEXT, shareBodyText);
        shareIntent.putExtra(Intent.EXTRA_TEXT, shareLink);
        shareIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(Intent.createChooser(shareIntent, "Share"));

    }

    private void logoutDialog() {
        dialog = new Dialog(UserDashboardActivity.this, R.style.BottomSheetTheme);

        View dialogView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.logout_popup,
                findViewById(R.id.logout));

        dialog.setContentView(dialogView);
        dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        dialog.show();

        //Hooks
        positive = dialogView.findViewById(R.id.positive);
        negative = dialogView.findViewById(R.id.negative);

        positive.setOnClickListener(v -> {
            mAuth.signOut();
            finish();
            Intent intent = new Intent(getApplicationContext(), UserStartUpScreen.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            dialog.dismiss();
        });
        negative.setOnClickListener(v -> dialog.dismiss());
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
            assert fragment != null;
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
        });

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (dialog != null && dialog.isShowing()) {
            dialog.cancel();
        }
    }

}