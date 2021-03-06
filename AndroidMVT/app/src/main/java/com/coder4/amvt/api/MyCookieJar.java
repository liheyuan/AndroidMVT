package com.coder4.amvt.api;

import com.coder4.amvt.agent.UserAgent;
import com.coder4.amvt.util.StringUtil;
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
        if (list != null && list.size() > 0) {
            Gson gson = new Gson();
            UserAgent.get().saveCookie(gson.toJson(list));

            synchronized (MyCookieJar.class) {
                cookies = list;
            }

        }
    }

    @Override
    public List<Cookie> loadForRequest(HttpUrl httpUrl) {
        synchronized (MyCookieJar.class) {
            if (cookies == null) {
                String cookiesStr = UserAgent.get().getCookie();
                if (StringUtil.isNotEmpty(cookiesStr)) {
                    cookies = new Gson().fromJson(cookiesStr, new TypeToken<List<Cookie>>() {
                    }.getType());
                } else {
                    cookies = new ArrayList<>();
                }
            }
            return cookies;
        }
    }
}
