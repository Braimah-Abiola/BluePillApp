package com.example.bluepill.User.Features.UserInfo;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bluepill.R;

public class ManageAddress extends AppCompatActivity {
    RelativeLayout addAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_manage_address);

        //Hooks
        addAddress = findViewById(R.id.add_address);

        addAddress.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), AddAddress.class));
        });

    }
}