package com.example.bluepill.Common.DoctorLogInSignUp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.DatePicker;

import com.example.bluepill.Common.UserLogInSignUp.UserSignUp3;
import com.example.bluepill.R;
import com.muddzdev.styleabletoastlibrary.StyleableToast;

import java.util.Calendar;

public class DoctorSignUp2 extends AppCompatActivity {

    DatePicker datePicker;
    public static int age;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().setStatusBarColor(getColor(R.color.doctor_pink));

        setContentView(R.layout.activity_doctor_sign_up2);

        // Hooks
        datePicker = findViewById(R.id.doctor_birthday_picker);


    }

    public void callDoc3 (View view){

        if (!validateAge()) {
            return;
        }

        startActivity(new Intent(getApplicationContext(), DoctorSignUp3.class));
        finish();

    }

    private boolean validateAge() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int userAge = datePicker.getYear();
        age = currentYear - userAge;

        if (age < 18) {
            StyleableToast.makeText(this, "Sorry you are not eligible to Sign Up", R.style.customToastDoctorNotEligible).show();
            return false;
        } else
            return true;
    }

}