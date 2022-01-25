package com.example.bluepill.HelperClasses.Recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bluepill.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecentClientsAdapter extends RecyclerView.Adapter<RecentClientsAdapter.RecentClientsViewHolder> {

    ArrayList<RecentClientsHelperClass> summary;

    public RecentClientsAdapter(ArrayList<RecentClientsHelperClass> summary) {
        this.summary = summary;
    }

    @NonNull
    @Override
    public RecentClientsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_summary_recycler, parent, false);
        RecentClientsViewHolder summaryViewHolder = new RecentClientsViewHolder(view);
        return summaryViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecentClientsViewHolder holder, int position) {

        RecentClientsHelperClass recentClientsHelperClass = summary.get(position);

        holder.image.setImageResource(recentClientsHelperClass.getImage());
        holder.name.setText(recentClientsHelperClass.getName());
        holder.code.setText(recentClientsHelperClass.getCode());
        holder.date.setText(recentClientsHelperClass.getDate());
        holder.condition.setText(recentClientsHelperClass.getCondition());

    }

    @Override
    public int getItemCount() {
        return summary.size();
    }


    public static class RecentClientsViewHolder extends RecyclerView.ViewHolder {

        CircleImageView image;
        TextView name, code, date, condition;

        public RecentClientsViewHolder(@NonNull View itemView) {
            super(itemView);

            //Hooks
            image = itemView.findViewById(R.id.user_image);
            name = itemView.findViewById(R.id.patient_name);
            code = itemView.findViewById(R.id.appointment_id);
            date = itemView.findViewById(R.id.date);
            condition = itemView.findViewById(R.id.condition);

        }
    }

}
