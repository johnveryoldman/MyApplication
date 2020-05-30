package com.geektech.myapplication;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MainViewHolder extends RecyclerView.ViewHolder {
    private TextView textView;
    IRecyclerListener listener;

    public MainViewHolder(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.vh_textView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onViewHolderClick(textView.getText().toString());
            }
        });
    }

    public void onBind(String s) {
        textView.setText(s);
    }
}
