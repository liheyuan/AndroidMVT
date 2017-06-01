package com.coder4.amvt.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.coder4.amvt.R;
import com.coder4.amvt.activity.ReusingActivity;
import com.coder4.amvt.util.KeyboardUtil;
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

    protected void launch(Class<? extends Fragment> fragmentClass) {
        launch(fragmentClass, null, 0);
    }

    protected void launch(Class<? extends Fragment> fragmentClass,
                       @Nullable Bundle fragmentArgs,
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

    protected void finish(int resultCode, @Nullable Intent data) {
        if (getActivity() != null && data != null) {
            getActivity().setResult(resultCode, data);
        }
        finish();
    }

    protected void finish(int resultCode) {
        finish(resultCode, null);
    }

    protected void finish() {
        if (getActivity() != null) {
            getActivity().finish();
        }
        /*
        if (launchModeIsModuleCheck...) {
            overridePendingTransition(module_in, module_out);
        } else {
            overridePendingTransition(push_in, push_out);
        }
        */
    }

    protected void hideKeyboard(View view) {
        KeyboardUtil.hideSoftKeyboard(getActivity(), view);
    }

    protected void enableKeyboardAdjustPan() {
        Activity activity = getActivity();
        if (activity == null) {
            return ;
        }

        activity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
    }
}
