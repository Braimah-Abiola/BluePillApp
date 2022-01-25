package com.example.bluepill.User.Features.Articles;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bluepill.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class ArticleDetail extends AppCompatActivity {
    Button showSheet;
    BottomSheetDialog bottomSheetDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_article_detail);

        //Hooks
        showSheet = findViewById(R.id.comment_button);

        showSheet.setOnClickListener(v -> {
            bottomSheetDialog = new BottomSheetDialog(ArticleDetail.this, R.style.BottomSheetTheme);

            View sheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.comment_bottom_sheet,
                    findViewById(R.id.bottom_sheet));

            bottomSheetDialog.setContentView(sheetView);
            bottomSheetDialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            bottomSheetDialog.show();
        });

    }
}