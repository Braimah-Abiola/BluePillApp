package com.example.bluepill.User.Features.Articles;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bluepill.HelperClasses.Recycler.ArticleAdapter;
import com.example.bluepill.HelperClasses.Recycler.ArticleHelperClass;
import com.example.bluepill.HelperClasses.Recycler.CategoryAdapter;
import com.example.bluepill.HelperClasses.Recycler.CategoryHelperClass;
import com.example.bluepill.HelperClasses.Recycler.FeaturedAdapter;
import com.example.bluepill.HelperClasses.Recycler.FeaturedHelperClass;
import com.example.bluepill.HelperClasses.Recycler.MostViewedAdapter;
import com.example.bluepill.HelperClasses.Recycler.MostViewedHelperClass;
import com.example.bluepill.R;
import com.example.bluepill.User.UserDashboardActivity;

import java.util.ArrayList;

public class Articles extends AppCompatActivity {


    RecyclerView mostViewedRecycler, categoriesRecycler, featuredRecycler, articleRecycler;
    RecyclerView.Adapter adapter;
    ImageView backBtn;
    LinearLayout contentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_articles);

        //Hooks
        featuredRecycler = findViewById(R.id.featured_recycler);
        articleRecycler = findViewById(R.id.articles_recycler);
        mostViewedRecycler = findViewById(R.id.most_viewed_recycler);
        categoriesRecycler = findViewById(R.id.categories_recycler);
        contentView = findViewById(R.id.content);
        backBtn = findViewById(R.id.back_icon);


        //Recycler Views Function Calls
        featuredRecycler();
        mostViewedRecycler();
        categoriesRecycler();
        articleRecycler();

        backBtn.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), UserDashboardActivity.class)));

    }

    //Recycler Views Functions
    private void mostViewedRecycler() {

        mostViewedRecycler.setHasFixedSize(true);
        mostViewedRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<MostViewedHelperClass> mostViewed = new ArrayList<>();

        mostViewed.add(new MostViewedHelperClass(R.drawable.card_1, "Macdonald's 1", "Hey there my name is abiola and I am currently developing an app called blue pill. Stay tuned for more."));
        mostViewed.add(new MostViewedHelperClass(R.drawable.card_2, "Macdonald's 2", "Hey there my name is abiola and I am currently developing an app called blue pill. Stay tuned for more."));
        mostViewed.add(new MostViewedHelperClass(R.drawable.card_4, "Macdonald's 3", "Hey there my name is abiola and I am currently developing an app called blue pill. Stay tuned for more."));
        mostViewed.add(new MostViewedHelperClass(R.drawable.card_3, "Macdonald's 4", "Hey there my name is abiola and I am currently developing an app called blue pill. Stay tuned for more."));
        mostViewed.add(new MostViewedHelperClass(R.drawable.card_1, "Macdonald's 5", "Hey there my name is abiola and I am currently developing an app called blue pill. Stay tuned for more."));


        adapter = new MostViewedAdapter(mostViewed);
        mostViewedRecycler.setAdapter(adapter);

    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private void categoriesRecycler() {

        categoriesRecycler.setHasFixedSize(true);
        categoriesRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<CategoryHelperClass> featuredCategory = new ArrayList<>();

        featuredCategory.add(new CategoryHelperClass(R.drawable.forum, "", getDrawable(R.drawable.card_4)));
        featuredCategory.add(new CategoryHelperClass(R.drawable.forum, "", getDrawable(R.drawable.card_2)));
        featuredCategory.add(new CategoryHelperClass(R.drawable.forum, "", getDrawable(R.drawable.card_3)));
        featuredCategory.add(new CategoryHelperClass(R.drawable.forum, "", getDrawable(R.drawable.card_4)));
        featuredCategory.add(new CategoryHelperClass(R.drawable.forum, "", getDrawable(R.drawable.card_4)));
        featuredCategory.add(new CategoryHelperClass(R.drawable.forum, "", getDrawable(R.drawable.card_4)));
        featuredCategory.add(new CategoryHelperClass(R.drawable.forum, "", getDrawable(R.drawable.card_4)));

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

    private void articleRecycler() {

        articleRecycler.setHasFixedSize(true);
        articleRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<ArticleHelperClass> article = new ArrayList<>();

        article.add(new ArticleHelperClass(R.drawable.card_1, "This is shit", "John Doe", "April 21 | 5 mins read"));
        article.add(new ArticleHelperClass(R.drawable.card_2, "This is shit", "John Doe", "April 21 | 5 mins read"));
        article.add(new ArticleHelperClass(R.drawable.card_3, "This is shit", "John Doe", "April 21 | 5 mins read"));
        article.add(new ArticleHelperClass(R.drawable.card_4, "This is shit", "John Doe", "April 21 | 5 mins read"));
        article.add(new ArticleHelperClass(R.drawable.card_3, "This is shit", "John Doe", "April 21 | 5 mins read"));
        article.add(new ArticleHelperClass(R.drawable.card_2, "This is shit", "John Doe", "April 21 | 5 mins read"));
        article.add(new ArticleHelperClass(R.drawable.card_1, "This is shit", "John Doe", "April 21 | 5 mins read"));


        adapter = new ArticleAdapter(article);
        articleRecycler.setAdapter(adapter);

    }

    public void callBookmarks(View view) {
        startActivity(new Intent(getApplicationContext(), ArticleBookmarks.class));
    }

    public void callNotifications(View view) {
        startActivity(new Intent(getApplicationContext(), ArticleNotifications.class));
    }

    public void callFilterTag(View view) {
        startActivity(new Intent(getApplicationContext(), FilterTags.class));
    }

    public void callArticleDetail(View view) {
        startActivity(new Intent(getApplicationContext(), ArticleDetail.class));
    }
}