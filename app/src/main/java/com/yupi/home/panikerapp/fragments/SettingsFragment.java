package com.yupi.home.panikerapp.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.yupi.home.panikerapp.R;
import com.yupi.home.panikerapp.ui.DefaultRecipientsActivity;
import com.yupi.home.panikerapp.ui.MainActivity;
import com.yupi.home.panikerapp.ui.WaitTimeActivity;
import com.yupi.home.panikerapp.utils.Constants;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsFragment extends Fragment {
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
    @BindView(R.id.newsFeed)
    RelativeLayout newsFeed;
    private ArrayList<String> languages;
    private ListView listView;
    String getBundle;
    public SettingsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.settings_layout, container, false);
     /*   if(getArguments() != null)
        getBundle = getArguments().getString(Constants.toolbarMsg);
        if(getBundle != null){
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams
                    (ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            int i = ((MainActivity)getActivity()).getSupportActionBar().getHeight();
            layoutParams.setMargins(0,i,0,i);
            FrameLayout frameLayout = (FrameLayout)view.findViewById(R.id.rootLayout);
            frameLayout.setLayoutParams(layoutParams);
        }*/
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick({R.id.generalSettings, R.id.videosSettings, R.id.cameraSettings,
            R.id.securitySettings, R.id.accountType, R.id.returnBack,
            R.id.waitTime, R.id.defaultRecipients, R.id.newsFeedLayout,
            R.id.password_linearLayout, R.id.camera_linearLayout,
    R.id.languageLayout, R.id.blockedUsersLayout})
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
            case R.id.newsFeedLayout:
                if(newsFeed.getVisibility() == View.GONE)
                    newsFeed.setVisibility(View.VISIBLE);
                else
                    newsFeed.setVisibility(View.GONE);
                break;
            case R.id.waitTime:
                startActivity(new Intent(getActivity(), WaitTimeActivity.class));
                break;
            case R.id.defaultRecipients:
             //   transaction(R.id.rootLayout, new RecipientFragment()).addToBackStack(Constants.backStack).commit();
                break;
            case R.id.returnBack:
               FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.remove(SettingsFragment.this).commit();
             //   transaction(R.id.root_frameLayout, new PanicFragment()).commit();
                break;
            case R.id.password_linearLayout:
                transaction(R.id.rootLayout, new ChangePasswordFragment()).addToBackStack(Constants.backStack).commit();
                break;
            case R.id.camera_linearLayout:
                transaction(R.id.rootLayout, new BluetoothFragment()).addToBackStack(Constants.backStack).commit();
                break;
            case R.id.languageLayout:
               setupDialog().show();
                break;
            case R.id.blockedUsersLayout:
                transaction(R.id.rootLayout, new BlockedUsersFragment()).addToBackStack(Constants.backStack).commit();
                break;
        }
    }
    private FragmentTransaction transaction(int id, Fragment fragment){
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(id, fragment);
        return fragmentTransaction;
    }

    @Override
    public void onResume() {
        super.onResume();
        if(getArguments() != null)
            getBundle = getArguments().getString(Constants.toolbarMsg);
    }

    @Override
    public void onStart() {
        super.onStart();
        if(getArguments() != null)
            getBundle = getArguments().getString(Constants.toolbarMsg);
    }
    private AlertDialog.Builder setupDialog() {
        languages = new ArrayList<>();
        languages.add("English");
        languages.add("German");
        languages.add("French");
        languages.add("Italian");
        languages.add("Spanish");
        languages.add("Chinese");
        languages.add("Portuguese");
        languages.add("Polish");
        languages.add("Romanian");
        View view = getActivity().getLayoutInflater().inflate(R.layout.dialogs_layout, null);
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
        alertDialog.setView(view);
        listView = (ListView)view.findViewById(R.id.listView);
        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, languages);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String language = languages.get(position);
               // selectedLanguage.setText(language);
                AlertDialog alertDialog1 = alertDialog.create();
                alertDialog1.dismiss();
            }
        });
        return alertDialog;
    }
}
