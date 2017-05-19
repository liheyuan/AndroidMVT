package com.coder4.amvt.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import com.coder4.amvt.R;
import com.coder4.amvt.util.ReusingActivityFragmentUtil;

/**
 * Created by coder4 on 2017/5/18.
 */

public class ReusingActivity extends FragmentActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_reusing);

        ReusingActivityFragmentUtil.loadFragment(getIntent(), this);
    }
}
