package com.example.bluepill.Common.OnBoarding.Introductory;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.fragment.app.Fragment;

import com.example.bluepill.Common.UserLogInSignUp.UserStartUpScreen;
import com.example.bluepill.R;

public class OnBoardingFragment3 extends Fragment {

    Intent intent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_on_boarding3, container, false);

        intent = new Intent(getActivity(), UserStartUpScreen.class);
        final TextView button = root.findViewById(R.id.done);

        button.setOnClickListener(v -> startActivity(intent));
            return root;
    }

}
