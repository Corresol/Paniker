package com.yupi.home.panikerapp.fragments;


import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yupi.home.panikerapp.R;
import com.yupi.home.panikerapp.ui.FriendsFragment;
import com.yupi.home.panikerapp.ui.MainActivity;
import com.yupi.home.panikerapp.utils.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class PanicFragment extends Fragment {

    @BindView(R.id.comments)
    ImageView comments;
    @BindView(R.id.documents)
    ImageView documents;
    @BindView(R.id.manageCamera)
    ImageView goLive;
    @BindView(R.id.goLiveImage)
    ImageView goLiveImage;
    @BindView(R.id.commentsLayout)
    LinearLayout commentsLayout;
    @BindView(R.id.docsLayout)
    LinearLayout docsLayout;
    @BindView(R.id.appBar)
    View appBar;
    @BindView(R.id.bottomNavigation)
    View bottomNav;
    @BindView(R.id.viewProfile)
    LinearLayout viewProfile;
    @BindView(R.id.frameLayout)
    FrameLayout mainLayout;

    int actionBarSize;
    public PanicFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        actionBarSize = android.R.attr.actionBarSize;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.paniker_live_layout, container, false);
        getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick({R.id.comments, R.id.documents, R.id.goLiveImage, R.id.selectRecipient,
            R.id.viewProfile, R.id.closeComments, R.id.closeDocuments, R.id.returnHome,
            R.id.sendMsg, R.id.main_button, R.id.settings, R.id.addPage, R.id.manageCamera})
    public void setVisibility(View view) {
        switch (view.getId()) {
            case R.id.comments:
                if (docsLayout.getVisibility() == View.VISIBLE)
                    docsLayout.setVisibility(View.GONE);
                if (documents.getVisibility() == View.INVISIBLE)
                    documents.setVisibility(View.VISIBLE);
                commentsLayout.setVisibility(View.VISIBLE);
                comments.setVisibility(View.INVISIBLE);
                break;
            case R.id.documents:
                if (commentsLayout.getVisibility() == View.VISIBLE)
                    commentsLayout.setVisibility(View.GONE);
                if (comments.getVisibility() == View.INVISIBLE)
                    comments.setVisibility(View.VISIBLE);
                docsLayout.setVisibility(View.VISIBLE);
                documents.setVisibility(View.INVISIBLE);
                break;
            case R.id.goLiveImage:
                if (goLiveImage.getVisibility() == View.INVISIBLE)
                    goLiveImage.setVisibility(View.VISIBLE);
                else
                    goLiveImage.setVisibility(View.INVISIBLE);
                break;
            case R.id.selectRecipient:
                removeFragment(PanicFragment.this).commit();
                transaction().replace(R.id.root_frameLayout, new RecipientFragment())
                        .addToBackStack(Constants.backStack).commit();
                break;
            case R.id.returnHome:
                transaction().remove(PanicFragment.this).commit();
                clearFlags();
                break;
            case R.id.sendMsg:
                removeFragment(PanicFragment.this).commit();
                transaction().replace(R.id.root_frameLayout, new FriendsFragment())
                        .addToBackStack(Constants.backStack).commit();
                break;
            case R.id.settings:
             //   removeFragment(PanicFragment.this).commit();
              //TODO problem with toolbar and bottom nav bar
                SettingsFragment settingsFragment = new SettingsFragment();
                Bundle bundle = new Bundle();
                bundle.putString(Constants.toolbarMsg, Constants.toolbarMsg);
                settingsFragment.setArguments(bundle);
                transaction().add(R.id.root_frameLayout, settingsFragment)
                        .addToBackStack(Constants.backStack).commit();
                break;
            case R.id.addPage:
                removeFragment(PanicFragment.this).commit();
                transaction().replace(R.id.root_frameLayout, new AddPageFragment())
                        .addToBackStack(Constants.backStack)
                        .commit();
                break;
            case R.id.manageCamera:
                builder().show();
                break;
            case R.id.closeComments:
                commentsLayout.setVisibility(View.GONE);
                comments.setVisibility(View.VISIBLE);
                break;
            case R.id.closeDocuments:
                docsLayout.setVisibility(View.GONE);
                documents.setVisibility(View.VISIBLE);
                break;
        }
    }
    private Dialog builder(){
        Dialog builder = new Dialog(getActivity());
        View view = getActivity().getLayoutInflater().inflate(R.layout.manage_camera_dialog_layout, null);
        builder.requestWindowFeature(Window.FEATURE_NO_TITLE);
        builder.getWindow().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.transparent_blac)));
        builder.setContentView(view);
        return  builder;
    }

    private FragmentTransaction transaction() {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        return fragmentTransaction;
    }
    private FragmentTransaction removeFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.remove(fragment);
        return fragmentTransaction;
    }

    @Override
    public void onStart() {
        super.onStart();
        getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Bundle bundle = getArguments();
        if(bundle != null)
            goLiveImage.setVisibility(View.VISIBLE);
    }

    @Override
    public void onResume() {
        super.onResume();
        Bundle bundle = getArguments();
        if(bundle != null)
            goLiveImage.setVisibility(View.VISIBLE);
    }
    private void clearFlags(){
        getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
    private int getBackStackCount(){
        return getFragmentManager().getBackStackEntryCount();
    }
}
