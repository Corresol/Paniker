package com.yupi.home.panikerapp.fragments;


import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yupi.home.panikerapp.R;
import com.yupi.home.panikerapp.adapter.GalleryAdapter;
import com.yupi.home.panikerapp.ui.MainActivity;
import com.yupi.home.panikerapp.ui.MessagesActivity;
import com.yupi.home.panikerapp.ui.PhoneCallActivity;
import com.yupi.home.panikerapp.ui.VideoCallActivity;
import com.yupi.home.panikerapp.utils.Constants;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserProfileFragment extends Fragment {

    @BindView(R.id.profileImage)
    ImageView userProfileImage;
    @BindView(R.id.returnBack)
    ImageView returnBack;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.userFragment)
    FrameLayout frameLayout;
    @BindView(R.id.getName)
    TextView getName;
    ArrayList<Integer> integers;
    GalleryAdapter galleryAdapter;

    public UserProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.user_profile_layout, container, false);
        ButterKnife.bind(this, view);
        setupAdapter();
        return view;
    }

    @OnClick({R.id.returnBack, R.id.phoneCall, R.id.sendAudioMessage, R.id.videoCall, R.id.sendMsg})
    public void setOnClicks(View view) {
        switch (view.getId()){
            case R.id.returnBack:
                removeFragments(UserProfileFragment.this).commit();
               /* Intent intent2 = new Intent(getActivity(), MainActivity.class);
                intent2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent2);*/
                break;
            case R.id.phoneCall:
                getActivity().startActivity(new Intent(getActivity(), PhoneCallActivity.class));
                break;
            case R.id.sendAudioMessage:
                recordAudio().show();
                break;
            case R.id.sendMsg:
                Intent intent = new Intent(getActivity(), MessagesActivity.class);
                intent.putExtra(Constants.sendMsg, getName.getText().toString());
                startActivity(intent);
                break;
            case R.id.videoCall:
                getActivity().startActivity(new Intent(getActivity(), VideoCallActivity.class));
                break;
        }
        // transaction.commit();
        //  ((MainActivity)getActivity()).viewPager.setCurrentItem(1);
    }

    private void setupAdapter() {
        integers = new ArrayList<>();
        integers.add(1);
        integers.add(3);
        integers.add(5);
        integers.add(1);
        integers.add(3);
        integers.add(5);
        integers.add(1);
        integers.add(3);
        integers.add(5);
        integers.add(1);
        integers.add(3);
        integers.add(5);
        integers.add(5);
        integers.add(1);
        integers.add(3);
        integers.add(5);
        integers.add(1);
        integers.add(3);
        integers.add(5);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        recyclerView.hasFixedSize();
        recyclerView.setNestedScrollingEnabled(false);
        galleryAdapter = new GalleryAdapter(getActivity(), integers, new GalleryAdapter.ImageClicks() {
            @Override
            public void markImage(View view, ImageView imageView, int position) {

            }
        });
        recyclerView.setAdapter(galleryAdapter);
    }
    private AlertDialog.Builder recordAudio(){
        View view = getActivity().getLayoutInflater().inflate(R.layout.record_an_audio_layout, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(view);
        return builder;
    }
    @Override
    public void onStart() {
        super.onStart();
        Bundle bundle = getArguments();
        if (bundle != null) {
            userProfileImage.setImageResource(bundle.getInt(Constants.profileImageKey));
            getName.setText(bundle.getString(Constants.profileNameKey));
        }
    }
    private FragmentTransaction removeFragments(Fragment fragment){
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.remove(fragment);
        return fragmentTransaction;
    }
}
