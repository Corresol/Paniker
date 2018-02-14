package com.yupi.home.panikerapp.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.yupi.home.panikerapp.R;
import com.yupi.home.panikerapp.ui.DefaultRecipientsActivity;
import com.yupi.home.panikerapp.ui.WaitTimeActivity;
import com.yupi.home.panikerapp.utils.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsPanicFragment extends Fragment {
    @BindView(R.id.generalProfileLayoutDetails)
    RelativeLayout generalSettings;
    @BindView(R.id.videos_settingsLayout)
    RelativeLayout videoSettingsLayout;
    @BindView(R.id.camera_management_layout)
    RelativeLayout cameraManagement;
    @BindView(R.id.securitySettingsLayout)
    RelativeLayout securitySettingsLayout;
    @BindView(R.id.lawEnforcementLayout)
    RelativeLayout lawEnforcementLayout;
    @BindView(R.id.generalSettings)
    ImageView openGeneralSettings;
    @BindView(R.id.videosSettings)
    ImageView openVideoSettings;
    @BindView(R.id.cameraSettings)
    ImageView openCameraSettings;
    @BindView(R.id.securitySettings)
    ImageView securitySettings;
    @BindView(R.id.accountType)
    ImageView accountType;
    @BindView(R.id.rootLayout)
    FrameLayout frameLayout;
    public SettingsPanicFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings_panic_layout, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick({R.id.generalSettings, R.id.videosSettings, R.id.cameraSettings,
            R.id.securitySettings, R.id.accountType, R.id.returnBack,
            R.id.waitTime, R.id.defaultRecipients})
    public void setOnClicks(View view) {
        switch (view.getId()) {
            case R.id.generalSettings:
                if(generalSettings.getVisibility() == View.GONE)
                    generalSettings.setVisibility(View.VISIBLE);
                else
                    generalSettings.setVisibility(View.GONE);
                break;
            case R.id.videosSettings:
                if(videoSettingsLayout.getVisibility() == View.GONE)
                    videoSettingsLayout.setVisibility(View.VISIBLE);
                else
                    videoSettingsLayout.setVisibility(View.GONE);
                break;
            case R.id.cameraSettings:
                if(cameraManagement.getVisibility() == View.GONE)
                    cameraManagement.setVisibility(View.VISIBLE);
                else
                    cameraManagement.setVisibility(View.GONE);
                break;
            case R.id.securitySettings:
                if(securitySettingsLayout.getVisibility() == View.GONE)
                    securitySettingsLayout.setVisibility(View.VISIBLE);
                else
                    securitySettingsLayout.setVisibility(View.GONE);
                break;
            case R.id.accountType:
                if(lawEnforcementLayout.getVisibility() == View.GONE)
                    lawEnforcementLayout.setVisibility(View.VISIBLE);
                else
                    lawEnforcementLayout.setVisibility(View.GONE);
                break;
            case R.id.waitTime:
                startActivity(new Intent(getActivity(), WaitTimeActivity.class));
                break;
            case R.id.defaultRecipients:
                startActivity(new Intent(getActivity(), DefaultRecipientsActivity.class));
                break;
            case R.id.returnBack:
                    FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                    fragmentTransaction.remove(SettingsPanicFragment.this).commit();
                    transaction(R.id.root_frameLayout, new PanicFragment()).commit();
                break;
        }
    }
    private FragmentTransaction transaction(int id, Fragment fragment){
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(id, fragment);
        return fragmentTransaction;
    }
    private FragmentTransaction addToBackStack(){
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.addToBackStack(Constants.backStack);
        return fragmentTransaction;
    }
    private int getBackStackCount(){
        return getFragmentManager().getBackStackEntryCount();
    }
}
