package com.yupi.home.panikerapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yupi.home.panikerapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class PairedDevicesFragment extends Fragment {


    @BindView(R.id.topic)
    TextView topic;
    public PairedDevicesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_paired_devices, container, false);
        ButterKnife.bind(this, view);
        topic.setText("Paired Devices");
        return view;
    }
    @OnClick({R.id.returnBack})
    public void returnBack(View view) {
        switch (view.getId()){
            case R.id.returnBack:
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.remove(PairedDevicesFragment.this).commit();
                break;
        }
    }
}
