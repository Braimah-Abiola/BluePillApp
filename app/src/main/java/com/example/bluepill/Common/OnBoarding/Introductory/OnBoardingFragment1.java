package com.example.bluepill.Common.OnBoarding.Introductory;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.bluepill.Common.UserLogInSignUp.UserStartUpScreen;
import com.example.bluepill.R;

public class OnBoardingFragment1 extends Fragment {
    Animation topAnim, bottomAnim;
    TextView textView1, textView2, textView3, skip;
    ImageView imageView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_on_boarding1, container, false);

        // Hooks
        topAnim = AnimationUtils.loadAnimation(getContext(), R.anim.intro_animation_top);
        bottomAnim = AnimationUtils.loadAnimation(getContext(), R.anim.intro_animation_bottom);

        textView1 = root.findViewById(R.id.textView3);
        textView2 = root.findViewById(R.id.textView4);
        textView3 = root.findViewById(R.id.textView5);
        imageView = root.findViewById(R.id.slider);
        skip = root.findViewById(R.id.skip1);

        // Play Animations
        imageView.setAnimation(bottomAnim);
        textView1.setAnimation(bottomAnim);
        textView2.setAnimation(bottomAnim);
        textView3.setAnimation(bottomAnim);
        skip.setAnimation(topAnim);

        // Click Listeners
        skip.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), UserStartUpScreen.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
    });


        return root;
    }
}
