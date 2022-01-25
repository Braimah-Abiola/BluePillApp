package com.example.bluepill.User.Features.Articles;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bluepill.R;

public class ArticleBookmarks extends AppCompatActivity {

    ImageView backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_article_bookmarks);

        // Hooks
        backBtn = findViewById(R.id.back_button);

        backBtn.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), Articles.class)));

    }
}