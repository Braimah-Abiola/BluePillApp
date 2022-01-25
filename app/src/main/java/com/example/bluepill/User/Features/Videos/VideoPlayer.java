package com.example.bluepill.User.Features.Videos;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bluepill.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class VideoPlayer extends AppCompatActivity {

    BottomSheetDialog sharebottomSheetDialog;
    ImageView backButton, shareButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_video_player);

        // Hooks
        shareButton = findViewById(R.id.share_video);
        backButton = findViewById(R.id.back);

        // Click Listeners
        backButton.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), VideoActivity.class)));
        shareButton.setOnClickListener(v -> {
            sharebottomSheetDialog = new BottomSheetDialog(VideoPlayer.this, R.style.BottomSheetTheme);
            View sheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.sharebuttomsheet,
                    findViewById(R.id.share_sheet));

            sharebottomSheetDialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            sharebottomSheetDialog.show();

            sharebottomSheetDialog.setContentView(sheetView);
        });

    }

}