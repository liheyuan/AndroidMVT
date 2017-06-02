package com.coder4.amvt.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.WindowManager;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.coder4.amvt.R;
import com.coder4.amvt.activity.ReusingActivity;
import com.coder4.amvt.intf.ILoadingProgress;
import com.coder4.amvt.intf.IToast;
import com.coder4.amvt.util.KeyboardUtil;
import com.coder4.amvt.util.ReusingActivityFragmentUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by coder4 on 2017/5/18.
 */

public abstract class BaseFragment extends Fragment implements ILoadingProgress {

    protected View parentView;
    protected LayoutInflater inflater;
    protected @Nullable MaterialDialog loadingDialog = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        this.inflater = inflater;
        parentView = inflater.inflate(R.layout.fragment_base, container, false);
        inflateHeader();
        renderLoading();
        setupView(inflater, savedInstanceState);
        return parentView;
    }

    protected void inflateHeader() {
        inflateViewStub(R.id.vs_header, getHeaderLayoutResourceId());
    }

    private
    @Nullable
    View inflateViewStub(int id, int layoutId) {
        if (parentView == null) {
            return null;
        }

        View stub = findViewById(id);
        if (!(stub instanceof ViewStub)) {
            return null;
        }
        ViewStub viewStub = (ViewStub) stub;
        if (layoutId > 0) {
            viewStub.setLayoutResource(layoutId);
            View view = viewStub.inflate();
            viewStub.setVisibility(View.VISIBLE);
            return view;
        } else {
            debugLog("inflateViewStub layoutId is 0, hide it");
            viewStub.setVisibility(View.GONE);
            return null;
        }

    }

    /// SUBCLASS MAY OVERRIDE BEGIN

    protected abstract int getHeaderLayoutResourceId();

    protected abstract int getBodyLayoutResourceId();

    protected abstract void initLoad();

    protected void setupView(LayoutInflater inflater, @Nullable Bundle savedInstanceState) {

    }

    /// SUBCLASS MAY OVERRIDE END

    protected void renderBody() {
        View v = findViewById(R.id.lay_loading);
        if (v != null) {
            v.setVisibility(View.GONE);
        }
        inflateViewStub(R.id.vs_body, getBodyLayoutResourceId());
        ButterKnife.bind(this, parentView);
    }

    private void switchLoadingView(boolean errMode) {
        View vLoading = findViewById(R.id.pb_loading);
        if (vLoading != null) {
            vLoading.setVisibility(errMode ? View.GONE : View.VISIBLE);
        }
        View vFail = findViewById(R.id.lay_fail);
        if (vFail != null) {
            vFail.setVisibility(errMode ? View.VISIBLE : View.GONE);
        }
    }

    private void renderLoading() {
        View stub = findViewById(R.id.vs_loading);
        if (stub instanceof ViewStub) {
            ((ViewStub) stub).inflate();
        }

        switchLoadingView(false);

        View vFail = findViewById(R.id.lay_fail);
        if (vFail != null) {
            vFail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switchLoadingView(false);
                    initLoad();
                }
            });
        }
    }

    protected void renderLoadError() {
        switchLoadingView(true);
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
            return;
        }

        activity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
    }

    protected void toast(String msg) {
        if (msg == null) {
            return ;
        }
        Activity activity = getActivity();
        if (activity != null && activity instanceof IToast) {
            ((IToast) activity).toast(msg);
        }
    }

    protected void debugLog(String msg) {
        Log.d(getClass().getSimpleName(), msg);
    }

    protected void setTitle(String title) {
        TextView tvTitle = (TextView)findViewById(R.id.tv_toolbar_title);
        if (tvTitle != null) {
            tvTitle.setText(title);
        }
    }

    protected
    @Nullable
    View findViewById(int id) {
        if (parentView == null) {
            return null;
        }
        return parentView.findViewById(id);
    }

    public void showLoadingDialog(String msg) {
        dismissLoadingDialog();
        Activity activity = getActivity();
        if (activity == null) {
            return ;
        }
        loadingDialog = new MaterialDialog
                .Builder(activity)
                .content(msg)
                .progress(true, 0)
                .widgetColorRes(R.color.colorPrimary)
                .cancelable(false)
                .show();
    }

    public void dismissLoadingDialog() {
        if (loadingDialog != null) {
            loadingDialog.dismiss();
            loadingDialog = null;
        }
    }
}
