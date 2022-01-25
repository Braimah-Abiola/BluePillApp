package com.example.bluepill.Common.UserLogInSignUp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bluepill.R;
import com.google.android.material.textfield.TextInputLayout;
import com.hbb20.CountryCodePicker;

public class UserSignUp4 extends AppCompatActivity {

    //Variables
    TextInputLayout phoneNumber;
    CountryCodePicker countryCodePicker;
    public static String fullPhoneNumberS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_sign_up4);

        //Hooks
        countryCodePicker = findViewById(R.id.country_picker);
        phoneNumber = findViewById(R.id.phone_number);

    }

    public void callPage5 (View view){

        String phoneNumberS = phoneNumber.getEditText().getText().toString().trim();
        fullPhoneNumberS = "+" + countryCodePicker.getSelectedCountryCode() + phoneNumberS;

        Intent intent4 = new Intent(getApplicationContext(), UserSignUp5.class);
        startActivity(intent4);
        finish();

    }


}