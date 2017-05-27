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

/**
 * Created by coder4 on 2017/5/22.
 */

public class LoginActivity extends AppCompatActivity {

    private EditText tvUser;
    private EditText tvPass;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EventBus.getDefault().register(this);

        setContentView(R.layout.activity_login);

        Button btn = (Button)findViewById(R.id.btnLogin);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // fake now, so must success
                String user = tvUser.getText().toString();
                String pass = tvPass.getText().toString();
                UserAgent.get().login(user, pass);
            }
        });

        tvUser = (EditText)findViewById(R.id.tvLoginUser);
        tvPass = (EditText)findViewById(R.id.tvLoginPass);
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
