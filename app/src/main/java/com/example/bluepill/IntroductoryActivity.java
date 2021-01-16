package com.example.bluepill;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;


public class IntroductoryActivity extends AppCompatActivity {

    ImageView logo, icon;
    TextView appName;
    LottieAnimationView lottieAnimationView;

    private static  final int NUM_PAGES = 3;
    private ViewPager viewPager;
    private ScreenSlidePagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_introductory);
        icon = findViewById(R.id.icon);
        logo = findViewById(R.id.logo);
        appName = findViewById(R.id.txt);
        lottieAnimationView = findViewById(R.id.lottie);

        viewPager = findViewById(R.id.pager);
        pagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);

        logo.animate().translationY(1400).setDuration(1000).setStartDelay(4000);
        appName.animate().translationY(1400).setDuration(1000).setStartDelay(4000);
        icon.animate().translationY(1400).setDuration(1000).setStartDelay(4000);
        lottieAnimationView.animate().translationY(1400).setDuration(1000).setStartDelay(4000);

       /* Runnable r = new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(IntroductoryActivity.this, Login.class));
            }
        };

        Handler h = new Handler();
        h.postDelayed(r, 4000); */

    }

    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter{

        public ScreenSlidePagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position){

                case 0:
                OnBoardingFragment1 tab1 = new OnBoardingFragment1();
                return  tab1;
                case 1:
                OnBoardingFragment2 tab2 = new OnBoardingFragment2();
                return  tab2;
                case 2:
                OnBoardingFragment3 tab3 = new OnBoardingFragment3();
                return  tab3;
            }
            return null;
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }

}