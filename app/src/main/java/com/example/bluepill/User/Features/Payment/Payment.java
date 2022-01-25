package com.example.bluepill.User.Features.Payment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bluepill.HelperClasses.Recycler.PaymentAdapter;
import com.example.bluepill.HelperClasses.Recycler.PaymentHelperClass;
import com.example.bluepill.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;

public class Payment extends AppCompatActivity {
    Button showSheet, confirm, deny;
    BottomSheetDialog bottomSheetDialog;
    BottomSheetDialog infoSheetDialog;
    RelativeLayout manageCards;
    ImageView info;

    RecyclerView paymentRecycler;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_payment);

        //Hooks
        paymentRecycler = findViewById(R.id.credit_card_recycler);
        showSheet = findViewById(R.id.show);
        manageCards = findViewById(R.id.manage);
        info = findViewById(R.id.info);

        showSheet.setOnClickListener((View v) -> {
            bottomSheetDialog = new BottomSheetDialog(Payment.this, R.style.BottomSheetTheme);

            View sheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.payment_confirmation,
                    findViewById(R.id.payment_sheet));

            bottomSheetDialog.setContentView(sheetView);
            confirm = bottomSheetDialog.findViewById(R.id.confirm);
            deny = bottomSheetDialog.findViewById(R.id.deny);
            confirm.setOnClickListener(v1 -> {
                Intent success = new Intent(getApplicationContext(), PaymentSuccess.class);
                startActivity(success);
            });
            deny.setOnClickListener(v12 -> bottomSheetDialog.dismiss());
            bottomSheetDialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            bottomSheetDialog.show();
        });

        info.setOnClickListener(v -> {
            infoSheetDialog = new BottomSheetDialog(Payment.this, R.style.BottomSheetTheme);

            View infoView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.payment_information, findViewById(R.id.payment_information_sheet));

            bottomSheetDialog.setContentView(infoView);
            bottomSheetDialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            bottomSheetDialog.show();

        });

        manageCards.setOnClickListener(v -> {
            Intent manage = new Intent(getApplicationContext(), ManageCards.class);
            startActivity(manage);
        });

        paymentRecycler();

    }

    //Recycler Views Functions
    @SuppressLint("UseCompatLoadingForDrawables")
    private void paymentRecycler() {

        paymentRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<PaymentHelperClass> paymentCategory = new ArrayList<>();

        paymentCategory.add(new PaymentHelperClass(R.drawable.mastercard_color_large, getDrawable(R.drawable.card_1), "5454", "John Doe", "04 / 21", "2132"));
        paymentCategory.add(new PaymentHelperClass(R.drawable.americanexpress_color_large, getDrawable(R.drawable.card_4), "6371", "John Doe", "06 / 24", "2132"));
        paymentCategory.add(new PaymentHelperClass(R.drawable.maestro_color_large, getDrawable(R.drawable.card_2), "1276", "John Doe", "09 / 21", "2132"));
        paymentCategory.add(new PaymentHelperClass(R.drawable.paypal_color_large, getDrawable(R.drawable.card_3), "8567", "John Doe", "01 / 21", "2132"));
        paymentCategory.add(new PaymentHelperClass(R.drawable.visa_color_large, getDrawable(R.drawable.card_4), "9843", "John Doe", "10 / 21", "2132"));
        paymentCategory.add(new PaymentHelperClass(R.drawable.cirrus_color_large, getDrawable(R.drawable.card_1), "1268", "John Doe", "12 / 21", "2132"));
        adapter = new PaymentAdapter(paymentCategory);

        paymentRecycler.setAdapter(adapter);

    }


}