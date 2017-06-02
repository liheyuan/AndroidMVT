package com.coder4.amvt.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import com.coder4.amvt.R;
import com.coder4.amvt.intf.IToast;
import com.coder4.amvt.util.ReusingActivityFragmentUtil;

/**
 * Created by coder4 on 2017/5/18.
 */

public class ReusingActivity extends FragmentActivity implements IToast {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reusing);
        ReusingActivityFragmentUtil.loadFragment(getIntent(), ReusingActivity.this);

    }

    public void launch(Class<? extends Fragment> fragmentClass) {
        launch(fragmentClass, null, 0);
    }

    public void launch(Class<? extends Fragment> fragmentClass,
                       @Nullable Bundle fragmentArgs,
                       int reqCode) {

        Intent intent = new Intent(this, ReusingActivity.class);
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

    public void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

}
