package com.example.bluepill.ChatKit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;

import com.example.bluepill.R;
import com.stfalcon.chatkit.messages.MessageInput;

public class Chat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_chat);

        initViews();
    }

    private void initViews() {
        MessageInput inputView = findViewById(R.id.input);
        inputView.setInputListener(input -> {
            // Validate and send message
            sendMessage(input.toString());
            return true;
        });
    }

    private void sendMessage(String message) {


    }
}