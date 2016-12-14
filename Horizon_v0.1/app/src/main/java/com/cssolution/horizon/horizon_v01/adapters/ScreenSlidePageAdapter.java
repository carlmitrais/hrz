package com.cssolution.horizon.horizon_v01.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.cssolution.horizon.horizon_v01.fragments.ScreenSlidePageFragment;

/**
 * Created by Mohammad_T on 12/14/2016.
 */
public class ScreenSlidePageAdapter extends FragmentStatePagerAdapter {

    private int pageNumber;

    public ScreenSlidePageAdapter(FragmentManager fm){
        super(fm);
    }

    public ScreenSlidePageAdapter(FragmentManager fm, int numPage){
        super(fm);
        pageNumber = numPage;
    }

    @Override
    public Fragment getItem(int position) {
        return ScreenSlidePageFragment.create(position);
    }

    @Override
    public int getCount() {
        return pageNumber;
    }
}
