package com.coder4.amvt.rx;

import com.coder4.amvt.constant.ApiResultError;

import java.io.IOException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import retrofit2.HttpException;


/**
 * Created by coder4 on 2017/5/27.
 */

public abstract class ApiResultCallback<T> implements Observer<T> {

    @Override
    public void onSubscribe(Disposable disposable) {

    }


    @Override
    public void onComplete() {

    }

    @Override
    public void onNext(T t) {
        onApiSucc(t);
    }

    @Override
    public void onError(Throwable t) {
        if (t instanceof IOException) {
            // no network
            onApiFail(ApiResultError.NetworkError, 0);
        } else if (t instanceof HttpException) {
            // http status code not in [200, 300)
            onApiFail(ApiResultError.StatusCodeError, ((HttpException) t).code());
        } else {
            // unknown
            onApiFail(ApiResultError.UnknownError, 0);
        }
    }

    // caller should only care following
    public abstract void onApiSucc(T t);

    public abstract void onApiFail(ApiResultError errType, int code);
}
