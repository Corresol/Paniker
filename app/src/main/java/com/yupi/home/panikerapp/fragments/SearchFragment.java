package com.yupi.home.panikerapp.fragments;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yupi.home.panikerapp.R;
import com.yupi.home.panikerapp.adapter.SearchPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment {

    @BindView(R.id.viewpager)
    ViewPager viewPager;
    @BindView(R.id.tabLayout)
    TabLayout tableLayout;

    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_search, container, false);
        ButterKnife.bind(this, view);
        setViewPager();
        return view;
    }
    private void setViewPager(){
        SearchPagerAdapter searchPagerAdapter = new SearchPagerAdapter(getChildFragmentManager(),
                getResources(), getActivity());
        viewPager.setAdapter(searchPagerAdapter);
        tableLayout.setupWithViewPager(viewPager);
    }
}
