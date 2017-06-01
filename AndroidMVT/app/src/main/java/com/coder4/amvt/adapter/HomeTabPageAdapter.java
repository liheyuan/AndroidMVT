package com.coder4.amvt.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.coder4.amvt.agent.UserAgent;
import com.coder4.amvt.fragment.HomeTabFragment;
import com.coder4.amvt.fragment.LoginFragment;
import com.coder4.amvt.fragment.MyTabFragment;
import com.coder4.amvt.fragment.YourTabFragment;

/**
 * Created by coder4 on 2017/5/10.
 */

public class HomeTabPageAdapter extends FragmentStatePagerAdapter {
    final int PAGE_COUNT = 3;
    private String tabTitles[] = new String[]{"Home", "My Tab", "Your Tab"};

    public HomeTabPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return HomeTabFragment.newInstance(position + 1);
        } else {
            if (UserAgent.get().isLogin()) {
                switch (position) {
                    case 1:
                        return MyTabFragment.newInstance();
                    case 2:
                        return YourTabFragment.newInstance();
                    default:
                        return HomeTabFragment.newInstance(position + 1);
                }
            } else {
                return LoginFragment.newInstance();
            }
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

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }
}
