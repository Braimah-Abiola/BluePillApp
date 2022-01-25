package com.example.bluepill.User.Features.History;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bluepill.R;

public class HistoryActivity extends AppCompatActivity {
    RelativeLayout transactionHistory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_history);

        //Hooks
        transactionHistory = findViewById(R.id.transaction_history_layout);

        clickListeners();

    }

    private void clickListeners() {

        transactionHistory.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), TransactionHistory.class));
        });

    }
}