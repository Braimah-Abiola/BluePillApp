package com.example.bluepill;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;


public class IntroductoryActivity extends AppCompatActivity {

    ImageView logo, icon;
    TextView appName;
    LottieAnimationView lottieAnimationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_introductory);
        icon = findViewById(R.id.icon);
        logo = findViewById(R.id.logo);
        appName = findViewById(R.id.txt);
        lottieAnimationView = findViewById(R.id.lottie);

        logo.animate().translationY(1400).setDuration(1000).setStartDelay(4000);
        appName.animate().translationY(1400).setDuration(1000).setStartDelay(4000);
        icon.animate().translationY(1400).setDuration(1000).setStartDelay(4000);
        lottieAnimationView.animate().translationY(1400).setDuration(1000).setStartDelay(4000);

        Runnable r = new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(IntroductoryActivity.this, Login.class));
            }
        };

        Handler h = new Handler();
        h.postDelayed(r, 4000);

    }


}