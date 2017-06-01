package com.coder4.amvt.api;

import com.coder4.amvt.data.EmptyResult;
import com.coder4.amvt.data.LoginResult;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by coder4 on 2017/5/27.
 */

public interface AccountApi {
    @POST("/account/login")
    Observable<Response<LoginResult>> login(
            @Query("username") String user,
            @Query("passhash") String passhash);
}
