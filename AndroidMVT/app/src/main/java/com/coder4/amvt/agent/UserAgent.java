package com.coder4.amvt.agent;

import android.content.Context;
import android.content.SharedPreferences;

import com.coder4.amvt.api.ApiClient;
import com.coder4.amvt.constant.ApiResultError;
import com.coder4.amvt.constant.BusEvent;
import com.coder4.amvt.data.EmptyResult;
import com.coder4.amvt.rx.ApiResultCallback;
import com.coder4.amvt.rx.RxSchedulerUtils;
import com.coder4.amvt.util.HashUtil;
import com.coder4.amvt.util.StringUtil;

import org.greenrobot.eventbus.EventBus;

import retrofit2.Response;

/**
 * Created by coder4 on 2017/5/22.
 */

public class UserAgent {

    // Const
    private static final String PERF_KEY_USER = "perf_user";
    private static final String STORE_KEY_COOKIE = "store_cookie";

    // Property
    private SharedPreferences perf;

    private static UserAgent instance = null;

    private volatile boolean isLogin = false;

    private UserAgent(Context ctx) {
        perf = ctx.getSharedPreferences(PERF_KEY_USER, Context.MODE_PRIVATE);
        isLogin = StringUtil.isNotEmpty(getCookie());
    }

    public synchronized static void init(Context ctx) {
        instance = new UserAgent(ctx);
    }

    public synchronized static UserAgent get() {
        return instance;
    }

    public void login(String user, String pass) {
        String passEncrypt = HashUtil.sha256("C4MVT_"+pass);
        ApiClient.get().getAccountApi().login(user, passEncrypt)
                .compose(RxSchedulerUtils.<Response<EmptyResult>>getApiSchedulers())
                .subscribe(new ApiResultCallback<Response<EmptyResult>>() {

                    @Override
                    public void onApiSucc(Response<EmptyResult> o) {
                        isLogin = true;
                        EventBus.getDefault().post(new BusEvent.LoginSuccEvent());
                    }

                    @Override
                    public void onApiFail(ApiResultError errType, int code) {
                        isLogin = false;
                        EventBus.getDefault().post(new BusEvent.LoginFailEvent());
                    }
                });
    }

    public void logout() {
        isLogin = false;
        clearCookie();
    }

    public boolean isLogin() {
        return isLogin;
    }

    public void saveCookie(String cookieStr) {
        SharedPreferences.Editor edit = perf.edit();
        edit.putString(STORE_KEY_COOKIE, cookieStr);
        edit.apply();
    }

    public String getCookie() {
        return perf.getString(STORE_KEY_COOKIE, null);
    }

    private void clearCookie() {
        SharedPreferences.Editor edit = perf.edit();
        edit.remove(STORE_KEY_COOKIE);
        edit.apply();
    }
}
