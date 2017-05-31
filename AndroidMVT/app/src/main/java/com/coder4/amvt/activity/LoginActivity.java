package com.coder4.amvt.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.EditText;

import com.coder4.amvt.R;
import com.coder4.amvt.agent.UserAgent;
import com.coder4.amvt.constant.BusEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by coder4 on 2017/5/22.
 */

public class LoginActivity extends BaseActivity {

    @BindView(R.id.et_login_user)
    EditText etUser;
    @BindView(R.id.et_login_pass)
    EditText etPass;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
        setTitle("Login");
    }

    @Override
    protected int getResourceLayoutId() {
        return R.layout.activity_login;
    }

    @OnClick(R.id.btn_login)
    public void onClickLogin() {
        String user = etUser.getText().toString();
        String pass = etPass.getText().toString();
        UserAgent.get().login(user, pass);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onLoginSucc(BusEvent.LoginSuccEvent event) {
        setResult(RESULT_OK);
        finish();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onLoginFail(BusEvent.LoginFailEvent event) {

    }

}
