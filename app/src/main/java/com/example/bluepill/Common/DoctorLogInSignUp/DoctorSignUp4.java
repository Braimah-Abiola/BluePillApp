package com.example.bluepill.Common.DoctorLogInSignUp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.example.bluepill.Common.UserLogInSignUp.UserSignUp5;
import com.example.bluepill.R;
import com.google.android.material.textfield.TextInputLayout;
import com.hbb20.CountryCodePicker;

public class DoctorSignUp4 extends AppCompatActivity {

    //Variables
    TextInputLayout phoneNumber;
    CountryCodePicker countryCodePicker;
    public static String fullPhoneNumberS;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().setStatusBarColor(getColor(R.color.doctor_pink));

        setContentView(R.layout.activity_doctor_sign_up4);

        //Hooks
        countryCodePicker = findViewById(R.id.country_picker);
        phoneNumber = findViewById(R.id.phone_number);


    }

    public void callDoc5 (View view){
        String phoneNumberS = phoneNumber.getEditText().getText().toString().trim();
        fullPhoneNumberS = "+" + countryCodePicker.getSelectedCountryCode() + phoneNumberS;

        Intent intent4 = new Intent(getApplicationContext(), DoctorSignUp5.class);
        startActivity(intent4);
        finish();

    }

}