package com.example.bluepill.User.Features.Appointments;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bluepill.R;

public class FeedbackDoctor extends AppCompatActivity {
    RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_feedback_doctor);

        // Hooks
        ratingBar = findViewById(R.id.rating_chooser);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(FeedbackDoctor.this, "Stars:" + rating, Toast.LENGTH_SHORT).show();
            }
        });

    }
}