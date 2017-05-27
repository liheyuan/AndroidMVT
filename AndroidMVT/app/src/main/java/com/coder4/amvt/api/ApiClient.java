package com.coder4.amvt.api;

import com.coder4.amvt.constant.ApiHostConst;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by coder4 on 2017/5/27.
 */

public class ApiClient {

    private static ApiClient instance = new ApiClient();

    private Retrofit retrofit;

    private ApiClient() {
        retrofit = getRetrofit();
    }

    private OkHttpClient getHttpClient() {
        return new OkHttpClient.Builder()
                .readTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                //.cookieJar(new MyCookieJar())
                .build();
    }

    private Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(ApiHostConst.HOST)
                .client(getHttpClient())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ApiClient get() {
        return instance;
    }

    // Test Api //
    public TestApi getTestApi() {
        return retrofit.create(TestApi.class);
    }

    public AccountApi getAccountApi() {
        return retrofit.create(AccountApi.class);
    }

}
