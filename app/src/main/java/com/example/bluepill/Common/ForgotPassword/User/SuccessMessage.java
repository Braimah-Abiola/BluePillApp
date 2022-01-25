package com.example.bluepill.Common.ForgotPassword.User;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.example.bluepill.Common.Connection.CheckConnection2;
import com.example.bluepill.R;

public class SuccessMessage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_success_message);
    }

    public void callCheckConnection2 (View view){

        startActivity(new Intent(getApplicationContext(), CheckConnection2.class));

    }

}