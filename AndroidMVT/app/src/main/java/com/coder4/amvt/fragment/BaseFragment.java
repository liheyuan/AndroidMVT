package com.coder4.amvt.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.coder4.amvt.R;
import com.coder4.amvt.activity.ReusingActivity;
import com.coder4.amvt.util.ReusingActivityFragmentUtil;

import butterknife.ButterKnife;

/**
 * Created by coder4 on 2017/5/18.
 */

public abstract class BaseFragment extends Fragment {

    protected View parentView;
    protected LayoutInflater inflater;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        parentView = inflater.inflate(getResourceLayoutId(), container, false);
        ButterKnife.bind(this, parentView);
        this.inflater = inflater;
        setupView(inflater, parentView, savedInstanceState);
        return parentView;
    }

    protected abstract int getResourceLayoutId();

    protected void setupView(LayoutInflater inflater, View view,
                             Bundle savedInstanceState) {

    }

    public void launch(Class<? extends Fragment> fragmentClass,
                       Bundle fragmentArgs,
                       int reqCode) {
        Activity activity = getActivity();
        if (activity == null) {
            return;
        }

        Intent intent = new Intent(activity, ReusingActivity.class);
        ReusingActivityFragmentUtil.saveReqFragment(intent,
                fragmentClass,
                R.id.fragment_container,
                fragmentArgs);
        if (reqCode != 0) {
            startActivityForResult(intent, reqCode);
        } else {
            startActivity(intent);
        }
    }
}
