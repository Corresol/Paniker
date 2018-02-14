package com.yupi.home.panikerapp.ui;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.yupi.home.panikerapp.R;
import com.yupi.home.panikerapp.adapter.TopAdapter;
import com.yupi.home.panikerapp.fragments.MainFragment;
import com.yupi.home.panikerapp.utils.Data;
import com.yupi.home.panikerapp.utils.ItemClickSupport;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class FriendsFragment extends Fragment {

    ArrayList<Data> datas;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.rootLayout)
    FrameLayout frameLayout;
    TopAdapter topAdapter;
    public FriendsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_friends, container, false);
        ButterKnife.bind(this, view);
        setupAdapter();
        return view;
    }
    private void setupAdapter(){
        datas = new ArrayList<>();
        Data data = new Data();
        datas = new ArrayList<>();
        data.setProfileImage(R.drawable.profile_image);
        datas.add(data);
        data = new Data();
        data.setProfileImage(R.drawable.profile_image);
        datas.add(data);
        data = new Data();
        data.setProfileImage(R.drawable.profile_image);
        datas.add(data);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.hasFixedSize();
        topAdapter = new TopAdapter(getActivity(), datas, R.layout.firends_msg_list_adapter_layout);
        recyclerView.setAdapter(topAdapter);
        ItemClickSupport.addTo(recyclerView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                startActivity(new Intent(getActivity(), MessagesActivity.class));
            }
        });
    }

    @OnClick(R.id.returnBack)
    public void returnBack(View view){
        removeFragment(FriendsFragment.this).commit();
        //frameLayout.setVisibility(View.INVISIBLE);
    }
    private FragmentTransaction removeFragment(Fragment fragment){
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.remove(fragment);
        return transaction;
    }
}
