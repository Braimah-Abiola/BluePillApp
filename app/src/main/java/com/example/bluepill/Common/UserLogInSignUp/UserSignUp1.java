package com.example.bluepill.Common.UserLogInSignUp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.example.bluepill.Other.YoutubeActivity;
import com.example.bluepill.R;
import com.google.android.material.textfield.TextInputLayout;

public class UserSignUp1 extends AppCompatActivity {

    // Get Data Variables
    TextInputLayout fullName, username, email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_sign_up1);

        // Get Data Hooks
        fullName = findViewById(R.id.signup_fullname);
        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

    }

    public void callUserLogIn(View view) {

        startActivity(new Intent(getApplicationContext(), UserLogin.class));

    }

    public void callPage2(View view) {

        if(!validateFullName() | !validateUsername() | !validateEmail() | !validatePassword()){
            return;
        }

        startActivity(new Intent(getApplicationContext(), UserSignUp2.class));

    }


    private boolean validateFullName() {

        String val = fullName.getEditText().getText().toString().trim();

        if (val.isEmpty()) {

            fullName.setError("Field can not be empty");
            return false;

        } else {
            fullName.setError(null);
            fullName.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validateUsername() {

        String val = username.getEditText().getText().toString().trim();
        String checkspaces = "\\A\\w{1,20}\\z";

        if (val.isEmpty()) {

            username.setError("Field can not be empty");
            return false;

        } else if (val.length() > 20) {
            username.setError("Username is too large!");
            return false;
        } else if (val.matches(checkspaces)) {

            username.setError("No spaces are allowed!");
            return false;

        } else {
            username.setError(null);
            username.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validateEmail() {

        String val = email.getEditText().getText().toString().trim();
        String checkemail = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (val.isEmpty()) {
            email.setError("Field can not be empty");
            return false;
        } else if (!val.matches(checkemail)) {
            email.setError("Invalid Email!");
            return false;
        }
        else {
            email.setError(null);
            email.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validatePassword() {

        String val = password.getEditText().getText().toString().trim();
        String checkPassword = "^" +
                //"(?=.*[0-9])" +   // at least 1 digit
                //"(?=.*[a-z])" +   // at least 1 lower case letter
                //"(?=.*[A-Z])" +   // at least 1 upper case letter
                "(?=.*[a-zA-Z])" + // any letter
                "(?=.*[@#$%^&+=])" + // at least one special character
                "(?=\\S+$)" + // no white spaces
                ".{4,}" + //at least 4 characters
                "$";

        if (val.isEmpty()) {
            password.setError("Field can not be empty");
            return false;
        } else if (!val.matches(checkPassword)) {
            password.setError("Password should contain four characters!");
            return false;
        }
        else {
            password.setError(null);
            password.setErrorEnabled(false);
            return true;
        }
    }

    public void callWebsite(View view) {

        startActivity(new Intent(getApplicationContext(), YoutubeActivity.class));

    }

}