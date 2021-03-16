package com.example.bluepill.HelperClasses.DashboardAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bluepill.R;

import java.util.ArrayList;

public class PaymentAdapter extends RecyclerView.Adapter<PaymentAdapter.PaymentViewHolder> {

    ArrayList<PaymentHelperClass> paymentCategory;

    public PaymentAdapter(ArrayList<PaymentHelperClass> paymentCategory) {
        this.paymentCategory = paymentCategory;
    }

    @NonNull
    @Override
    public PaymentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.payment_card_design, parent, false);
        PaymentViewHolder paymentViewHolder = new PaymentViewHolder(view);
        return paymentViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PaymentViewHolder holder, int position) {

        PaymentHelperClass paymentHelperClass = paymentCategory.get(position);

        holder.image.setImageResource(paymentHelperClass.getImage());

    }

    @Override
    public int getItemCount() {
        return paymentCategory.size();
    }


    public static class PaymentViewHolder extends RecyclerView.ViewHolder{

        ImageView image;

        public PaymentViewHolder(@NonNull View itemView) {
            super(itemView);

            //Hooks
            image = itemView.findViewById(R.id.pay_image);

        }
    }

}
