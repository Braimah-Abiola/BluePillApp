package com.example.bluepill.Common.DoctorLogInSignUp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.example.bluepill.Common.UserLogInSignUp.UserStartUpScreen;
import com.example.bluepill.Common.Warnings.CheckConnection;
import com.example.bluepill.R;
import com.example.bluepill.User.UserDashboardActivity;

public class DoctorStartUpScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_doctor_start_up_screen);
    }

    public void callDashboard(View view){

        startActivity(new Intent(getApplicationContext(), UserDashboardActivity.class));

    }

    public void callUserStartup(View view){

        startActivity(new Intent(getApplicationContext(), UserStartUpScreen.class));

    }

    public void callWarning(View view){

        startActivity(new Intent(getApplicationContext(), CheckConnection.class));

    }

    public void callDoctorLogin(View view){

        startActivity(new Intent(getApplicationContext(), DoctorLogin.class));

    }

}