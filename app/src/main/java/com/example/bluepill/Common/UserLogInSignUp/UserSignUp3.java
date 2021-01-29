package com.example.bluepill.Common.UserLogInSignUp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.example.bluepill.R;

public class UserSignUp3 extends AppCompatActivity {

    Button maleButton, femaleButton, otherButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_sign_up3);

        //Hooks
        maleButton = findViewById(R.id.male);
        femaleButton = findViewById(R.id.female);
        otherButton = findViewById(R.id.other);

    }

    public void callPage4 (View view){

        startActivity(new Intent(getApplicationContext(), UserSignUp4.class));

    }
}