package com.example.bluepill.User.Features.Appointments;

import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bluepill.HelperClasses.Recycler.SlotAdapter;
import com.example.bluepill.HelperClasses.Recycler.SlotHelperClass;
import com.example.bluepill.R;

import java.util.ArrayList;

public class BookingScreen extends AppCompatActivity {
    RecyclerView slotRecycler;
    RecyclerView.Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_booking_screen);

        //Hooks
        slotRecycler = findViewById(R.id.calender);

        slotRecycler();

    }

    private void slotRecycler() {

        slotRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<SlotHelperClass> slotDate = new ArrayList<>();

        slotDate.add(new SlotHelperClass("Mon\n01"));
        slotDate.add(new SlotHelperClass("Tues\n02"));
        slotDate.add(new SlotHelperClass("Wed\n03"));
        slotDate.add(new SlotHelperClass("Thurs\n04"));
        slotDate.add(new SlotHelperClass("Fri\n05"));
        slotDate.add(new SlotHelperClass("Sat\n06"));
        slotDate.add(new SlotHelperClass("Sun\n07"));

        adapter = new SlotAdapter(slotDate);
        slotRecycler.setAdapter(adapter);

    }

}