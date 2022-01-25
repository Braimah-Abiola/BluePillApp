package com.example.bluepill.User.Features.Reminder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bluepill.R;
import com.example.bluepill.User.UserDashboardActivity;

public class ReminderActivity extends AppCompatActivity {
    private TextView mNoReminderView, mNoReminderView2;
    private ImageView mNoReminderImg;
    Button add_rem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_reminder);

        //hooks
        add_rem = findViewById(R.id.add_reminder);
        mNoReminderImg = findViewById(R.id.no_reminder_image);
        mNoReminderView = findViewById(R.id.no_reminder_text);
        mNoReminderView2 = findViewById(R.id.no_reminder_text2);

        add_rem.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), AddReminder.class)));

    }

    public void callUserDashboardActivity(View view) {
        startActivity(new Intent(getApplicationContext(), UserDashboardActivity.class));
    }
}