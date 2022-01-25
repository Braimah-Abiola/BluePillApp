package com.example.bluepill.User.Features.Appointments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.bluepill.Doctor.DoctorFragment;
import com.example.bluepill.Doctor.DoctorInformationFragment;
import com.example.bluepill.Doctor.MapView;
import com.example.bluepill.R;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class ViewDoctorProfile extends AppCompatActivity {
    RelativeLayout container;
    ChipNavigationBar chipNavigationBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_view_doctor_profile);

        // Hooks
        container = findViewById(R.id.fragment_container);
        chipNavigationBar = findViewById(R.id.doctor_tab);

        chipNavigationBar.setItemSelected(R.id.doctor, true);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new DoctorFragment()).commit();
        bottomMenu();

    }


    @SuppressLint("NonConstantResourceId")
    private void bottomMenu() {

        chipNavigationBar.setOnItemSelectedListener(i -> {
            Fragment fragment = null;
            switch (i) {
                case R.id.doctor:
                    fragment = new DoctorFragment();
                    break;
                case R.id.information:
                    fragment = new DoctorInformationFragment();
                    break;
                case R.id.hospital:
                    fragment = new DoctorInfoHospital();
                    break;
                case R.id.feedback:
                    fragment = new DoctorInfoReviews();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
        });

    }

    public void callMap(View view) {

        startActivity(new Intent(getApplicationContext(), MapView.class));

    }
}

