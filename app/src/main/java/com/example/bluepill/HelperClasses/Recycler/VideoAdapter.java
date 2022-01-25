package com.example.bluepill.HelperClasses.Recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bluepill.R;

import java.util.ArrayList;
import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {

    ArrayList<VideoHelperClass> viewVideo;


    public VideoAdapter(ArrayList<VideoHelperClass> viewVideo) {
        this.viewVideo = viewVideo;
    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_card, parent, false);
        VideoViewHolder videoViewHolder = new VideoViewHolder(view, mListener);
        return videoViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {

        VideoHelperClass videoHelperClass = viewVideo.get(position);

        holder.image.setImageResource(videoHelperClass.getImage());
        holder.title.setText(videoHelperClass.getTitle());

        holder.cardView.setOnClickListener(v -> {

        });

    }

    @Override
    public int getItemCount() {
        return viewVideo.size();
    }

    private OnItemClickListener mListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    public static class VideoViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView title;
        CardView cardView;

        public VideoViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);

            //Hooks
            image = itemView.findViewById(R.id.thumbnail);
            title = itemView.findViewById(R.id.title);
            cardView = itemView.findViewById(R.id.video_card);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });

        }
    }
}
