package com.example.bluepill.User.Features.Search;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bluepill.R;
import com.example.bluepill.User.UserDashboardActivity;

public class Search extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_search);
    }

    public void callUserDashboardActivity(View view) {
        startActivity(new Intent(getApplicationContext(), UserDashboardActivity.class));
    }
}