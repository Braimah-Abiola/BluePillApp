package com.example.bluepill.Common.DoctorLogInSignUp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bluepill.R;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;

public class DoctorSignUp1 extends AppCompatActivity {

    public static String fullNameS, doctorIdS, emailS, passwordS;

    TextInputLayout fullName, doctorID, email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().setStatusBarColor(getColor(R.color.doctor_pink));

        setContentView(R.layout.activity_doctor_sign_up1);

        // Hooks
        fullName = findViewById(R.id.signup_fullname);
        doctorID = findViewById(R.id.username);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

    }


    /*
    Validate
    Input
     */

    private boolean validateFullName() {

        String val = fullName.getEditText().getText().toString().trim();
        String check_spaces = "\\A\\w{1,20}\\z";

        if (val.isEmpty()) {

            fullName.setError("Field cannot be empty!");
            return false;

        } else if (val.matches(check_spaces)) {
            fullName.setError("Enter your full name!");
            return false;
        } else {
            fullName.setError(null);
            fullName.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validateID() {
        String val = doctorID.getEditText().getText().toString().trim();
        String check_spaces = "\\A\\w{1,20}\\z";

        if (val.isEmpty()) {
            doctorID.setError("Field cannot be empty!");
            return false;
        } else if (val.length() > 10) {
            doctorID.setError("Username is too long!");
            return false;
        } else if (!val.matches(check_spaces)) {
            doctorID.setError("No spaces are allowed!");
            return false;
        } else {
            doctorID.setError(null);
            doctorID.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validateEmail() {

        String val = email.getEditText().getText().toString().trim();
        String check_email = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (val.isEmpty()) {
            email.setError("Field cannot be empty!");
            return false;
        } else if (!val.matches(check_email)) {
            email.setError("Invalid Email!");
            return false;
        } else {
            email.setError(null);
            email.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validatePassword() {

        String val = password.getEditText().getText().toString().trim();
        String check_password = "^" +
                //"(?=.*[0-9])" +   // at least 1 digit
                //"(?=.*[a-z])" +   // at least 1 lower case letter
                //"(?=.*[A-Z])" +   // at least 1 upper case letter
                "(?=.*[a-zA-Z])" + // any letter
                "(?=.*[@#$%^&+=])" + // at least one special character
                "(?=\\S+$)" + // no white spaces
                ".{8,}" + //at least 8 characters
                "$";

        if (val.isEmpty()) {
            password.setError("Field cannot be empty!");
            return false;
        } else if (!val.matches(check_password)) {
            password.setError("Password should contain 8 characters!");
            return false;
        } else {
            password.setError(null);
            password.setErrorEnabled(false);
            return true;
        }
    }


    public void callNextActivity(View view) {

        if (!validateFullName() | !validateID() | !validateEmail() | !validatePassword()) {
            return;
        }

        // Get Data
        fullNameS = fullName.getEditText().getText().toString();
        doctorIdS = doctorID.getEditText().getText().toString();
        emailS = email.getEditText().getText().toString();
        passwordS = password.getEditText().getText().toString();

    }

    public void callDoc2(View view) {
        startActivity(new Intent(getApplicationContext(), DoctorSignUp2.class));
    }
}