package com.example.bluepill.User;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bluepill.HelperClasses.DashboardAdapter.SpecialistAdapter;
import com.example.bluepill.HelperClasses.DashboardAdapter.SpecialistHelperClass;
import com.example.bluepill.R;

import java.util.ArrayList;

public class UserHomeFragment extends Fragment {

    RecyclerView specialistRecycler;
    RecyclerView.Adapter adapter;
    LinearLayout contentView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_user_home, container, false);


        contentView = root.findViewById(R.id.content);
        specialistRecycler = root.findViewById(R.id.specialists_recycler);
        specialistRecycler();
        return root;

    }

    private void specialistRecycler() {

        specialistRecycler.setHasFixedSize(true);
      //  specialistRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<SpecialistHelperClass> viewSpecialist = new ArrayList<>();

        viewSpecialist.add(new SpecialistHelperClass(R.drawable.card_1, "Macdonald's 1", "Hey there my name is abiola and I am currently developing an app called blue pill. Stay tuned for more."));
        viewSpecialist.add(new SpecialistHelperClass(R.drawable.card_2, "Macdonald's 2", "Hey there my name is abiola and I am currently developing an app called blue pill. Stay tuned for more."));
        viewSpecialist.add(new SpecialistHelperClass(R.drawable.card_3, "Macdonald's 3", "Hey there my name is abiola and I am currently developing an app called blue pill. Stay tuned for more."));
        viewSpecialist.add(new SpecialistHelperClass(R.drawable.card_4, "Macdonald's 4", "Hey there my name is abiola and I am currently developing an app called blue pill. Stay tuned for more."));
        viewSpecialist.add(new SpecialistHelperClass(R.drawable.card_1, "Macdonald's 5", "Hey there my name is abiola and I am currently developing an app called blue pill. Stay tuned for more."));


        adapter = new SpecialistAdapter(viewSpecialist);
        specialistRecycler.setAdapter(adapter);

    }

}