package com.geektech.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainViewHolder> {

    private ArrayList<String> data;
    private IRecyclerListener listener;

    public MainAdapter(IRecyclerListener listener) {
        this.listener = listener;
        data = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            data.add("Element " + i);
        }
    }

    public void insertToTop(String s) {
        data.add(0, s);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.viewholder_main, parent, false);
        MainViewHolder vh = new MainViewHolder(v);
        vh.listener = listener;
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        holder.onBind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
