package com.example.bluepill.Common.UserLogInSignUp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bluepill.Common.ForgotPassword.User.ForgotPassword;
import com.example.bluepill.R;
import com.google.android.material.textfield.TextInputLayout;

public class UserLogin extends AppCompatActivity {

    // Get Data Variables
    TextInputLayout username, password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_login);

        // Get Data Hooks
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

    }

    public void callUserSignUp(View view) {

        startActivity(new Intent(getApplicationContext(), UserSignUp1.class));


    }

    public void callUserStartup(View view) {

        startActivity(new Intent(getApplicationContext(), UserStartUpScreen.class));

    }

    public void callForgotPassword(View view) {

        startActivity(new Intent(getApplicationContext(), ForgotPassword.class));

    }


    // Validate Username and Password
    private boolean validateUsername() {
        String val = username.getEditText().getText().toString().trim();
        String check_spaces = getString(R.string.spaces);

        if (val.isEmpty()) {

            username.setError(getString(R.string.error_empty));
            return false;
        } else if (val.length() > 10) {
            username.setError(getString(R.string.error_username_long));
            return false;
        } else if (!val.matches(check_spaces)) {
            username.setError(getString(R.string.no_spaces));
            return false;
        } else {
            username.setError(null);
            username.setErrorEnabled(false);
            return true;
        }
    }


    private boolean validatePassword() {

        String val = password.getEditText().getText().toString().trim();
        String check_password = getString(R.string.power_sign) +
                //"(?=.*[0-9])" +   // at least 1 digit
                //"(?=.*[a-z])" +   // at least 1 lower case letter
                //"(?=.*[A-Z])" +   // at least 1 upper case letter
                getString(R.string.any_letter) + // any letter
                getString(R.string.one_special_char) + // at least one special character
                getString(R.string.no_white_spaces) + // no white spaces
                getString(R.string.eight_char) + //at least 8 characters
                getString(R.string.dollar_sign);

        if (val.isEmpty()) {
            password.setError(getString(R.string.error_empty));
            return false;
        } else if (!val.matches(check_password)) {
            password.setError(getString(R.string.error_password));
            return false;
        } else {
            password.setError(null);
            password.setErrorEnabled(false);
            return true;
        }
    }

}
