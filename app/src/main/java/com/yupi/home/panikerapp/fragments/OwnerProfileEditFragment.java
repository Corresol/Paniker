package com.yupi.home.panikerapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.yupi.home.panikerapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class OwnerProfileEditFragment extends Fragment {


    @BindView(R.id.returnBack)
    ImageView returnBack;
    @BindView(R.id.rootLayout)
    FrameLayout frameLayout;
    public OwnerProfileEditFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.paniker_profile_edit_layout, container, false);
        ButterKnife.bind(this, view);
        return view;
    }
    @OnClick(R.id.returnBack)
    public void setReturnBack(View view){
        removeFragment(OwnerProfileEditFragment.this).commit();
       // FragmentTransaction transaction = getFragmentManager().beginTransaction();
      //  transaction.replace(R.id.rootLayout, new OwnerProfileFragment());
       // transaction.commit();
    }
    private FragmentTransaction removeFragment(Fragment fragment){
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.remove(fragment);
        return transaction;
    }
}
