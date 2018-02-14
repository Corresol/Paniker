package com.yupi.home.panikerapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.yupi.home.panikerapp.R;
import com.yupi.home.panikerapp.ui.MainActivity;
import com.yupi.home.panikerapp.utils.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecipientFragment extends Fragment {

    @BindView(R.id.rootLayout)
    FrameLayout frameLayout;
    @BindView(R.id.topic)
    TextView topic;
    @BindView(R.id.returnBack)
    ImageView returnBack;

    public RecipientFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.default_recipients_layout, container, false);
        ButterKnife.bind(this, view);
        getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        topic.setText("Recipient");
        return view;
    }
    @OnClick(R.id.returnBack)
    public void setReturnBack(View view){
        //removeFragment(RecipientFragment.this).commit();
        Log.d("PopUp", String.valueOf(getFragmentManager().getBackStackEntryCount()));
        transaction().replace(R.id.root_frameLayout, new PanicFragment()).commit();
        ///clearBackStack();
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
    private void clearBackStack(){
        FragmentManager.BackStackEntry entry =
                getFragmentManager().getBackStackEntryAt(getFragmentManager().getBackStackEntryCount());
        getFragmentManager().popBackStack(entry.getId(), FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }
}
