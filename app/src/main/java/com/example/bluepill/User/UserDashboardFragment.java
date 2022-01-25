package com.example.bluepill.User;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.bluepill.R;
import com.example.bluepill.User.Features.Appointments.Appointments;
import com.example.bluepill.User.Features.Forums.Forums;
import com.example.bluepill.User.Features.History.HistoryActivity;
import com.example.bluepill.User.Features.Payment.ManageCards;
import com.example.bluepill.User.Features.Records.MedicalRecords;
import com.example.bluepill.User.Features.UserInfo.ManageAddress;

public class UserDashboardFragment extends Fragment {
    CardView cardView_1, cardView_2, cardView_4, cardView_3, cardView_5, cardView_6;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_user_dashboard, container, false);

        // Hooks
        cardView_1 = root.findViewById(R.id.card_one);
        cardView_2 = root.findViewById(R.id.card_two);
        cardView_3 = root.findViewById(R.id.card_three);
        cardView_4 = root.findViewById(R.id.card_four);
        cardView_5 = root.findViewById(R.id.card_five);
        cardView_6 = root.findViewById(R.id.card_six);

        cardClickListener();

        return root;
    }

    private void cardClickListener() {

        cardView_1.setOnClickListener(v -> {
            startActivity(new Intent(getActivity(), Appointments.class));
        });

        cardView_2.setOnClickListener(v -> {
            startActivity(new Intent(getActivity(), MedicalRecords.class));
        });

        cardView_3.setOnClickListener(v -> {
            startActivity(new Intent(getActivity(), Forums.class));
        });

        cardView_4.setOnClickListener(v -> {
            startActivity(new Intent(getActivity(), ManageCards.class));
        });

        cardView_5.setOnClickListener(v -> {
            startActivity(new Intent(getActivity(), ManageAddress.class));
        });

        cardView_6.setOnClickListener(v -> {
            startActivity(new Intent(getActivity(), HistoryActivity.class));
        });

    }
}