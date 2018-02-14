package com.yupi.home.panikerapp.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.yupi.home.panikerapp.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class FriendReqFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    @BindView(R.id.listView)
    ListView listView;
    @BindView(R.id.topic)
    TextView topic;
    ArrayList<String> integers;
    ArrayAdapter<String> adapter;


    public FriendReqFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FriendReqFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FriendReqFragment newInstance(String param1, String param2) {
        FriendReqFragment fragment = new FriendReqFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_friend_req, container, false);
        ButterKnife.bind(this, view);
        integers = new ArrayList<>();
        integers.add("John Doe");
        integers.add("John Doe");
        integers.add("John Doe");
        integers.add("John Doe");
        adapter = new ArrayAdapter<String>(getActivity(), R.layout.friend_request_adapter_layout, R.id.name, integers);
        listView.setAdapter(adapter);
        topic.setText("Friends requests");
        return view;
    }
    @OnClick({R.id.returnBack})
    public void returnBack(View view){
        switch (view.getId()){
            case R.id.returnBack:
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.remove(FriendReqFragment.this).commit();
                break;
        }
    }
}
