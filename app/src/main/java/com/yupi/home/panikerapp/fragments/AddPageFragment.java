package com.yupi.home.panikerapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yupi.home.panikerapp.R;
import com.yupi.home.panikerapp.utils.Constants;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddPageFragment extends Fragment {


    public AddPageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.settings_add_layout, container, false);
        ButterKnife.bind(this, view);
        return view;
    }
    @OnClick({R.id.returnBack, R.id.fingerprint, R.id.takePicture, R.id.panikerStorage, R.id.phoneStorage})
    public void setReturnBack(View view){
        switch (view.getId()){
            case R.id.returnBack:
                removeFragment(AddPageFragment.this).commit();
                transaction().replace(R.id.root_frameLayout, new PanicFragment()).commit();
                break;
            case R.id.fingerprint:
                transaction().add(R.id.root_frameLayout, new FingerPrintFragment())
                        .addToBackStack(Constants.backStack).commit();
                break;
            case R.id.takePicture:
                transaction().add(R.id.root_frameLayout, new TakePhotoFragment())
                        .addToBackStack(Constants.backStack).commit();
              //  multiMediaFragment.viewPager.setCurrentItem(1);
                break;
            case R.id.panikerStorage:
                alertDialog(R.layout.paniker_storage_layout).show();
                break;
            case R.id.phoneStorage:
                alertDialog(R.layout.dialog_select_file_layout).show();
                break;
        }

    }
    private FragmentTransaction transaction(){
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        return fragmentTransaction;
    }
    private FragmentTransaction removeFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.remove(fragment);
        return fragmentTransaction;
    }
    private AlertDialog.Builder alertDialog(int id){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View view = getActivity().getLayoutInflater().inflate(id, null);
        builder.setView(view);
        return builder;
    }
}
