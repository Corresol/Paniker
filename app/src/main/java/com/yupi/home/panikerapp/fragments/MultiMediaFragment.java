package com.yupi.home.panikerapp.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.yupi.home.panikerapp.R;
import com.yupi.home.panikerapp.adapter.GalleryPagerAdapter;
import com.yupi.home.panikerapp.ui.MainActivity;
import com.yupi.home.panikerapp.utils.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class MultiMediaFragment extends Fragment {


    @BindView(R.id.gallery)
    ImageView gallery;
    @BindView(R.id.takePhoto)
    ImageView takePhoto;
    @BindView(R.id.recordVideo)
    ImageView recordVideo;
    @BindView(R.id.viewpager)
    public ViewPager viewPager;

    public MultiMediaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.multi_media_layout, container, false);
        ButterKnife.bind(this, view);
        setupViewPager(view);
        return view;
    }

    @OnClick({R.id.gallery, R.id.takePhoto, R.id.recordVideo,
            R.id.skipToText, R.id.next})
    public void setClicks(View view){
        switch (view.getId()){
            case R.id.gallery:
                viewPager.setCurrentItem(0);
                gallery.setAlpha(1.0f);
                takePhoto.setAlpha(0.5f);
                recordVideo.setAlpha(0.5f);
                break;
            case R.id.takePhoto:
                gallery.setAlpha(0.5f);
                takePhoto.setAlpha(1.0f);
                recordVideo.setAlpha(0.5f);
                viewPager.setCurrentItem(1);
                break;
            case R.id.recordVideo:
                gallery.setAlpha(0.5f);
                takePhoto.setAlpha(0.5f);
                recordVideo.setAlpha(1.0f);
                viewPager.setCurrentItem(2);
                break;
            case R.id.skipToText:
                ShareImageFragment shareImageFragment = new ShareImageFragment();
                Bundle bundle = new Bundle();
                bundle.putString(Constants.toolbarMsg, Constants.toolbarMsg);
                shareImageFragment.setArguments(bundle);
                transaction(R.id.rootLayout, shareImageFragment).commit();
                break;
            case R.id.next:
                transaction(R.id.rootLayout, new EditImagesFragment()).commit();
                break;
        }
    }
    private void setupViewPager(View view){
        viewPager = (ViewPager)view.findViewById(R.id.viewpager);
        GalleryPagerAdapter pagerAdapter = new GalleryPagerAdapter(getChildFragmentManager(), getResources(), getActivity());
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        gallery.setAlpha(1.0f);
                        takePhoto.setAlpha(0.5f);
                        recordVideo.setAlpha(0.5f);
                        break;
                    case 1:
                        gallery.setAlpha(0.5f);
                        takePhoto.setAlpha(1.0f);
                        recordVideo.setAlpha(0.5f);
                        break;
                    case 2:
                        gallery.setAlpha(0.5f);
                        takePhoto.setAlpha(0.5f);
                        recordVideo.setAlpha(1.0f);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    private FragmentTransaction transaction(int id, Fragment fragment) {
        FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
        fragmentTransaction.replace(id, fragment);
        return fragmentTransaction;
    }
}
