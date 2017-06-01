package com.coder4.amvt.fragment;

import android.widget.EditText;

import com.coder4.amvt.R;
import com.coder4.amvt.agent.UserAgent;

import butterknife.BindView;
import butterknife.OnClick;

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
    protected int getResourceLayoutId() {
        return R.layout.fragment_login;
    }

    @OnClick(R.id.btn_login)
    public void onClickLogin() {
        String user = etUser.getText().toString();
        String pass = etPass.getText().toString();
        UserAgent.get().login(user, pass);
    }
}
