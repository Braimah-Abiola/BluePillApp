package com.example.bluepill.Common.DoctorLogInSignUp;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bluepill.Common.UserLogInSignUp.UserStartUpScreen;
import com.example.bluepill.Doctor.DoctorDashboardActivity;
import com.example.bluepill.Doctor.DoctorSummary;
import com.example.bluepill.R;

public class DoctorStartUpScreen extends AppCompatActivity {

    Animation topAnim;
    Animation bottomAnim;
    Animation leftAnim;
    Animation rightAnim;

    // Hooks
    Button signup_btn, login_btn, btn_other;
    ImageView background;
    TextView sloganText, app_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().setStatusBarColor(getColor(R.color.doctor_pink));
        setContentView(R.layout.activity_doctor_start_up_screen);

        // Hooks
        signup_btn = findViewById(R.id.signup_btn);
        login_btn = findViewById(R.id.login_btn);
        btn_other = findViewById(R.id.btn_other);
        background = findViewById(R.id.background);
        sloganText = findViewById(R.id.sloganText);
        app_name = findViewById(R.id.app_name);

        // Animations
        topAnim = AnimationUtils.loadAnimation(this,R.anim.intro_animation_top);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.intro_animation_bottom);
        leftAnim =AnimationUtils.loadAnimation(this, R.anim.animation_left);
        rightAnim = AnimationUtils.loadAnimation(this, R.anim.animation_right);

        background.setAnimation(topAnim);
        app_name.setAnimation(topAnim);
        sloganText.setAnimation(topAnim);
        btn_other.setAnimation(bottomAnim);
        login_btn.setAnimation(leftAnim);
        signup_btn.setAnimation(rightAnim);

        background.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), DoctorSummary.class)));

    }

    public void callUserStartup(View view){

        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.click_sound);
        mediaPlayer.start();
        startActivity(new Intent(getApplicationContext(), UserStartUpScreen.class));

    }

    public void callWarning(View view){

        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.click_sound);
        mediaPlayer.start();
        startActivity(new Intent(getApplicationContext(), DoctorDashboardActivity.class));

    }

    public void callDoctorLogin(View view){

        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.click_sound);
        mediaPlayer.start();
        startActivity(new Intent(getApplicationContext(), DoctorLogin.class));

    }

    public void callDoc1(View view){

        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.click_sound);
        mediaPlayer.start();
        startActivity(new Intent(getApplicationContext(), DoctorSignUp1.class));

    }

}