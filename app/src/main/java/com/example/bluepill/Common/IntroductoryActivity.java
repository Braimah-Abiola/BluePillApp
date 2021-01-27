package com.example.bluepill.Common;

import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.airbnb.lottie.LottieAnimationView;
import com.example.bluepill.OnBoarding.OnBoardingFragment1;
import com.example.bluepill.OnBoarding.OnBoardingFragment2;
import com.example.bluepill.OnBoarding.OnBoardingFragment3;
import com.example.bluepill.R;


public class IntroductoryActivity extends AppCompatActivity {

    ImageView logo, icon;
    TextView appName;

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

        logo.animate().translationY(1400).setDuration(1000).setStartDelay(3000);
        appName.animate().translationY(1400).setDuration(1000).setStartDelay(3000);
        icon.animate().translationY(1400).setDuration(1000).setStartDelay(3000);

      Runnable r = () -> {
          logo.destroyDrawingCache();
          appName.destroyDrawingCache();
          icon.destroyDrawingCache();
          viewPager = findViewById(R.id.pager);
          pagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
          viewPager.setAdapter(pagerAdapter);
      };

        Handler h = new Handler();
        h.postDelayed(r, 3700);

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