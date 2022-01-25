package com.example.bluepill.User.Features.TeleMed;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.example.bluepill.R;
import com.example.bluepill.User.Features.TeleMed.AddDoctor;

public class UserTelemedFragment extends Fragment {

    ImageView addIcon, searchIcon;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_user_telemed, container, false);

        // Hooks
        addIcon = root.findViewById(R.id.add);
        searchIcon = root.findViewById(R.id.search);

        addIcon.setOnClickListener(v -> startActivity(new Intent(getActivity(), AddDoctor.class)));
        searchIcon.setOnClickListener(v -> startActivity(new Intent(getActivity(), SearchTeleMed.class)));

        return root;
    }

}
