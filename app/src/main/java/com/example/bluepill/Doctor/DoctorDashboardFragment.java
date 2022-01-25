package com.example.bluepill.Doctor;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.bluepill.R;

public class DoctorDashboardFragment extends Fragment {

    CardView myWallet;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_doctor_dashboard, container, false);

        // Hooks
        myWallet = root.findViewById(R.id.card_four);

        // On Click Listeners
        myWallet.setOnClickListener(v -> startActivity(new Intent(getActivity(), DoctorWallet.class)));


        return root;
    }
}