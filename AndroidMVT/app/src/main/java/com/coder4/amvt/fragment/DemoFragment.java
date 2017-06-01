package com.coder4.amvt.fragment;

import com.coder4.amvt.R;

/**
 * Created by coder4 on 2017/5/19.
 */

public class DemoFragment extends BaseFragment {

    @Override
    protected int getHeaderLayoutResourceId() {
        return R.layout.include_toolbar;
    }

    @Override
    protected int getBodyLayoutResourceId() {
        return R.layout.fragment_demo;
    }

    @Override
    protected void initLoad() {

    }

}
