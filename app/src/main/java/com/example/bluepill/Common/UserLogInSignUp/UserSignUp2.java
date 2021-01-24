package com.example.bluepill.Common.UserLogInSignUp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.DatePicker;
import android.widget.Toast;

import com.example.bluepill.R;

import java.util.Calendar;

public class UserSignUp2 extends AppCompatActivity {

    DatePicker datePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_sign_up2);

        // Hooks
        datePicker = findViewById(R.id.birthday_picker);

    }

    public void callPage3(View view) {

        if(!validateAge()){
            return;
        }

        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year = datePicker.getYear();

        String _date = day+"/"+month+"/"+year;

        startActivity(new Intent(getApplicationContext(), UserSignUp3.class));

    }

    private boolean validateAge() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int userAge = datePicker.getYear();
        int isAgeValid = currentYear - userAge;

        if (isAgeValid < 18) {
            Toast.makeText(this, "Sorry you are not eligible to Sign Up", Toast.LENGTH_SHORT).show();
            return false;
        } else
            return true;
    }
}