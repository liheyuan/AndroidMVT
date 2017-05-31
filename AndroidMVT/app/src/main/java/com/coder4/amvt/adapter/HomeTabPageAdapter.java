package com.coder4.amvt.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.coder4.amvt.fragment.HomeTabFragment;
import com.coder4.amvt.fragment.MyTabFragment;

/**
 * Created by coder4 on 2017/5/10.
 */

public class HomeTabPageAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 3;
    private String tabTitles[] = new String[]{"Home", "My Tab", "Your Tab"};

    public HomeTabPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 1) {
            return MyTabFragment.newInstance();
        } else {
            return HomeTabFragment.newInstance(position + 1);
        }
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
