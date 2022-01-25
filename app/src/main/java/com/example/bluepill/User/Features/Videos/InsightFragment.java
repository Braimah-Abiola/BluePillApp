package com.example.bluepill.User.Features.Videos;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.bluepill.HelperClasses.Recycler.VideoAdapter;
import com.example.bluepill.HelperClasses.Recycler.VideoHelperClass;
import com.example.bluepill.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class InsightFragment extends Fragment {

    Button playButton;
    private VideoAdapter adapter;
    private static ViewPager mPager;
    private static int currentPage = 0;
    private static final Integer[] img = {R.color.dark_blue_button, R.color.dark_green_button, R.color.signature_blue_darker};
    private final ArrayList<Integer> ImgArray = new ArrayList<>();
    RecyclerView recommendedRecycler, recommendedRecycler2, recommendedRecycler3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_insight, container, false);

        // Hooks
        playButton = root.findViewById(R.id.play);

        // On Click
        playButton.setOnClickListener(v -> startActivity(new Intent(getActivity(), VideoPlayer.class)));

        Collections.addAll(ImgArray, img);

        mPager = root.findViewById(R.id.pager);
        mPager.setAdapter(new MyAdapter(getContext(), ImgArray));
        CircleIndicator indicator = root.findViewById(R.id.indicator);
        indicator.setViewPager(mPager);

        final Handler handler = new Handler();
        final Runnable Update = () -> {
            if (currentPage == img.length) {
                currentPage = 0;
            }
            mPager.setCurrentItem(currentPage++, true);
        };
        //Auto Start
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 2500, 5500);

        // Hooks
        recommendedRecycler = root.findViewById(R.id.recommended_recycler);
        recommendedRecycler2 = root.findViewById(R.id.recommended_recycler2);
        recommendedRecycler3 = root.findViewById(R.id.recommended_recycler3);

        recommendedRecycler();
        recommendedRecycler2();
        recommendedRecycler3();

        return root;
    }

    private void recommendedRecycler() {
        recommendedRecycler.setHasFixedSize(true);
        recommendedRecycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        recommendedRecycler.setOnClickListener(v -> startActivity(new Intent(getActivity(), VideoDetailPage.class)));

        ArrayList<VideoHelperClass> viewVideo = new ArrayList<>();

        viewVideo.add(new VideoHelperClass(R.drawable.card_1, "Losing My Virginity - Insights from the book by Richard Branson"));
        viewVideo.add(new VideoHelperClass(R.drawable.card_2, "Losing My Virginity - Insights from the book by Richard Branson"));
        viewVideo.add(new VideoHelperClass(R.drawable.card_3, "Losing My Virginity - Insights from the book by Richard Branson"));
        viewVideo.add(new VideoHelperClass(R.drawable.card_4, "Losing My Virginity - Insights from the book by Richard Branson"));
        viewVideo.add(new VideoHelperClass(R.drawable.card_1, "Losing My Virginity - Insights from the book by Richard Branson"));


        adapter = new VideoAdapter(viewVideo);
        recommendedRecycler.setAdapter(adapter);

    }

    private void recommendedRecycler2() {
        recommendedRecycler2.setHasFixedSize(true);
        recommendedRecycler2.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        recommendedRecycler2.setOnClickListener(v -> startActivity(new Intent(getActivity(), VideoDetailPage.class)));

        ArrayList<VideoHelperClass> viewVideo = new ArrayList<>();

        viewVideo.add(new VideoHelperClass(R.drawable.card_1, "Losing My Virginity - Insights from the book by Richard Branson"));
        viewVideo.add(new VideoHelperClass(R.drawable.card_2, "Losing My Virginity - Insights from the book by Richard Branson"));
        viewVideo.add(new VideoHelperClass(R.drawable.card_3, "Losing My Virginity - Insights from the book by Richard Branson"));
        viewVideo.add(new VideoHelperClass(R.drawable.card_4, "Losing My Virginity - Insights from the book by Richard Branson"));
        viewVideo.add(new VideoHelperClass(R.drawable.card_1, "Losing My Virginity - Insights from the book by Richard Branson"));


        adapter = new VideoAdapter(viewVideo);
        recommendedRecycler2.setAdapter(adapter);

    }

    private void recommendedRecycler3() {
        recommendedRecycler3.setHasFixedSize(true);
        recommendedRecycler3.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        recommendedRecycler3.setOnClickListener(v -> startActivity(new Intent(getActivity(), VideoDetailPage.class)));

        ArrayList<VideoHelperClass> viewVideo = new ArrayList<>();

        viewVideo.add(new VideoHelperClass(R.drawable.card_1, "Losing My Virginity - Insights from the book by Richard Branson"));
        viewVideo.add(new VideoHelperClass(R.drawable.card_2, "Losing My Virginity - Insights from the book by Richard Branson"));
        viewVideo.add(new VideoHelperClass(R.drawable.card_3, "Losing My Virginity - Insights from the book by Richard Branson"));
        viewVideo.add(new VideoHelperClass(R.drawable.card_4, "Losing My Virginity - Insights from the book by Richard Branson"));
        viewVideo.add(new VideoHelperClass(R.drawable.card_1, "Losing My Virginity - Insights from the book by Richard Branson"));


        adapter = new VideoAdapter(viewVideo);
        recommendedRecycler3.setAdapter(adapter);


    }

}