package com.yupi.home.panikerapp.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.yupi.home.panikerapp.fragments.CameraFragment;
import com.yupi.home.panikerapp.fragments.MainFragment;
import com.yupi.home.panikerapp.fragments.MultiMediaFragment;
import com.yupi.home.panikerapp.fragments.OwnerProfileFragment;
import com.yupi.home.panikerapp.fragments.RecordVideoFragment;
import com.yupi.home.panikerapp.fragments.SearchFragment;
import com.yupi.home.panikerapp.fragments.TakePhotoFragment;

/**
 * Created by Home on 24.8.2017..
 */

public class SwipeMainPager extends FragmentStatePagerAdapter {
    private final int PAGER_COUNTER = 4;
    private final int CAMERA = 0;
    private final int MAIN_PAGE = 1;
    private final int SEARCH = 2;
    private final int PROFILE = 3;
    private Resources resources;
    private Context context;

    public SwipeMainPager(FragmentManager fm, Resources resources, Context context){
        super(fm);
        this.resources = resources;
        this.context = context;
    }
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case MAIN_PAGE:
                return new MainFragment();
            case CAMERA:
                return new MultiMediaFragment();
            case SEARCH:
                return new SearchFragment();
            case PROFILE:
                return new OwnerProfileFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return PAGER_COUNTER;
    }
}
