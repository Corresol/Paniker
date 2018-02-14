package com.yupi.home.panikerapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.yupi.home.panikerapp.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FollowFriendsFragment extends Fragment {
    ListView listView;
    ArrayList<Integer> integers;
    ArrayAdapter<Integer> adapter;

    public FollowFriendsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_follow_friends, container, false);
        listView = (ListView)view.findViewById(R.id.listView);
        integers = new ArrayList<>();
        integers.add(1);
        integers.add(1);
        integers.add(1);
        integers.add(1);
        adapter = new ArrayAdapter<Integer>(getActivity(), R.layout.follow_friends_adapter_layout, integers);
        listView.setAdapter(adapter);
        return view;
    }

}
