package com.yupi.home.panikerapp.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.yupi.home.panikerapp.fragments.GalleryFragment;
import com.yupi.home.panikerapp.fragments.PeopleFragment;
import com.yupi.home.panikerapp.fragments.PlacesFragment;
import com.yupi.home.panikerapp.fragments.RecordVideoFragment;
import com.yupi.home.panikerapp.fragments.TagsFragment;
import com.yupi.home.panikerapp.fragments.TakePhotoFragment;
import com.yupi.home.panikerapp.fragments.TopFragment;

/**
 * Created by Home on 20.8.2017..
 */

public class SearchPagerAdapter extends FragmentPagerAdapter {
    Resources resources;
    Context context;
    private final int PAGER_COUNTER = 4;
    private final int TOP = 0;
    private final int PEOPLE = 1;
    private final int PLACES = 2;
    private final int TAGS = 3;

    public SearchPagerAdapter(FragmentManager fragmentManager, Resources resources, Context context){
        super(fragmentManager);
        this.resources = resources;
        this.context = context;
    }
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case TOP:
                return new TopFragment();
            case PEOPLE:
                return new PeopleFragment();
            case PLACES:
                return new PlacesFragment();
            case TAGS:
                return new TagsFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return PAGER_COUNTER;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case TOP:
                return "Top";
            case PEOPLE:
                return "People";
            case PLACES:
                return "Places";
            case TAGS:
                return "Tags";
        }
        return super.getPageTitle(position);
    }
}
