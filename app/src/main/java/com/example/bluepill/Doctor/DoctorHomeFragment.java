package com.example.bluepill.Doctor;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bluepill.HelperClasses.Recycler.RecentClientsAdapter;
import com.example.bluepill.HelperClasses.Recycler.RecentClientsHelperClass;
import com.example.bluepill.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

public class DoctorHomeFragment extends Fragment {

    Button viewProfile;
    TextView welcomeMessage, greetingText;
    RecyclerView.Adapter summary;
    RecyclerView recentClients;
    ImageView menu;
    private String[] message;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_doctor_home, container, false);

        // Hooks
        viewProfile = root.findViewById(R.id.btn_two);
        recentClients = root.findViewById(R.id.recent_recycler_view);
        welcomeMessage = root.findViewById(R.id.user_goal);
        message = root.getResources().getStringArray(R.array.doc_home_message);
        greetingText = root.findViewById(R.id.txt_one);
        menu = root.findViewById(R.id.menu_icon);

        // Click Listeners
        viewProfile.setOnClickListener(v -> startActivity(new Intent(getActivity(), DoctorProfileActivity.class)));

        // Methods
        recentClientsRecycler();
        showGreeting();

        // Random Message
        displayMessage();


        return root;
    }

    private void showGreeting() {

        Calendar c = Calendar.getInstance();
        int timeOfDay;
        timeOfDay = c.get(Calendar.HOUR_OF_DAY);

        if (timeOfDay < 12) {
            greetingText.setText(R.string.morning);
            //lottieAnimationView.setAnimation(R.raw.day);
        } else if (timeOfDay < 16) {
            greetingText.setText(R.string.afternoon);
           //lottieAnimationView.setAnimation(R.raw.day);
        } else if (timeOfDay < 21) {
            //lottieAnimationView.setAnimation(R.raw.day_and_night);
            greetingText.setText(R.string.evening);
        } else {
            //lottieAnimationView.setAnimation(R.raw.night);
            greetingText.setText(R.string.night);
        }

    }

    private void displayMessage() {
        int randomIndex = new Random().nextInt(message.length);
        String randomName = message[randomIndex];
        welcomeMessage.setText(randomName);
    }

    private void recentClientsRecycler() {

        recentClients.setHasFixedSize(true);
        recentClients.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        ArrayList<RecentClientsHelperClass> viewClients = new ArrayList<>();

        viewClients.add(new RecentClientsHelperClass(R.drawable.dummy_doctor, "Duke Opoku", "3423", "21/04/2021", "Lymphoma"));
        viewClients.add(new RecentClientsHelperClass(R.drawable.dummy_doctor, "Albert Amaoako", "94223", "01/06/2021", "Blood Pressure"));
        viewClients.add(new RecentClientsHelperClass(R.drawable.dummy_doctor, "Abiola Braimah", "87423", "11/04/2012", "Hair Loss"));

        summary = new RecentClientsAdapter(viewClients);
        recentClients.setAdapter(summary);

    }
}