package com.yupi.home.panikerapp.fragments;


import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.yupi.home.panikerapp.R;
import com.yupi.home.panikerapp.adapter.GalleryAdapter;
import com.yupi.home.panikerapp.ui.FriendsFragment;
import com.yupi.home.panikerapp.ui.MainActivity;
import com.yupi.home.panikerapp.utils.Constants;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class OwnerProfileFragment extends Fragment {

    @BindView(R.id.returnBack)
    ImageView returnBack;
    @BindView(R.id.profileToolbarName)
    TextView name;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    ArrayList<Integer> integers;
    GalleryAdapter galleryAdapter;
    public OwnerProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_owner_profile, container, false);
        ButterKnife.bind(this, view);
        setupAdapter();
        return view;
    }
    @OnClick({R.id.returnBack, R.id.editProfile,
            R.id.openSettings, R.id.friendRequest,
            R.id.friends, R.id.addFriend,
            R.id.inviteFriend})
    public void setReturnBack(View view){
        switch (view.getId()){
            case R.id.returnBack:
                Intent intent = new Intent(getActivity(), MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                break;
            case R.id.editProfile:
                transaction(R.id.rootLayout, new OwnerProfileEditFragment())
                        .addToBackStack(Constants.backStack).commit();
                break;
            case R.id.openSettings:
                transaction(R.id.rootLayout, new SettingsFragment())
                        .addToBackStack(Constants.backStack).commit();
                break;
            case R.id.friendRequest:
                transaction(R.id.rootLayout, new FriendReqFragment())
                        .addToBackStack(Constants.backStack).commit();
                break;
            case R.id.friends:
                transaction(R.id.rootLayout, new FriendReqSearchFragment())
                        .addToBackStack(Constants.backStack).commit();
                break;
            case R.id.addFriend:
                transaction(R.id.rootLayout, new AddFriendFragment())
                        .addToBackStack(Constants.backStack).commit();
                break;
            case R.id.inviteFriend:
                transaction(R.id.rootLayout, new InviteFriendFragment())
                        .addToBackStack(Constants.backStack).commit();
                break;
        }
    }
    private void setupAdapter(){
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
        integers.add(5);
        integers.add(1);
        integers.add(3);
        integers.add(5);
        integers.add(5);
        integers.add(1);
        integers.add(3);
        integers.add(5);
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
    private FragmentTransaction transaction(int id, Fragment fragment){
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(id, fragment);
        return fragmentTransaction;
    }
    private FragmentTransaction removeFragment(Fragment fragment){
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.remove(fragment);
        return transaction;
    }
}
