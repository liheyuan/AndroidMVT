package com.coder4.amvt.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.coder4.amvt.R;
import com.coder4.amvt.agent.UserAgent;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnFocusChange;

/**
 * Created by coder4 on 2017/6/1.
 */

public class LoginFragment extends BaseFragment {

    @BindView(R.id.et_login_user)
    EditText etUser;
    @BindView(R.id.et_login_pass)
    EditText etPass;

    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();
        return fragment;
    }

    @Override
    protected void setupView(LayoutInflater inflater, View view, Bundle savedInstanceState) {
        super.setupView(inflater, view, savedInstanceState);
        enableKeyboardAdjustPan();
    }

    @Override
    protected int getResourceLayoutId() {
        return R.layout.fragment_login;
    }

    @OnClick(R.id.btn_login)
    public void onClickLogin() {
        String user = etUser.getText().toString();
        String pass = etPass.getText().toString();
        UserAgent.get().login(user, pass);
    }

    @OnFocusChange({
            R.id.et_login_pass, R.id.et_login_user
    })
    public void onEditTextFocusChange(View view, boolean focused) {
        if (!focused) {
            hideKeyboard(view);
        }
    }
}
