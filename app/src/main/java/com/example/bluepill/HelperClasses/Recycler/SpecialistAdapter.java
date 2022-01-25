package com.example.bluepill.HelperClasses.Recycler;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bluepill.R;
import com.example.bluepill.User.Features.Appointments.ViewDoctorProfile;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class SpecialistAdapter extends RecyclerView.Adapter<SpecialistAdapter.SpecialistViewHolder> {

    ArrayList<SpecialistHelperClass> viewSpecialist;

    public SpecialistAdapter(ArrayList<SpecialistHelperClass> viewSpecialist) {
        this.viewSpecialist = viewSpecialist;
    }

    @NonNull
    @Override
    public SpecialistViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_card_view, parent, false);
        SpecialistViewHolder specialistViewHolder = new SpecialistViewHolder(view);
        return specialistViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SpecialistViewHolder holder, int position) {

        SpecialistHelperClass specialistHelperClass = viewSpecialist.get(position);

        holder.image.setImageResource(specialistHelperClass.getImage());
        holder.title.setText(specialistHelperClass.getTitle());
        holder.desc.setText(specialistHelperClass.getDescription());

    }

    @Override
    public int getItemCount() {
        return viewSpecialist.size();
    }


    public static class SpecialistViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView title, desc;

        public SpecialistViewHolder(@NonNull View itemView) {
            super(itemView);

            //Hooks
            image = itemView.findViewById(R.id.specialist_image);
            title = itemView.findViewById(R.id.mv_title);
            desc = itemView.findViewById(R.id.mv_description);

            itemView.setOnClickListener(v -> {
                int position = getBindingAdapterPosition();

                Snackbar.make(v, "Click detected on item" + position, Snackbar.LENGTH_LONG).setAction("Action", null).show();
            });

        }
    }

}
