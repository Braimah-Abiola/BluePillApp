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

public class PaymentAdapter extends RecyclerView.Adapter<PaymentAdapter.PaymentViewHolder> {

    ArrayList<PaymentHelperClass> paymentCategory;

    public PaymentAdapter(ArrayList<PaymentHelperClass> paymentCategory) {
        this.paymentCategory = paymentCategory;
    }

    @NonNull
    @Override
    public PaymentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.payment_card_design, parent, false);
        PaymentViewHolder paymentViewHolder = new PaymentViewHolder(view);
        return paymentViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PaymentViewHolder holder, int position) {

        PaymentHelperClass paymentHelperClass = paymentCategory.get(position);

        holder.image.setImageResource(paymentHelperClass.getImage());
        holder.cvvNumber.setText(paymentHelperClass.getCvv());
        holder.expiryDate.setText(paymentHelperClass.getExpiryDate());
        holder.cardHolder.setText(paymentHelperClass.getCardHolder());
        holder.cardNumber.setText(paymentHelperClass.getCardNumber());
        holder.relativeLayout.setBackground(paymentHelperClass.getDrawable());

    }

    @Override
    public int getItemCount() {
        return paymentCategory.size();
    }


    public static class PaymentViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        RelativeLayout relativeLayout;
        TextView cardNumber, expiryDate, cardHolder, cvvNumber;

        public PaymentViewHolder(@NonNull View itemView) {
            super(itemView);

            //Hooks
            relativeLayout = itemView.findViewById(R.id.card_view);
            image = itemView.findViewById(R.id.credit_card_logo);
            cardNumber = itemView.findViewById(R.id.card_number);
            cardHolder = itemView.findViewById(R.id.card_holder);
            expiryDate = itemView.findViewById(R.id.expiry_date);
            cvvNumber = itemView.findViewById(R.id.cvv);

        }
    }

}
