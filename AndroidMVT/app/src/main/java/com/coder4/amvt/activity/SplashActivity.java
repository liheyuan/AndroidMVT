package com.coder4.amvt.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.Window;
import android.view.WindowManager;

import com.coder4.amvt.R;

/**
 * Created by coder4 on 2017/6/7.
 */

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        // Full screen & no title
        Window window = getWindow();
        if (window != null) {
            window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
            requestWindowFeature(Window.FEATURE_NO_TITLE);
        }

        // Call Super
        super.onCreate(savedInstanceState);

        // Dismiss 3 seconds
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // revert not full screen
                Window window = getWindow();
                if (window != null) {
                    window.setFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN,
                            WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
                }
                Intent intent = new Intent();
                intent.setClass(SplashActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000);
    }

    @Override
    protected int getResourceLayoutId() {
        return R.layout.activity_splash;
    }
}
