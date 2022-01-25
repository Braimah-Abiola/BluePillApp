package com.example.bluepill.HelperClasses.Recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bluepill.R;

import java.util.ArrayList;

public class UpcomingReminderAdapter extends RecyclerView.Adapter<UpcomingReminderAdapter.UpcomingReminderViewHolder> {

    ArrayList<UpcomingReminderHelperClass> upcoming;

    public UpcomingReminderAdapter(ArrayList<UpcomingReminderHelperClass> upcoming) {
        this.upcoming = upcoming;
    }

    @NonNull
    @Override
    public UpcomingReminderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.upcoming_reminder_explore_card_design, parent, false);
        UpcomingReminderViewHolder upcomingReminderViewHolder = new UpcomingReminderViewHolder(view);
        return upcomingReminderViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UpcomingReminderViewHolder holder, int position) {

        UpcomingReminderHelperClass upcomingReminderHelperClass = upcoming.get(position);

        holder.title.setText(upcomingReminderHelperClass.getTitle());
        holder.desc.setText(upcomingReminderHelperClass.getDesc());
        holder.type.setText(upcomingReminderHelperClass.getType());
        holder.time.setText(upcomingReminderHelperClass.getTime());

    }

    @Override
    public int getItemCount() {
        return upcoming.size();
    }


    public static class UpcomingReminderViewHolder extends RecyclerView.ViewHolder {

        TextView title, desc, type, time;

        public UpcomingReminderViewHolder(@NonNull View itemView) {
            super(itemView);

            //Hooks
            title = itemView.findViewById(R.id.txt_1);
            desc = itemView.findViewById(R.id.txt_2);
            type = itemView.findViewById(R.id.txt_3);
            time = itemView.findViewById(R.id.txt_4);

        }
    }

}
