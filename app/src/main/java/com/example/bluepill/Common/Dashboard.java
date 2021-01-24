package com.example.bluepill.Common;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.WindowManager;

import com.example.bluepill.HelperClasses.DashboardAdapter.CategoryAdapter;
import com.example.bluepill.HelperClasses.DashboardAdapter.CategoryHelperClass;
import com.example.bluepill.HelperClasses.DashboardAdapter.FeaturedAdapter;
import com.example.bluepill.HelperClasses.DashboardAdapter.FeaturedHelperClass;
import com.example.bluepill.HelperClasses.DashboardAdapter.MostViewedAdapter;
import com.example.bluepill.HelperClasses.DashboardAdapter.MostViewedHelperClass;
import com.example.bluepill.R;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class Dashboard extends AppCompatActivity {

    RecyclerView mostViewedRecycler, categoriesRecycler, featuredRecycler;
    RecyclerView.Adapter adapter;
    private GradientDrawable gradient1, gradient2, gradient3, gradient4, gradient5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_dashboard);

        //Hooks
        featuredRecycler = findViewById(R.id.featured_recycler);
        mostViewedRecycler = findViewById(R.id.most_viewed_recycler);
        categoriesRecycler = findViewById(R.id.categories_recycler);


        //Recycler Views Function Calls
        featuredRecycler();
        mostViewedRecycler();
        categoriesRecycler();

    }

    //Recycler Views Functions
    private void mostViewedRecycler() {

        mostViewedRecycler.setHasFixedSize(true);
        mostViewedRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<MostViewedHelperClass> mostViewed = new ArrayList<>();

        mostViewed.add(new MostViewedHelperClass(R.drawable.card_1,"Macdonald's 1", "Hey there my name is abiola and I am currently developing an app called blue pill. Stay tuned for more."));
        mostViewed.add(new MostViewedHelperClass(R.drawable.card_2,"Macdonald's 2", "Hey there my name is abiola and I am currently developing an app called blue pill. Stay tuned for more."));
        mostViewed.add(new MostViewedHelperClass(R.drawable.card_3,"Macdonald's 3", "Hey there my name is abiola and I am currently developing an app called blue pill. Stay tuned for more."));
        mostViewed.add(new MostViewedHelperClass(R.drawable.card_4,"Macdonald's 4", "Hey there my name is abiola and I am currently developing an app called blue pill. Stay tuned for more."));
        mostViewed.add(new MostViewedHelperClass(R.drawable.card_1,"Macdonald's 5", "Hey there my name is abiola and I am currently developing an app called blue pill. Stay tuned for more."));


        adapter = new MostViewedAdapter(mostViewed);
        mostViewedRecycler.setAdapter(adapter);

    }

    private void categoriesRecycler() {


    }

    private void featuredRecycler() {

        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<FeaturedHelperClass> featuredLocations = new ArrayList<>();

        featuredLocations.add(new FeaturedHelperClass(R.drawable.card_1,"Macdonald's 1", "Hey there my name is abiola and I am currently developing an app called blue pill. Stay tuned for more."));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.card_2,"Macdonald's 2", "Hey there my name is abiola and I am currently developing an app called blue pill. Stay tuned for more."));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.card_3,"Macdonald's 3", "Hey there my name is abiola and I am currently developing an app called blue pill. Stay tuned for more."));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.card_4,"Macdonald's 4", "Hey there my name is abiola and I am currently developing an app called blue pill. Stay tuned for more."));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.card_1,"Macdonald's 5", "Hey there my name is abiola and I am currently developing an app called blue pill. Stay tuned for more."));


        adapter = new FeaturedAdapter(featuredLocations);
        featuredRecycler.setAdapter(adapter);

    }
}