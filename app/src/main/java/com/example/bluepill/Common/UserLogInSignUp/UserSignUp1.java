package com.example.bluepill.Common.UserLogInSignUp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.example.bluepill.Other.YoutubeActivity;
import com.example.bluepill.R;

public class UserSignUp1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_sign_up1);
    }
    public void callUserLogIn(View view){

        startActivity(new Intent(getApplicationContext(), UserLogin.class));

    }

    public void callPage2 (View view){

        startActivity(new Intent (getApplicationContext(), UserSignUp2.class));

    }

    public void callWebsite (View view){

        startActivity(new Intent (getApplicationContext(), YoutubeActivity.class));

    }

}