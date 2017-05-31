package com.coder4.amvt.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.coder4.amvt.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by coder4 on 2017/5/31.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Nullable
    @BindView(R.id.tvTitle)
    TextView titleTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getResourceLayoutId());
        ButterKnife.bind(this);
    }

    protected abstract int getResourceLayoutId();

    protected void setTitle(String title) {
        if (titleTextView != null) {
            titleTextView.setText(title);
        }
    }
}
