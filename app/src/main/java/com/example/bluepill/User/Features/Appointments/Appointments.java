package com.example.bluepill.User.Features.Appointments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.bluepill.R;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class Appointments extends AppCompatActivity {

    ChipNavigationBar chipNavigationBar;
    LinearLayout contentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_appointments);

        chipNavigationBar = findViewById(R.id.tab);
        chipNavigationBar.setItemSelected(R.id.appointment_upcoming, true);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new UpcomingAppointments()).commit();
        tabMenu();

        // Hooks
        contentView = findViewById(R.id.fragment_container);

    }


    @SuppressLint("NonConstantResourceId")
    private void tabMenu() {
        chipNavigationBar.setOnItemSelectedListener(i -> {
            Fragment fragment = null;
            switch (i) {
                case R.id.appointment_upcoming:
                    fragment = new UpcomingAppointments();
                    break;
                case R.id.appointment_past:
                    fragment = new PastAppointments();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
        });

    }

}