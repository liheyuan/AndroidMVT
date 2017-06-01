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
    // cached fragment
    private Fragment loginFragment = LoginFragment.newInstance();
    private Fragment myTabFragment = MyTabFragment.newInstance();
    private Fragment yourTabFragment = YourTabFragment.newInstance();

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
                        return myTabFragment;
                    case 2:
                        return yourTabFragment;
                    default:
                        return HomeTabFragment.newInstance(position + 1);
                }
            } else {
                return loginFragment;
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
