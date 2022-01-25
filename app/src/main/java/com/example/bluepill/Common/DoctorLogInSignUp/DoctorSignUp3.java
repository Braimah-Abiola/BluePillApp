package com.example.bluepill.Common.DoctorLogInSignUp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.bluepill.R;

import androidx.appcompat.app.AppCompatActivity;

public class DoctorSignUp3 extends AppCompatActivity {

    public static String genderS;

    Button next;
    RadioGroup radioGroup;
    RadioButton selectedGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().setStatusBarColor(getColor(R.color.doctor_pink));

        setContentView(R.layout.activity_doctor_sign_up3);

        //Hooks
        next = findViewById(R.id.next_btn);
        radioGroup = findViewById(R.id.radio_group);

    }

    public void callDoc4 (View view){

        if (!validateGender()){
            return;
        }

        selectedGender = findViewById(radioGroup.getCheckedRadioButtonId());
        genderS = selectedGender.getText().toString();

        startActivity(new Intent(getApplicationContext(), DoctorSignUp4.class));
        finish();
    }

    private boolean validateGender() {
        if (radioGroup.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "Please Select Gender", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }

}