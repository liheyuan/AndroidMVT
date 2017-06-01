package com.coder4.amvt.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.coder4.amvt.R;

/**
 * Created by coder4 on 2017/6/1.
 */

public abstract class StaticBaseFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        parentView = inflater.inflate(R.layout.fragment_staticbase, container, false);
        inflateHeader();
        renderBody();
        setupView(inflater, savedInstanceState);
        this.inflater = inflater;
        return parentView;
    }

    @Override
    protected void initLoad() {

    }
}
