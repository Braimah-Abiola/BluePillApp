package com.example.bluepill.Address;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.bluepill.R;

import java.util.ArrayList;

public class AddressSpinnerAdapter extends ArrayAdapter<AddressSpinnerItem> {

    public AddressSpinnerAdapter(Context context, ArrayList<AddressSpinnerItem> spinnerList) {
        super(context, 0, spinnerList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    private View initView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.address_spinner, parent, false
            );
        }

        TextView textView = convertView.findViewById(R.id.spinner_text);

        AddressSpinnerItem currentItem = getItem(position);

        if (currentItem != null) {
            textView.setText(currentItem.getCardName());
        }
        return  convertView;

    }
}
