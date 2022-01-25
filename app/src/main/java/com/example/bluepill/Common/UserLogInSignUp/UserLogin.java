package com.example.bluepill.Common.UserLogInSignUp;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bluepill.Common.ForgotPassword.User.ForgotPassword;
import com.example.bluepill.R;
import com.example.bluepill.User.UserHomeFragment;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class UserLogin extends AppCompatActivity {
    Button showSheet;
    RelativeLayout progressBar;
    Button loginButton, cancelBtn, continueBtn;
    Dialog dialog, dialog2;


    // Get Data Variables
    TextInputLayout email, password;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_login);

        mAuth = FirebaseAuth.getInstance();

        // Get Data Hooks
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

        showSheet = findViewById(R.id.show);
        loginButton = findViewById(R.id.login_btn);
        progressBar = findViewById(R.id.progress_bar);

    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser mUser = mAuth.getCurrentUser();
        if(mUser != null){
            Intent intent = new Intent(getApplicationContext(), SigningIn.class);
            startActivity(intent);
        }
    }

    public void callForgotPassword(View view) {
        startActivity(new Intent(getApplicationContext(), ForgotPassword.class));
        finish();
    }

    // Validate Username and Password
    private boolean validateEmail() {
        String val = email.getEditText().getText().toString().trim();
        String check_email = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (val.isEmpty()) {
            email.setError(getString(R.string.error_empty));
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
        String val2 = password.getEditText().getText().toString().trim();

        if (val2.isEmpty()) {
            password.setError("Please enter a password associated with this account");
            return false;
        } else {
            password.setError(null);
            password.setErrorEnabled(false);
            return true;
        }
    }

    public void letUserLogin(View view) {

        if (!validateEmail() || !validatePassword()) {
            return;
        }

        if (validatePassword() && validateEmail() && !isConnected(this)) {
            showCustomDialog();
        } else {
            progressBar.setVisibility(View.VISIBLE);

            String mail = email.getEditText().getText().toString();
            String pass = password.getEditText().getText().toString();

            // Authenticate User
            mAuth.signInWithEmailAndPassword(mail, pass).addOnSuccessListener(authResult -> {
                startActivity(new Intent(getApplicationContext(), SigningIn.class));
                finish();
            }).addOnFailureListener(e -> {
                showCustomDialog2();
            });
        }
    }

    private void showCustomDialog2() {
        dialog2 = new Dialog(UserLogin.this, R.style.BottomSheetTheme);

        View dialogView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.no_internet_dialog,
                findViewById(R.id.continue_popup));

        dialog2.setContentView(dialogView);
        dialog2.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        dialog2.show();

        //Hooks
        continueBtn = dialogView.findViewById(R.id.positive);
        cancelBtn = dialogView.findViewById(R.id.negative);


        continueBtn.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), UserLogin.class)));
        cancelBtn.setOnClickListener(v -> dialog2.dismiss());
    }

    public void showCustomDialog() {

        dialog = new Dialog(UserLogin.this, R.style.BottomSheetTheme);

        View dialogView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.no_internet_dialog,
                findViewById(R.id.continue_popup));

        dialog.setContentView(dialogView);
        dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        dialog.show();

        //Hooks
        continueBtn = dialogView.findViewById(R.id.positive);
        cancelBtn = dialogView.findViewById(R.id.negative);


        continueBtn.setOnClickListener(v -> startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS)));
        cancelBtn.setOnClickListener(v -> {
            dialog.dismiss();
        });

    }

    /* Check Internet Connection */
    private boolean isConnected(UserLogin userLogin) {

        ConnectivityManager connectivityManager = (ConnectivityManager) userLogin.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo wifiConn = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo mobileConn = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

        if ((wifiConn != null && wifiConn.isConnected()) || (mobileConn != null && mobileConn.isConnected())) {
            return true;
        } else {
            return false;
        }

    }

    public void signUp(View view) {
        startActivity(new Intent(getApplicationContext(), UserSignUp1.class));
        finish();
    }

}
