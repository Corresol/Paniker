package com.yupi.home.panikerapp.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.yupi.home.panikerapp.R;
import com.yupi.home.panikerapp.adapter.MainAdapterFeed;
import com.yupi.home.panikerapp.ui.InsidePostActivity;
import com.yupi.home.panikerapp.utils.Constants;
import com.yupi.home.panikerapp.utils.Data;
import com.yupi.home.panikerapp.utils.ItemClickSupport;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {
    ArrayList<Data> datas;
    Data data;
    RecyclerView recyclerView;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        setupRecyclerViewClick(recyclerView);
        setupAdapter();
        return view;
    }

    private void setupAdapter() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.hasFixedSize();
        data = new Data();
        data.setMainTextPost(getResources().getString(R.string.lorem_ipsum));
        data.setProfileImage(R.drawable.joanna);
        data.setProfileName("Joanna Doe");
        data.setMainImagePost(R.drawable.layer2);
        data.setIsLive(0);
        datas = new ArrayList<>();
        datas.add(data);
        data = new Data();
        data.setMainTextPost(getResources().getString(R.string.lorem_ipsum_second_part));
        data.setProfileImage(R.drawable.john);
        data.setProfileName("John Doe");
        data.setMainImagePost(R.drawable.layer1_second_live);
        data.setIsLive(1);
        datas.add(data);
        MainAdapterFeed mainAdapterFeed = new MainAdapterFeed(getActivity(), datas, new MainAdapterFeed.ClickListeners() {
            @Override
            public void profileImageClickListener(View view, int position) {
                Data data = datas.get(position);
                UserProfileFragment userProfileFragment = new UserProfileFragment();
                Bundle bundle = new Bundle();
                bundle.putInt(Constants.profileImageKey, data.getProfileImage());
                bundle.putString(Constants.profileNameKey, data.getProfileName());
                userProfileFragment.setArguments(bundle);
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.root_frameLayout, userProfileFragment);
                transaction.commit();
            }
        });
        recyclerView.setAdapter(mainAdapterFeed);
    }

    private void setupRecyclerViewClick(RecyclerView recyclerView) {
        ItemClickSupport.addTo(recyclerView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                Data data = datas.get(position);
                if(data.getIsLive() == 0) {
                    Intent intent = new Intent(getActivity(), InsidePostActivity.class);
                    intent.putExtra(Constants.profileImageKey, data.getProfileImage());
                    intent.putExtra(Constants.profileNameKey, data.getProfileName());
                    intent.putExtra(Constants.mainImageKey, data.getMainImagePost());
                    intent.putExtra(Constants.postTextKey, data.getMainTextPost());
                    startActivity(intent);
                }
                else {
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    LiveFragment liveFragment = new LiveFragment();
                    Bundle bundle = new Bundle();
                    bundle.putInt(Constants.isLiveKey, data.getIsLive());
                    liveFragment.setArguments(bundle);
                    transaction.replace(R.id.root_frameLayout, liveFragment)
                            .addToBackStack(Constants.backStack).commit();
                }
            }
        });
    }
    private FragmentTransaction transaction() {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        return fragmentTransaction;
    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
}
