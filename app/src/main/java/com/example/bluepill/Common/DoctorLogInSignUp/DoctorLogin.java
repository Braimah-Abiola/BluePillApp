package com.example.bluepill.Common.DoctorLogInSignUp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bluepill.R;

public class DoctorLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().setStatusBarColor(getColor(R.color.doctor_pink));
        setContentView(R.layout.activity_doctor_login);
    }

    public void callDoctorSignUp(View view) {
        startActivity(new Intent(getApplicationContext(), DoctorSignUp1.class));
    }

    public void letDoctorLogin(View view) {
    }
}