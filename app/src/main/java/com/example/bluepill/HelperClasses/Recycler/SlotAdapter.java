package com.example.bluepill.HelperClasses.Recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bluepill.R;

import java.util.ArrayList;

public class SlotAdapter extends RecyclerView.Adapter<SlotAdapter.SlotViewHolder> {

    ArrayList<SlotHelperClass> featuredSlot;

    public SlotAdapter(ArrayList<SlotHelperClass> featuredSlot) {
        this.featuredSlot = featuredSlot;
    }

    @NonNull
    @Override
    public SlotViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.appointment_slots_card, parent, false);
        SlotViewHolder slotViewHolder = new SlotViewHolder(view);
        return slotViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SlotViewHolder holder, int position) {

        SlotHelperClass slotHelperClass = featuredSlot.get(position);

        holder.date.setText(slotHelperClass.getDate());
    }

    @Override
    public int getItemCount() {
        return featuredSlot.size();
    }


    public static class SlotViewHolder extends RecyclerView.ViewHolder{

        TextView date;

        public SlotViewHolder(@NonNull View itemView) {
            super(itemView);

            //Hooks
            date = itemView.findViewById(R.id.radio_date);

        }
    }

}
