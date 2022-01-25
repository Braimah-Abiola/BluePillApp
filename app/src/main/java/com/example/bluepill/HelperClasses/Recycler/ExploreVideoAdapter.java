package com.example.bluepill.HelperClasses.Recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bluepill.R;

import java.util.ArrayList;

public class ExploreVideoAdapter extends RecyclerView.Adapter<ExploreVideoAdapter.ExploreVideoViewHolder> {

    ArrayList<ExploreVideoHelperClass> video;

    public ExploreVideoAdapter(ArrayList<ExploreVideoHelperClass> video) {
        this.video = video;
    }

    @NonNull
    @Override
    public ExploreVideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_explore_card_design, parent, false);
        ExploreVideoViewHolder exploreVideoViewHolder = new ExploreVideoViewHolder(view);
        return exploreVideoViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ExploreVideoViewHolder holder, int position) {

        ExploreVideoHelperClass exploreVideoHelperClass = video.get(position);

        holder.title.setText(exploreVideoHelperClass.getTitle());
    }

    @Override
    public int getItemCount() {
        return video.size();
    }


    public static class ExploreVideoViewHolder extends RecyclerView.ViewHolder {

        TextView title;

        public ExploreVideoViewHolder(@NonNull View itemView) {
            super(itemView);

            //Hooks
            title = itemView.findViewById(R.id.video_title);
        }
    }

}
