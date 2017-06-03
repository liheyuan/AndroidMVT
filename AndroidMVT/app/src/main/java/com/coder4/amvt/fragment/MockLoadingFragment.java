package com.coder4.amvt.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;

import com.coder4.amvt.R;
import com.coder4.amvt.activity.LoginCheckActivity;

import butterknife.OnClick;

/**
 * Created by coder4 on 2017/5/10.
 */

public class MockLoadingFragment extends BaseFragment {

    private int cnt = 0;

    @Override
    protected void setupView(LayoutInflater inflater, @Nullable Bundle savedInstanceState) {
        super.setupView(inflater, savedInstanceState);
        initLoad();
        setTitle("Mock Loading Demo");
    }

    @Override
    protected int getBodyLayoutResourceId() {
        return R.layout.fragment_mockloading;
    }

    @Override
    protected void initLoad() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                cnt++;
                if (cnt < 3) {
                    renderLoadError();
                } else {
                    renderBody();
                }
            }
        }, 1000);
    }

    @Override
    protected int getHeaderLayoutResourceId() {
        return R.layout.include_toolbar;
    }

}
