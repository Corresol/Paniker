package com.yupi.home.panikerapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yupi.home.panikerapp.R;
import com.yupi.home.panikerapp.adapter.GalleryAdapter;
import com.yupi.home.panikerapp.adapter.TopAdapter;
import com.yupi.home.panikerapp.utils.Data;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TopFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<Data> datas;
    TopAdapter topAdapter;
    public TopFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_top,
                container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerView);
        setupAdapter();
        return view;
    }
    private void setupAdapter(){
        Data data = new Data();
        datas = new ArrayList<>();
        data.setProfileImage(R.drawable.profile_image);
        datas.add(data);
        data = new Data();
        data.setProfileImage(R.drawable.notification_profile_image);
        datas.add(data);
        data = new Data();
        data.setProfileImage(R.drawable.profile_image);
        datas.add(data);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.hasFixedSize();
        topAdapter = new TopAdapter(getActivity(), datas, R.layout.top_adapter_layout);
        recyclerView.setAdapter(topAdapter);
    }
}
