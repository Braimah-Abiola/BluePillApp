package com.example.bluepill.Common.UserLogInSignUp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bluepill.Common.Dashboard;
import com.example.bluepill.Common.DoctorLogInSignUp.DoctorStartUpScreen;
import com.example.bluepill.Other.AboutActivity;
import com.example.bluepill.R;

public class UserStartUpScreen extends AppCompatActivity {

    // Hooks
    Button signup_btn, login_btn, work_btn, btn_other;
    ImageView background;
    TextView sloganText, app_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_start_up_screen);

        // Hooks
        signup_btn = findViewById(R.id.signup_btn);
        login_btn = findViewById(R.id.login_btn);
        work_btn = findViewById(R.id.work_btn);
        btn_other = findViewById(R.id.btn_other);
        background = findViewById(R.id.background);
        sloganText = findViewById(R.id.sloganText);
        app_name = findViewById(R.id.app_name);

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

    public void callHome(View view){

        startActivity(new Intent(getApplicationContext(), Dashboard.class));

    }

}