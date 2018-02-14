package com.yupi.home.panikerapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yupi.home.panikerapp.R;
import com.yupi.home.panikerapp.utils.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class BluetoothFragment extends Fragment {


    @BindView(R.id.topic)
    TextView topic;
    public BluetoothFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bluetooth, container, false);
        ButterKnife.bind(this, view);
        topic.setText("Bluetooth Devices");
        return view;
    }
    @OnClick({R.id.returnBack, R.id.someDevice, R.id.someAnotherDevice,
            R.id.someConnectedDevice, R.id.someAnotherConnectedDevice})
    public void returnBack(View view) {
        switch (view.getId()){
            case R.id.returnBack:
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.remove(BluetoothFragment.this).commit();
                break;
            case R.id.someDevice:
                transaction(R.id.rootLayout, new PairedDevicesFragment())
                        .addToBackStack(Constants.backStack).commit();
                break;
            case R.id.someAnotherDevice:
                transaction(R.id.rootLayout, new PairedDevicesFragment()
                ).addToBackStack(Constants.backStack).commit();
                break;
            case R.id.someConnectedDevice:
                transaction(R.id.rootLayout, new ConnectedDevicesFragment())
                        .addToBackStack(Constants.backStack).commit();
                break;
            case R.id.someAnotherConnectedDevice:
                transaction(R.id.rootLayout, new ConnectedDevicesFragment())
                        .addToBackStack(Constants.backStack).commit();
                break;
        }
    }
    private FragmentTransaction transaction(int id, Fragment fragment){
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(id, fragment);
        return fragmentTransaction;
    }
}
