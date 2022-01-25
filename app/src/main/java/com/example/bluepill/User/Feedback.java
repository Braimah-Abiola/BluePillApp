package com.example.bluepill.User;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bluepill.R;
import com.google.android.material.textfield.TextInputLayout;

public class Feedback extends AppCompatActivity {

    TextInputLayout userFeedback, userEmail;
    String feedbackText, emailText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_feedback);

        // Hooks
        userFeedback = findViewById(R.id.user_feedback);
        userEmail = findViewById(R.id.user_email);

    }

    public void callSendFeedback(View view) {

        if (!validateEmail() | !validateFeedback()){
            return;
        }

        // Get Data
        feedbackText = userFeedback.getEditText().getText().toString();
        emailText = userEmail.getEditText().getText().toString();
        String recipient_address;
        recipient_address = "braimahabiola.official@gmail.com";

        // Send Feedback
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/html");
        intent.putExtra(Intent.EXTRA_SUBJECT, "BluePill User Feedback");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{recipient_address});
        intent.putExtra(Intent.EXTRA_TEXT, feedbackText);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        startActivity(intent);

    }

    private boolean validateEmail() {

        String val = userEmail.getEditText().getText().toString().trim();
        String check_email = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (val.isEmpty()) {
            userEmail.setError("Field cannot be empty!");
            return false;
        } else if (!val.matches(check_email)) {
            userEmail.setError("Invalid Email!");
            return false;
        } else {
            userEmail.setError(null);
            userEmail.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validateFeedback(){

        String val2 = userFeedback.getEditText().getText().toString().trim();

        if (val2.isEmpty()){
            userFeedback.setError("Please type in feedback!");
            return false;
        } else {
            userFeedback.setError(null);
            userFeedback.setErrorEnabled(false);
            return true;
        }

    }

}