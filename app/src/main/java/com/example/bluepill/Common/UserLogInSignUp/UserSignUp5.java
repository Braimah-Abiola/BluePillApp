package com.example.bluepill.Common.UserLogInSignUp;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.chaos.view.PinView;
import com.example.bluepill.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class UserSignUp5 extends AppCompatActivity {

    public Dialog dialog, dialog2;
    public String fullNameS, usernameS, emailS, ageS, genderS, fullPhoneNumberS;
    public int age;

    // Firebase Realtime Database
    FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference root = db.getReference().child("Users");
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    String userId;

    PinView pinView;
    Button verifyBtn, continueBtn, cancelBtn, retryBtn, cancelBtn2;
    String codeBySystem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_sign_up5);

        // Hooks
        pinView = findViewById(R.id.pin_view);
        verifyBtn = findViewById(R.id.verify_button);

        // Data from Previous Activities
        fullNameS = UserSignUp1.fullNameS;
        usernameS = UserSignUp1.usernameS;
        emailS = UserSignUp1.emailS;
        age = UserSignUp2.age;
        genderS = UserSignUp3.genderS;
        fullPhoneNumberS = UserSignUp4.fullPhoneNumberS;

        // Convert age to String
        ageS = String.valueOf(age);

        sendVerificationCode(fullPhoneNumberS);

    }

    private void sendVerificationCode(String phoneNumber) {

        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(mAuth)
                        .setPhoneNumber(phoneNumber)       // Phone number to verify
                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                        .setActivity(UserSignUp5.this) // Activity (for callback binding)
                        .setCallbacks(mCallbacks)          // OnVerificationStateChangedCallbacks
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);

    }

    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

        @Override
        public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            codeBySystem = s;
        }

        @Override
        public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
            String code = phoneAuthCredential.getSmsCode();
            if (code != null) {
                pinView.setText(code);
                verifyCode(code);
            }
        }

        @Override
        public void onVerificationFailed(@NonNull FirebaseException e) {
            Toast.makeText(UserSignUp5.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    };

    private void verifyCode(String code) {

        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(codeBySystem, code);
        signInWithPhoneAuthCredential(credential);

    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Write Data to Firebase
                            HashMap<String, String> userMap = new HashMap<>();

                            userMap.put("Full Name", fullNameS);
                            userMap.put("Username", usernameS);
                            userMap.put("Email", emailS);
                            userMap.put("Age", ageS);
                            userMap.put("Gender", genderS);

                            userId = root.push().getKey();

                            assert userId != null;
                            root.child(userId).setValue(userMap);

                            // Display Success Dialog
                            continueToSignInDialog();
                        } else {
                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                errorDialog();
                            }
                        }
                    }
                });
    }

    // Custom Failed Dialog
    private void errorDialog() {

        dialog2 = new Dialog(UserSignUp5.this, R.style.BottomSheetTheme);

        View dialogView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.sign_up_failed_popup,
                findViewById(R.id.signup_failed));

        dialog2.setContentView(dialogView);
        dialog2.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        dialog2.show();

        //Hooks
        retryBtn = dialogView.findViewById(R.id.positive);
        cancelBtn2 = dialogView.findViewById(R.id.negative);

        retryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), UserSignUp4.class));
            }
        });
        cancelBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), UserStartUpScreen.class));
            }
        });
    }

    // Custom Success Dialog
    private void continueToSignInDialog() {

        dialog = new Dialog(UserSignUp5.this, R.style.BottomSheetTheme);

        View dialogView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.continue_to_sign_in_popup,
                findViewById(R.id.continue_popup));

        dialog.setContentView(dialogView);
        dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        dialog.show();

        //Hooks
        continueBtn = dialogView.findViewById(R.id.positive);
        cancelBtn = dialogView.findViewById(R.id.negative);


        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), UserLogin.class));
            }
        });
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), UserStartUpScreen.class));
            }
        });
    }

    public void callNextActivity(View view) {

        String code = pinView.getText().toString();
        if (!code.isEmpty()) {
            verifyCode(code);
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (dialog != null && dialog.isShowing()) {
            dialog.cancel();
        }
        if (dialog2 != null && dialog2.isShowing()) {
            dialog2.cancel();
        }
    }

}