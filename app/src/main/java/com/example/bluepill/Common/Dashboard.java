package com.example.bluepill.Common;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bluepill.HelperClasses.DashboardAdapter.CategoryAdapter;
import com.example.bluepill.HelperClasses.DashboardAdapter.CategoryHelperClass;
import com.example.bluepill.HelperClasses.DashboardAdapter.FeaturedAdapter;
import com.example.bluepill.HelperClasses.DashboardAdapter.FeaturedHelperClass;
import com.example.bluepill.HelperClasses.DashboardAdapter.MostViewedAdapter;
import com.example.bluepill.HelperClasses.DashboardAdapter.MostViewedHelperClass;
import com.example.bluepill.R;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class Dashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //Variables
    static final float END_SCALE = 0.7f;

    RecyclerView mostViewedRecycler, categoriesRecycler, featuredRecycler;
    RecyclerView.Adapter adapter;
    ImageView menuIcon;
    LinearLayout contentView;

    //Drawer Menu
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_dashboard);

        //Hooks
        featuredRecycler = findViewById(R.id.featured_recycler);
        mostViewedRecycler = findViewById(R.id.most_viewed_recycler);
        categoriesRecycler = findViewById(R.id.categories_recycler);
        contentView = findViewById(R.id.content);

        //Menu Hooks
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        menuIcon = findViewById(R.id.menu_icon);

        navigationDrawer();

        //Recycler Views Function Calls
        featuredRecycler();
        mostViewedRecycler();
        categoriesRecycler();

    }

    // Navigation Drawer Functions
    private void navigationDrawer() {

        //Navigation Drawer
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);

        menuIcon.setOnClickListener(view -> {
            if (drawerLayout.isDrawerVisible(GravityCompat.START))
                drawerLayout.closeDrawer(GravityCompat.START);
            else drawerLayout.openDrawer(GravityCompat.START);
        });

        animateNavigationDrawer();

    }

    private void animateNavigationDrawer() {

        drawerLayout.setScrimColor(getResources().getColor(R.color.signature_blue_translucent));
        drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

                // Scale the View based on current slide offset
                final float diffScaledOffset = slideOffset * (1 - END_SCALE);
                final float offsetScale = 1 - diffScaledOffset;
                contentView.setScaleX(offsetScale);
                contentView.setScaleY(offsetScale);

                // Translate the view, accounting for the scaled width
                final float xOffset = drawerView.getWidth() * slideOffset;
                final float xOffsetDiff = contentView.getWidth() * diffScaledOffset / 2;
                final float xTranslation = xOffset - xOffsetDiff;
                contentView.setTranslationX(xTranslation);
            }

        });

    }

    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else
            super.onBackPressed();
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return true;
    }


    //Recycler Views Functions
    private void mostViewedRecycler() {

        mostViewedRecycler.setHasFixedSize(true);
        mostViewedRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<MostViewedHelperClass> mostViewed = new ArrayList<>();

        mostViewed.add(new MostViewedHelperClass(R.drawable.card_1, "Macdonald's 1", "Hey there my name is abiola and I am currently developing an app called blue pill. Stay tuned for more."));
        mostViewed.add(new MostViewedHelperClass(R.drawable.card_2, "Macdonald's 2", "Hey there my name is abiola and I am currently developing an app called blue pill. Stay tuned for more."));
        mostViewed.add(new MostViewedHelperClass(R.drawable.card_3, "Macdonald's 3", "Hey there my name is abiola and I am currently developing an app called blue pill. Stay tuned for more."));
        mostViewed.add(new MostViewedHelperClass(R.drawable.card_4, "Macdonald's 4", "Hey there my name is abiola and I am currently developing an app called blue pill. Stay tuned for more."));
        mostViewed.add(new MostViewedHelperClass(R.drawable.card_1, "Macdonald's 5", "Hey there my name is abiola and I am currently developing an app called blue pill. Stay tuned for more."));


        adapter = new MostViewedAdapter(mostViewed);
        mostViewedRecycler.setAdapter(adapter);

    }

    private void categoriesRecycler() {

        categoriesRecycler.setHasFixedSize(true);
        categoriesRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<CategoryHelperClass> featuredCategory = new ArrayList<>();

        featuredCategory.add(new CategoryHelperClass(R.drawable.card_1, "Macdonald's 1", "Hey there bitches how you doing, Imma fuck the hell outta yall"));
        featuredCategory.add(new CategoryHelperClass(R.drawable.card_2, "Macdonald's 2", "Hey there bitches how you doing, Imma fuck the hell outta yall"));
        featuredCategory.add(new CategoryHelperClass(R.drawable.card_3, "Macdonald's 3", "Hey there bitches how you doing, Imma fuck the hell outta yall"));
        featuredCategory.add(new CategoryHelperClass(R.drawable.card_4, "Macdonald's 4", "Hey there bitches how you doing, Imma fuck the hell outta yall"));

        adapter = new CategoryAdapter(featuredCategory);
        categoriesRecycler.setAdapter(adapter);

    }

    private void featuredRecycler() {

        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<FeaturedHelperClass> featuredLocations = new ArrayList<>();

        featuredLocations.add(new FeaturedHelperClass(R.drawable.card_1, "Macdonald's 1", "Hey there my name is abiola and I am currently developing an app called blue pill. Stay tuned for more."));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.card_2, "Macdonald's 2", "Hey there my name is abiola and I am currently developing an app called blue pill. Stay tuned for more."));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.card_3, "Macdonald's 3", "Hey there my name is abiola and I am currently developing an app called blue pill. Stay tuned for more."));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.card_4, "Macdonald's 4", "Hey there my name is abiola and I am currently developing an app called blue pill. Stay tuned for more."));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.card_1, "Macdonald's 5", "Hey there my name is abiola and I am currently developing an app called blue pill. Stay tuned for more."));


        adapter = new FeaturedAdapter(featuredLocations);
        featuredRecycler.setAdapter(adapter);

    }

}