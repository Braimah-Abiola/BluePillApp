package com.example.bluepill.User.Features.TeleMed;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.bluepill.R;
import com.example.bluepill.User.Features.UserInfo.UserProfile;
import com.example.bluepill.User.UserDashboardActivity;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class AddDoctor extends AppCompatActivity {

    ImageView moreIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_add_doctor);

        // Hooks
        moreIcon = findViewById(R.id.more);

        moreIcon.setOnClickListener(v -> showPopup());

    }

    private void showPopup() {

        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(AddDoctor.this, R.style.BottomSheetTheme);

        View sheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.telemed_more_bottom_sheet,
                findViewById(R.id.more_sheet));

        bottomSheetDialog.setContentView(sheetView);

        bottomSheetDialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        bottomSheetDialog.show();

        // Hooks

    }

}