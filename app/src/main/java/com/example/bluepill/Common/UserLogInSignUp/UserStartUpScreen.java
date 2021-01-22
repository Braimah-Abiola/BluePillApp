package com.example.bluepill.Common.UserLogInSignUp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.example.bluepill.Common.DoctorLogInSignUp.DoctorStartUpScreen;
import com.example.bluepill.Other.AboutActivity;
import com.example.bluepill.R;

public class UserStartUpScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_start_up_screen);
    }

    public void callDoctorStartup(View view){

        startActivity(new Intent(getApplicationContext(), DoctorStartUpScreen.class));

    }

    public void callUserLogIn(View view){

        startActivity(new Intent(getApplicationContext(), UserLogin.class));

    }

    public void callUserSignUp(View view){

        startActivity(new Intent(getApplicationContext(), UserSignUp1.class));

    }

    public void callAbout(View view){

        startActivity(new Intent(getApplicationContext(), AboutActivity.class));

    }



}