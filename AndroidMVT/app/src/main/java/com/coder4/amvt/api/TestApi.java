package com.coder4.amvt.api;

import com.coder4.amvt.data.NeedAuth;
import com.coder4.amvt.data.NoNeedAuth;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by coder4 on 2017/5/27.
 */

public interface TestApi {

    @GET("/test/noneedauth")
    Observable<Response<NoNeedAuth>> noNeedAuth(@Query("extra") String extra);

    @GET("/test/needauth")
    Observable<Response<NeedAuth>> needAuth();

}
