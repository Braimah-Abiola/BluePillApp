package com.example.bluepill.User.Features.Payment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bluepill.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;

public class AddCard extends AppCompatActivity {

    Button addButton, confirm, deny;
    BottomSheetDialog bottomSheetDialog;
    Spinner spinner;


    private ArrayList<SpinnerItem> mSpinnerList;
    private SpinnerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_add_card);

        // Hooks
        addButton = findViewById(R.id.add_btn);
        spinner = findViewById(R.id.spinner);

        addButton.setOnClickListener(v -> {
            bottomSheetDialog = new BottomSheetDialog(AddCard.this, R.style.BottomSheetTheme);

            View sheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.add_card_confirmation,
                    findViewById(R.id.payment_sheet));

            bottomSheetDialog.setContentView(sheetView);
            confirm = bottomSheetDialog.findViewById(R.id.confirm);
            deny = bottomSheetDialog.findViewById(R.id.deny);

            confirm.setOnClickListener(v1 -> {
                Toast.makeText(AddCard.this, "Credit Card Saved", Toast.LENGTH_SHORT).show();
            });

            deny.setOnClickListener(v12 -> {
                bottomSheetDialog.dismiss();
            });
            bottomSheetDialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            bottomSheetDialog.show();
        });

        initList();

        mAdapter = new SpinnerAdapter(this, mSpinnerList);
        spinner.setAdapter(mAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                SpinnerItem clickedItem = (SpinnerItem) parent.getItemAtPosition(position);
                String clickedSpinnerName = clickedItem.getCardName();
                Toast.makeText(AddCard.this, clickedSpinnerName + " selected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void initList() {

        mSpinnerList = new ArrayList<>();
        mSpinnerList.add(new SpinnerItem("American Express", R.drawable.americanexpress_color_large));
        mSpinnerList.add(new SpinnerItem("Cirrus", R.drawable.cirrus_color_large));
        mSpinnerList.add(new SpinnerItem("Discover", R.drawable.discover_color_large));
        mSpinnerList.add(new SpinnerItem("JCB", R.drawable.jcb_color_large));
        mSpinnerList.add(new SpinnerItem("Maestro", R.drawable.maestro_color_large));
        mSpinnerList.add(new SpinnerItem("Master Card", R.drawable.mastercard_color_large));
        mSpinnerList.add(new SpinnerItem("Visa", R.drawable.visa_color_large));

    }

    public void callEncrypted(View view) {

        Intent intent = new Intent(getApplicationContext(), DataEncrypted.class);
        startActivity(intent);

    }
}