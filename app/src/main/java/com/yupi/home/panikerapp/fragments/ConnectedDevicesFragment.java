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
public class ConnectedDevicesFragment extends Fragment {

    @BindView(R.id.topic)
    TextView topic;
    public ConnectedDevicesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_connected_devices, container, false);
        ButterKnife.bind(this, view);
        topic.setText("Connected Devices");
        return view;
    }
    @OnClick({R.id.returnBack})
    public void returnBack(View view){
        switch (view.getId()){
            case R.id.returnBack:
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.remove(ConnectedDevicesFragment.this).commit();
                break;
        }
    }
}
