package com.coder4.amvt.api;

import com.coder4.amvt.agent.UserAgent;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

/**
 * Created by coder4 on 2017/5/27.
 */

public class MyCookieJar implements CookieJar {

    private static List<Cookie> cookies;

    @Override
    public void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
        if (cookies != null && cookies.size() > 0) {
            Gson gson = new Gson();
            UserAgent.get().saveCookie(gson.toJson(cookies));
        }
    }

    @Override
    public List<Cookie> loadForRequest(HttpUrl httpUrl) {
        if (cookies == null) {
            String cookiesStr = UserAgent.get().getCookie();
            if (cookiesStr != null) {
                cookies = new Gson().fromJson(cookiesStr, new TypeToken<List<Cookie>>() {
                }.getType());
            } else {
                cookies = new ArrayList<>();
            }
        }
        return cookies;
    }
}
