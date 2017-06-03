package com.coder4.amvt.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;

import com.coder4.amvt.R;

/**
 * Created by coder4 on 2017/5/19.
 */

public class DemoFragment extends StaticBaseFragment {

    @Override
    protected void setupView(LayoutInflater inflater, @Nullable Bundle savedInstanceState) {
        super.setupView(inflater, savedInstanceState);
        setTitle("Demo");
    }

    @Override
    protected int getHeaderLayoutResourceId() {
        return R.layout.include_toolbar;
    }

    @Override
    protected int getBodyLayoutResourceId() {
        return R.layout.fragment_demo;
    }


}
