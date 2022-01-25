package com.example.bluepill.Common.UserLogInSignUp;

import android.content.Intent;
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

import com.example.bluepill.Common.DoctorLogInSignUp.DoctorStartUpScreen;
import com.example.bluepill.R;
import com.example.bluepill.User.Features.Appointments.ViewDoctorProfile;

public class UserStartUpScreen extends AppCompatActivity {

    Animation topAnim;
    Animation bottomAnim;
    Animation leftAnim;
    Animation rightAnim;

    Button signup_btn, login_btn,  btn_other;
    ImageView background;
    TextView sloganText, app_name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_start_up_screen);

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

        background.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), SigningIn.class)));
        app_name.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), ViewDoctorProfile.class)));

    }

    public void callDoctorStartup(View view){
        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.click_sound);
        mediaPlayer.start();
        startActivity(new Intent(getApplicationContext(), DoctorStartUpScreen.class));

    }

    public void callUserLogIn(View view){
        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.click_sound);
        mediaPlayer.start();
        startActivity(new Intent(getApplicationContext(), UserLogin.class));

    }

    public void callUserSignUp(View view){
        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.click_sound);
        mediaPlayer.start();
        startActivity(new Intent(getApplicationContext(), UserSignUp1.class));

    }
}