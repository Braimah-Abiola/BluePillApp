package com.example.bluepill.Common.UserLogInSignUp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.view.WindowManager;
import android.widget.ProgressBar;

import com.example.bluepill.ChatKit.Chat;
import com.example.bluepill.Common.ForgotPassword.User.ForgotPassword;
import com.example.bluepill.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class UserLogin extends AppCompatActivity {

    // Get Data Variables
    TextInputLayout username, password;
    ProgressBar progressBar;

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

    public void goBack(View view) {

        startActivity(new Intent(getApplicationContext(), UserStartUpScreen.class));

    }

    public void callChat (View view) {

        startActivity(new Intent(getApplicationContext(), Chat.class));

    }

    public void callForgotPassword(View view) {

        startActivity(new Intent(getApplicationContext(), ForgotPassword.class));

    }


    public void letTheUserLogIn(View view) {

        if (!isConnected(this)) {

            showCustomDialog();

        }

        if (!validateUsername() | !validatePassword()) {
        }

    }

    private void showCustomDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(UserLogin.this);
        builder.setMessage("Please connect to the internet to proceed further")
                .setCancelable(true)
                .setPositiveButton("Connect", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(getApplicationContext(), UserStartUpScreen.class));
                        finish();
                    }
                });

    }

    private boolean isConnected(UserLogin userLogin) {

        ConnectivityManager connectivityManager = (ConnectivityManager) userLogin.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo wifiConn = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo mobileConn = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

        return (wifiConn != null && wifiConn.isConnected()) || (mobileConn != null && mobileConn.isConnected());

    }


    // Validate Username and Password
    private boolean validateUsername() {
        String val = username.getEditText().getText().toString().trim();
        String check_spaces = "\\A\\w{1,20}\\z";

        if(val.isEmpty()){

            username.setError("Field cannot be empty!");
            return false;
        } else if (val.length()>10){
            username.setError("Username is too long!");
            return false;
        } else if (!val.matches(check_spaces)){
            username.setError("No spaces are allowed!");
            return false;
        }
        else{
            username.setError(null);
            username.setErrorEnabled(false);
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
        }
        else {
            password.setError(null);
            password.setErrorEnabled(false);
            return true;
        }
    }

}
