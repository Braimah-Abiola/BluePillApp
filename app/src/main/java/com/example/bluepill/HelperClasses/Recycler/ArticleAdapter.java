package com.example.bluepill.HelperClasses.Recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bluepill.R;

import java.util.ArrayList;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder> {

    ArrayList<ArticleHelperClass> article;

    public ArticleAdapter(ArrayList<ArticleHelperClass> article) {
        this.article = article;
    }

    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.article_card, parent, false);
        ArticleViewHolder articleViewHolder = new ArticleViewHolder(view);
        return articleViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {

        ArticleHelperClass articleHelperClass = article.get(position);

        holder.image.setImageResource(articleHelperClass.getImage());
        holder.title.setText(articleHelperClass.getTitle());
        holder.author.setText(articleHelperClass.getAuthor());
        holder.info.setText(articleHelperClass.getInfo());

    }

    @Override
    public int getItemCount() {
        return article.size();
    }


    public static class ArticleViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView title, author, info;

        public ArticleViewHolder(@NonNull View itemView) {
            super(itemView);

            //Hooks
            image = itemView.findViewById(R.id.article_image);
            title = itemView.findViewById(R.id.article_title);
            author = itemView.findViewById(R.id.article_author);
            info = itemView.findViewById(R.id.date_length);

        }
    }

}
