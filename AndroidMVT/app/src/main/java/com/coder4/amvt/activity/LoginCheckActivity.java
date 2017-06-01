package com.coder4.amvt.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.coder4.amvt.R;
import com.coder4.amvt.agent.UserAgent;


/**
 * Created by coder4 on 2017/5/22.
 */

public class LoginCheckActivity extends BaseActivity {

    private static int REQUEST_CODE_LOGIN = 1;
    private static Class<? extends Fragment> fragmentClass = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(this, LoginActivity.class);
        startActivityForResult(intent, LoginCheckActivity.REQUEST_CODE_LOGIN);
    }

    @Override
    protected int getResourceLayoutId() {
        return 0;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        finish();

        if (requestCode == REQUEST_CODE_LOGIN && resultCode == RESULT_OK && fragmentClass != null) {
            launch(fragmentClass);
        }

        fragmentClass = null;
    }

    public static void checkLogin(@Nullable Context content, @NonNull Class<? extends Fragment> cls) {
        if (content == null) {
            return ;
        }

        if (UserAgent.get().isLogin()) {
            if (content instanceof ReusingActivity) {
                ReusingActivity ra = (ReusingActivity)content;
                ra.launch(cls);
            } else if (content instanceof BaseActivity) {
                BaseActivity ba = (BaseActivity)content;
                ba.launch(cls);
            }
        } else {
            fragmentClass = cls;
            Intent intent = new Intent(content, LoginCheckActivity.class);
            content.startActivity(intent);
        }
    }
}
