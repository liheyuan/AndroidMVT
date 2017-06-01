package com.coder4.amvt.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.coder4.amvt.R;
import com.coder4.amvt.util.ReusingActivityFragmentUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by coder4 on 2017/5/31.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Nullable
    @BindView(R.id.tv_title)
    TextView tvTitle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int resourceId = getResourceLayoutId();
        if (resourceId > 0) {
            setContentView(resourceId);
        }
        ButterKnife.bind(this);
    }

    protected abstract int getResourceLayoutId();

    protected void setTitle(String title) {
        if (tvTitle != null) {
            tvTitle.setText(title);
        }
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
        Toast.makeText(this, msg, Toast.LENGTH_SHORT);
    }

}
