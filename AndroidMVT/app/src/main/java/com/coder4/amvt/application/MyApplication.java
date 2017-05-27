package com.coder4.amvt.application;

import android.app.Application;

import com.coder4.amvt.agent.UserAgent;

/**
 * Created by coder4 on 2017/5/27.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        UserAgent.init(this);
    }
}
