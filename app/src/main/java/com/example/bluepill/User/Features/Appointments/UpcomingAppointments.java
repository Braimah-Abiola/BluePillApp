package com.example.bluepill.User.Features.Appointments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.bluepill.R;

public class UpcomingAppointments extends Fragment {
    Button bookButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_upcoming_appointments, container, false);

        // Hooks
        bookButton = root.findViewById(R.id.book);

        // On Button Click
        bookButton();

        return root;
    }

    private void bookButton() {

        bookButton.setOnClickListener(v -> {
            startActivity(new Intent(getActivity(), BookAppointment.class));
        });

    }
}