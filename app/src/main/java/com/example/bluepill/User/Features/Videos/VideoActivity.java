package com.example.bluepill.User.Features.Videos;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.bluepill.R;
import com.example.bluepill.User.UserDashboardActivity;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class VideoActivity extends AppCompatActivity {

    ChipNavigationBar chipNavigationBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_video);

        chipNavigationBar = findViewById(R.id.bottom_nav_menu);
        chipNavigationBar.setItemSelected(R.id.bottom_nav_insights, true);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new InsightFragment()).commit();
        bottomMenu();


    }

    @SuppressLint("NonConstantResourceId")
    private void bottomMenu() {

        chipNavigationBar.setOnItemSelectedListener(i -> {
            Fragment fragment = null;
            switch (i) {
                case R.id.bottom_nav_insights:
                    fragment = new InsightFragment();
                    break;
                case R.id.bottom_nav_list:
                    fragment = new MyListFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
        });

    }

    public void callUserDashboardActivity(View view) {
        startActivity(new Intent(getApplicationContext(), UserDashboardActivity.class));
    }
}