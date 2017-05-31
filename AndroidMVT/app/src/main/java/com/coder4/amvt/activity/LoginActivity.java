package com.coder4.amvt.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.coder4.amvt.R;
import com.coder4.amvt.agent.UserAgent;
import com.coder4.amvt.constant.BusEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by coder4 on 2017/5/22.
 */

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.tvLoginUser)
    EditText tvUser;
    @BindView(R.id.tvLoginPass)
    EditText tvPass;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EventBus.getDefault().register(this);

        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnLogin)
    public void onClickLogin() {
        String user = tvUser.getText().toString();
        String pass = tvPass.getText().toString();
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
