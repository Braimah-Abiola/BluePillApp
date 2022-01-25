package com.example.bluepill.Common.UserLogInSignUp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.DatePicker;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bluepill.R;
import com.muddzdev.styleabletoastlibrary.StyleableToast;

import java.util.Calendar;

public class UserSignUp2 extends AppCompatActivity {

    DatePicker datePicker;
    public static int age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_sign_up2);

        // Hooks
        datePicker = findViewById(R.id.birthday_picker);

    }

    public void callPage3(View view) {

        if (!validateAge()) {
            return;
        }

        startActivity(new Intent(getApplicationContext(), UserSignUp3.class));
        finish();

    }

    private boolean validateAge() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int userAge = datePicker.getYear();
        age = currentYear - userAge;

        if (age < 18) {
            StyleableToast.makeText(this, "Sorry you are not eligible to Sign Up", R.style.customToastUserNotEligible).show();
            return false;
        } else
            return true;
    }

}