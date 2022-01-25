package com.example.bluepill.User.Features.UserInfo;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bluepill.Address.AddressSpinnerAdapter;
import com.example.bluepill.Address.AddressSpinnerItem;
import com.example.bluepill.R;

import java.util.ArrayList;

public class AddAddress extends AppCompatActivity {
    Spinner spinner;
    private ArrayList<AddressSpinnerItem> mSpinnerList;
    private AddressSpinnerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_add_address);

        //Hooks
        spinner = findViewById(R.id.spinner);


        initList();

        mAdapter = new AddressSpinnerAdapter(this, mSpinnerList);
        spinner.setAdapter(mAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //AddressSpinnerItem clickedItem = (AddressSpinnerItem) parent.getItemAtPosition(position);
                //String clickedSpinnerName = clickedItem.getCardName();
                //Toast.makeText(AddAddress.this, clickedSpinnerName + " selected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
    private void initList() {

        mSpinnerList = new ArrayList<>();
        mSpinnerList.add(new AddressSpinnerItem("Select address type"));
        mSpinnerList.add(new AddressSpinnerItem("Cirrus"));
        mSpinnerList.add(new AddressSpinnerItem("Cirrus"));
        mSpinnerList.add(new AddressSpinnerItem("Cirrus"));
        mSpinnerList.add(new AddressSpinnerItem("Cirrus"));

    }

}