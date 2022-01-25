package com.example.bluepill.User;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.bluepill.HelperClasses.Recycler.SpecialistAdapter;
import com.example.bluepill.HelperClasses.Recycler.SpecialistHelperClass;
import com.example.bluepill.R;
import com.example.bluepill.User.Features.UserInfo.UserProfile;
import com.google.android.material.card.MaterialCardView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static android.content.ContentValues.TAG;

public class UserHomeFragment extends Fragment {

    RecyclerView specialistRecycler, specialistRecycler2;
    RecyclerView.Adapter adapter, adapter2;
    LinearLayout contentView;
    private String[] message;
    Button profileButton;
    TextView usernameText, userGoalText, greetingText;
    LottieAnimationView lottieAnimationView;

    FirebaseAuth mAuth;
    FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference mDatabase = db.getReference();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_user_home, container, false);

        // Hooks
        contentView = root.findViewById(R.id.content);
        specialistRecycler = root.findViewById(R.id.specialists_recycler);
        specialistRecycler2 = root.findViewById(R.id.specialists_recycler2);
        profileButton = root.findViewById(R.id.btn_two);
        usernameText = root.findViewById(R.id.txt_alt);
        userGoalText = root.findViewById(R.id.user_goal);
        message = root.getResources().getStringArray(R.array.home_message);
        greetingText = root.findViewById(R.id.txt_one);
        lottieAnimationView = root.findViewById(R.id.animation);

        specialistRecycler.setFocusable(false);

        // Call Methods
        specialistRecycler();
        profileButton();
        specialistRecycler2();

        // Random Message
        welcomeMessage();

        // Greeting
        greetUser();

        mAuth = FirebaseAuth.getInstance();

        return root;
    }

    private void greetUser() {

        Calendar c = Calendar.getInstance();
        int timeOfDay;
        timeOfDay = c.get(Calendar.HOUR_OF_DAY);

        if (timeOfDay < 12) {
            greetingText.setText(R.string.morning);
            lottieAnimationView.setAnimation(R.raw.day);
        } else if (timeOfDay < 16) {
            greetingText.setText(R.string.afternoon);
            lottieAnimationView.setAnimation(R.raw.day);
        } else if (timeOfDay < 21) {
            lottieAnimationView.setAnimation(R.raw.day_and_night);
            greetingText.setText(R.string.evening);
        } else {
            lottieAnimationView.setAnimation(R.raw.night);
            greetingText.setText(R.string.night);
        }

    }

    private void welcomeMessage() {

        int randomIndex = new Random().nextInt(message.length);
        String randomName = message[randomIndex];
        userGoalText.setText(randomName);

    }


    private void specialistRecycler2() {

        specialistRecycler2.setHasFixedSize(true);
        specialistRecycler2.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        ArrayList<SpecialistHelperClass> viewSpecialist2 = new ArrayList<>();

        viewSpecialist2.add(new SpecialistHelperClass(R.drawable.dummy_doctor, "Dentist", "John Doe"));
        viewSpecialist2.add(new SpecialistHelperClass(R.drawable.dummy_doctor, "Physician", "John Doe"));
        viewSpecialist2.add(new SpecialistHelperClass(R.drawable.dummy_doctor, "Heart Surgeon", "John Doe"));
        viewSpecialist2.add(new SpecialistHelperClass(R.drawable.dummy_doctor, "Dentist", "John Doe"));
        viewSpecialist2.add(new SpecialistHelperClass(R.drawable.dummy_doctor, "Physician", "John Doe"));


        adapter2 = new SpecialistAdapter(viewSpecialist2);
        specialistRecycler2.setAdapter(adapter2);

    }

    // On Click Profile Button
    private void profileButton() {

        profileButton.setOnClickListener(v -> {
            startActivity(new Intent(getActivity(), UserProfile.class));
        });

    }

    // Recycler View
    private void specialistRecycler() {

        specialistRecycler.setHasFixedSize(true);
        specialistRecycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        ArrayList<SpecialistHelperClass> viewSpecialist = new ArrayList<>();

        viewSpecialist.add(new SpecialistHelperClass(R.drawable.dummy_doctor, "Dentist", "John Doe"));
        viewSpecialist.add(new SpecialistHelperClass(R.drawable.dummy_doctor, "Physician", "John Doe"));
        viewSpecialist.add(new SpecialistHelperClass(R.drawable.dummy_doctor, "Heart Surgeon", "John Doe"));
        viewSpecialist.add(new SpecialistHelperClass(R.drawable.dummy_doctor, "Dentist", "John Doe"));
        viewSpecialist.add(new SpecialistHelperClass(R.drawable.dummy_doctor, "Physician", "John Doe"));


        adapter = new SpecialistAdapter(viewSpecialist);
        specialistRecycler.setAdapter(adapter);
    }

}