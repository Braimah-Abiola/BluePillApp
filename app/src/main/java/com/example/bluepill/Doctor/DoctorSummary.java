package com.example.bluepill.Doctor;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bluepill.R;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DoctorSummary extends AppCompatActivity {

    Button goButton;
    TextView yearText, monthText, dayText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_summary);

        //Hooks
        goButton = findViewById(R.id.go);
        yearText = findViewById(R.id.year);
        monthText = findViewById(R.id.month);
        dayText = findViewById(R.id.day);

        goButton.setOnClickListener(v -> { startActivity(new Intent(getApplicationContext(), LoadingActivity.class)); });

        setCurrentDate();

    }

    private void setCurrentDate() {

        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        int currentYear = calendar.get(Calendar.YEAR);
        int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
        String month_name=(String)android.text.format.DateFormat.format("MMMM", new Date());

        //Set the value of the Text Views
        yearText.setText(String.valueOf(currentYear));
        dayText.setText(String.valueOf(currentDay));
        monthText.setText(month_name);

    }
}