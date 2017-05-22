package com.coder4.amvt.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.coder4.amvt.agent.LoginAgent;


/**
 * Created by coder4 on 2017/5/22.
 */

public class LoginCheckActivity extends AppCompatActivity {

    public interface LoginCheckCallback {
        void onLogin();
    }

    private static int REQUEST_CODE_LOGIN = 1;
    private static LoginCheckCallback callback = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(this, LoginActivity.class);
        startActivityForResult(intent, LoginCheckActivity.REQUEST_CODE_LOGIN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        finish();

        if (requestCode == REQUEST_CODE_LOGIN && resultCode == RESULT_OK && callback != null) {
            callback.onLogin();
        }

        callback = null;
    }

    public static void checkLogin(@NonNull Context content, @NonNull LoginCheckCallback cb) {
        if (LoginAgent.shared.isLogin()) {
            cb.onLogin();
        } else {
            callback = cb;
            Intent intent = new Intent(content, LoginCheckActivity.class);
            content.startActivity(intent);
        }
    }
}
