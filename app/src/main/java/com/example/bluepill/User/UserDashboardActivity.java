package com.example.bluepill.User;

import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.bluepill.R;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class UserDashboardActivity extends AppCompatActivity {

    ChipNavigationBar chipNavigationBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_dashboard);

        chipNavigationBar = findViewById(R.id.bottom_nav_menu);
        chipNavigationBar.setItemSelected(R.id.bottom_nav_home, true);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new  UserHomeFragment()).commit();
        bottomMenu();

    }

    private void  bottomMenu(){

        chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                Fragment fragment = null;
                switch (i){
                    case R.id.bottom_nav_home:
                        fragment = new UserHomeFragment();
                        break;
                    case R.id.bottom_nav_fleming:
                        fragment = new UserFlemingFragment();
                        break;
                    case R.id.bottom_nav_dashboard:
                        fragment = new UserDashboardFragment();
                        break;
                    case R.id.bottom_nav_profile:
                        fragment = new UserProfileFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
            }
        });

    }

}