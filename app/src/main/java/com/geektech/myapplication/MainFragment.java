package com.geektech.myapplication;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment implements IRecyclerListener {
    static final String TAG = "main_fragment";

    IMainFragmentListener listener;
    private MainAdapter adapter;

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener = (IMainFragmentListener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupRecycler(view);
    }

    private void setupRecycler(View v) {
        RecyclerView recyclerView = v.findViewById(R.id.recycler_view);
        adapter = new MainAdapter(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onViewHolderClick(String s) {
        listener.openDetails(s);
    }

    public void addNewText(String s) {
        adapter.insertToTop(s);
    }
}
