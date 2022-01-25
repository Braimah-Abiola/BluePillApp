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

public class SuggestedAdapter extends RecyclerView.Adapter<SuggestedAdapter.SuggestedViewHolder> {

    ArrayList<SuggestedHelperClass> suggested;

    public SuggestedAdapter(ArrayList<SuggestedHelperClass> suggested) {
        this.suggested = suggested;
    }

    @NonNull
    @Override
    public SuggestedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.explore_suggested_doctors, parent, false);
        SuggestedViewHolder suggestedViewHolder = new SuggestedViewHolder(view);
        return suggestedViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SuggestedViewHolder holder, int position) {

        SuggestedHelperClass suggestedHelperClass = suggested.get(position);

        holder.profile_picture.setImageResource(suggestedHelperClass.getImage());
        holder.name.setText(suggestedHelperClass.getName());
        holder.specialty.setText(suggestedHelperClass.getSpecialty());

    }

    @Override
    public int getItemCount() {
        return suggested.size();
    }


    public static class SuggestedViewHolder extends RecyclerView.ViewHolder {

        CircleImageView profile_picture;
        TextView name, specialty;

        public SuggestedViewHolder(@NonNull View itemView) {
            super(itemView);

            //Hooks
            name = itemView.findViewById(R.id.doctor_name);
            specialty = itemView.findViewById(R.id.doctor_specialty);
            profile_picture = itemView.findViewById(R.id.doctor_profile_picture);

        }
    }

}
