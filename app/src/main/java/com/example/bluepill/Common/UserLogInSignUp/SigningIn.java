package com.example.bluepill.Common.UserLogInSignUp;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.example.bluepill.R;
import com.example.bluepill.User.UserDashboardActivity;

public class SigningIn extends AppCompatActivity {
    private long ms=0;
    private long splashTime=2000;
    private boolean splashActive = true;
    private boolean paused=false;
    LottieAnimationView lottieAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_signing_in);

        lottieAnimation = findViewById(R.id.lottie_animation);
        Thread loading = new Thread() {
            public void run() {
                try {
                    while (splashActive && ms < splashTime) {
                        if(!paused)
                            ms=ms+100;
                        sleep(100);
                    }
                } catch(Exception e) {}
                finally {
                    startActivity(new Intent(getApplicationContext(), UserDashboardActivity.class));
                    finish();
                }
            }
        };
        loading.start();
    }

}