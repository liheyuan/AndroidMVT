package com.coder4.amvt.rx;

import com.coder4.amvt.agent.UserAgent;
import com.coder4.amvt.constant.ApiResultError;
import com.coder4.amvt.constant.BusEvent;
import com.coder4.amvt.data.LoginResult;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import retrofit2.HttpException;
import retrofit2.Response;


/**
 * Created by coder4 on 2017/5/27.
 */

public abstract class ApiCallback<T> implements Observer<T> {

    public void onSubscribe(Disposable disposable) {

    }


    public void onComplete() {

    }

    public void onNext(T t) {
        // From retrofit 2 check status code should be on your own
        if (t instanceof Response) {
            Response resp = (Response)t;
            if (!resp.isSuccessful()) {
                int code = resp.code();
                if (code == 401 && UserAgent.get().autoLogout()) {
                    return ;
                }
                onApiFail(ApiResultError.StatusCodeError, code);
                return ;
            }
        }
        onApiSucc(t);
    }

    public void onError(Throwable t) {
        if (t instanceof IOException) {
            // no network
            onApiFail(ApiResultError.NetworkError, 0);
        } else {
            // unknown
            onApiFail(ApiResultError.UnknownError, 0);
        }
    }

    // caller should only care following
    public abstract void onApiSucc(T t);

    public abstract void onApiFail(ApiResultError errType, int code);
}
