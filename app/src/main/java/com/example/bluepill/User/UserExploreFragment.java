package com.example.bluepill.User;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bluepill.HelperClasses.Recycler.ExploreVideoAdapter;
import com.example.bluepill.HelperClasses.Recycler.ExploreVideoHelperClass;
import com.example.bluepill.HelperClasses.Recycler.SuggestedAdapter;
import com.example.bluepill.HelperClasses.Recycler.SuggestedHelperClass;
import com.example.bluepill.HelperClasses.Recycler.UpcomingReminderAdapter;
import com.example.bluepill.HelperClasses.Recycler.UpcomingReminderHelperClass;
import com.example.bluepill.R;


import java.util.ArrayList;

public class UserExploreFragment extends Fragment {

    RecyclerView upcomingReminder, videoRecycler, suggestedRecycler;
    RecyclerView.Adapter adapter, adapter2, adapter3;
    FrameLayout frameLayout1;
    LinearLayout loadingLayout;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_user_explore, container, false);

        // Hooks
        loadingLayout = root.findViewById(R.id.loading);
        upcomingReminder = root.findViewById(R.id.upcoming_reminders);
        videoRecycler = root.findViewById(R.id.explore_video);
        frameLayout1 = root.findViewById(R.id.ads);
        suggestedRecycler = root.findViewById(R.id.suggested_recycler);

        // Recycler View Properties
        upcomingReminder.setFocusable(false);
        upcomingReminder.setNestedScrollingEnabled(false);
        videoRecycler.setFocusable(false);

        // Call Methods
        callVideoRecycler();
        upcomingReminderRecycler();
        callSuggested();
        waitFiveSecs();


        return root;
    }

    private void waitFiveSecs() {

        Handler handler = new Handler();
        handler.postDelayed(() -> loadingLayout.setVisibility(View.GONE), 3000);   //5 seconds

    }

    private void callSuggested() {

        suggestedRecycler.setHasFixedSize(true);
        suggestedRecycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        ArrayList<SuggestedHelperClass> viewSuggested = new ArrayList<>();

        viewSuggested.add(new SuggestedHelperClass(R.drawable.dummy_doctor, "Duke Opoku", "Dentist"));
        viewSuggested.add(new SuggestedHelperClass(R.drawable.dummy_doctor, "Albert Amoako", "Dermatologist"));
        viewSuggested.add(new SuggestedHelperClass(R.drawable.dummy_doctor, "Duke Opoku", "Dentist"));
        adapter3 = new SuggestedAdapter(viewSuggested);
        suggestedRecycler.setAdapter(adapter3);

    }

    private void callVideoRecycler() {

        videoRecycler.setHasFixedSize(true);
        videoRecycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        ArrayList<ExploreVideoHelperClass> viewVideo = new ArrayList<>();

        viewVideo.add(new ExploreVideoHelperClass("How to loose 20lbs in 10 weeks"));
        viewVideo.add(new ExploreVideoHelperClass("Best foods for the brain"));

        adapter2 = new ExploreVideoAdapter(viewVideo);
        videoRecycler.setAdapter(adapter2);

    }

    private void upcomingReminderRecycler() {

        upcomingReminder.setHasFixedSize(true);
        upcomingReminder.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        ArrayList<UpcomingReminderHelperClass> viewUpcoming = new ArrayList<>();

        viewUpcoming.add(new UpcomingReminderHelperClass("Take Paracetamol", "Medicine prescribed to help reduce my pain", "MEDICINE", "Time: 8:00"));
        viewUpcoming.add(new UpcomingReminderHelperClass("Take Water", "Take a glass of water", "MISCELLANEOUS", "Time: 12:00"));


        adapter = new UpcomingReminderAdapter(viewUpcoming);
        upcomingReminder.setAdapter(adapter);

    }


}