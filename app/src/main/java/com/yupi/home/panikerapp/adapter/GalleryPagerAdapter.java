package com.yupi.home.panikerapp.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;

import com.yupi.home.panikerapp.fragments.GalleryFragment;
import com.yupi.home.panikerapp.fragments.RecordVideoFragment;
import com.yupi.home.panikerapp.fragments.TakePhotoFragment;

/**
 * Created by Home on 19.8.2017..
 */

public class GalleryPagerAdapter extends FragmentPagerAdapter {

    private final int PAGER_COUNT = 3;
    private final int GALLERY = 0;
    private final int TAKE_PHOTO = 1;
    private final int RECORD_VIDEO = 2;

    Resources resources;
    Context context;

    public GalleryPagerAdapter(FragmentManager fragmentManager, Resources resources, Context context)
    {
        super(fragmentManager);
        this.resources = resources;
        this.context = context;
    }
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case GALLERY:
                return new GalleryFragment();
            case TAKE_PHOTO:
                return new TakePhotoFragment();
            case RECORD_VIDEO:
                return new RecordVideoFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return PAGER_COUNT;
    }
}
