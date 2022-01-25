package com.example.bluepill.HelperClasses.Recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bluepill.R;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    ArrayList<CategoryHelperClass> featuredCategory;

    public CategoryAdapter(ArrayList<CategoryHelperClass> featuredCategory) {
        this.featuredCategory = featuredCategory;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_card_design, parent, false);
        CategoryViewHolder categoryViewHolder = new CategoryViewHolder(view);
        return categoryViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {

        CategoryHelperClass categoryHelperClass = featuredCategory.get(position);

        holder.image.setImageResource(categoryHelperClass.getImage());
        holder.title.setText(categoryHelperClass.getTitle());
        holder.relativeLayout.setBackground(categoryHelperClass.getDrawable());

    }

    @Override
    public int getItemCount() {
        return featuredCategory.size();
    }


    public static class CategoryViewHolder extends RecyclerView.ViewHolder{

        RelativeLayout relativeLayout;
        ImageView image;
        TextView title;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);

            //Hooks
            image = itemView.findViewById(R.id.categories_image);
            title = itemView.findViewById(R.id.categories_title);
            relativeLayout = itemView.findViewById(R.id.holder);

        }
    }

}
