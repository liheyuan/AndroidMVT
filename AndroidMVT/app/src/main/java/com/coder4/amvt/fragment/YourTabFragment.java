package com.coder4.amvt.fragment;

import com.coder4.amvt.R;

/**
 * Created by coder4 on 2017/5/31.
 */

public class YourTabFragment extends StaticBaseFragment {

    public static YourTabFragment newInstance() {
        YourTabFragment fragment = new YourTabFragment();
        return fragment;
    }

    @Override
    protected int getHeaderLayoutResourceId() {
        return 0;
    }

    @Override
    protected int getBodyLayoutResourceId() {
        return R.layout.fragment_yourtab;
    }

}
