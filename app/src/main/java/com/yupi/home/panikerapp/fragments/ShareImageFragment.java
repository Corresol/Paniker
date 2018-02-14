package com.yupi.home.panikerapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.yupi.home.panikerapp.R;
import com.yupi.home.panikerapp.utils.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShareImageFragment extends Fragment {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.addPhoto)
    Button addImage;
    @BindView(R.id.image)
    ImageView image;
    String getMsg;
    public ShareImageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.share_image_layout, container, false);
        ButterKnife.bind(this, view);
        if(getArguments()!= null)
            getMsg = getArguments().getString(Constants.toolbarMsg);
        if(getMsg != null)
        if(getMsg.equals(Constants.toolbarMsg)){
            addImage.setVisibility(View.VISIBLE);
            image.setVisibility(View.GONE);
        }
        else {
            addImage.setVisibility(View.GONE);
            image.setVisibility(View.VISIBLE);
        }
        setupToolbar();
        return view;
    }
    private void setupToolbar(){
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.remove(ShareImageFragment.this).commit();
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        if(getArguments()!= null)
            getMsg = getArguments().getString(Constants.toolbarMsg);
        if(getMsg != null)
            if(getMsg.equals(Constants.toolbarMsg)){
                addImage.setVisibility(View.VISIBLE);
                image.setVisibility(View.GONE);
            }
            else {
                addImage.setVisibility(View.GONE);
                image.setVisibility(View.VISIBLE);
            }
    }

    @Override
    public void onStart() {
        super.onStart();
        if(getArguments()!= null)
            getMsg = getArguments().getString(Constants.toolbarMsg);
        if(getMsg != null)
            if(getMsg.equals(Constants.toolbarMsg)){
                addImage.setVisibility(View.VISIBLE);
                image.setVisibility(View.GONE);
            }
            else {
                addImage.setVisibility(View.GONE);
                image.setVisibility(View.VISIBLE);
            }
    }
}
