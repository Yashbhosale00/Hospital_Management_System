package com.example.i_hospital.addmore;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.i_hospital.R;

import java.util.ArrayList;
import java.util.List;

public class SettingsFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private MySettingAdapter mAdapter;
    private List<MyItem> mData;

    public SettingsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize your dataset, for example:
        mData = new ArrayList<>();
        mData.add(new MyItem("Add Staff Role", "ADD"));
        mData.add(new MyItem("Add Department", "ADD"));
        mData.add(new MyItem("Add Product Type", "ADD"));
        mData.add(new MyItem("Add Product Sub Type", "ADD"));
        mData.add(new MyItem("Add Product", "ADD"));
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        mRecyclerView = view.findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        mAdapter = new MySettingAdapter(mData);
        mRecyclerView.setAdapter(mAdapter);

        return view;
    }
}
