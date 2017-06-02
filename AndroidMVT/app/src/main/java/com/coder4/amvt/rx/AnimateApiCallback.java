package com.coder4.amvt.rx;

import com.coder4.amvt.intf.ILoadingProgress;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.Disposable;

/**
 * Created by coder4 on 2017/6/2.
 */

public abstract class AnimateApiCallback<T> extends ApiCallback<T> {

    WeakReference<ILoadingProgress> lpRef = null;

    public AnimateApiCallback(ILoadingProgress loadingProgress) {
        lpRef = new WeakReference<ILoadingProgress>(loadingProgress);
    }

    @Override
    public void onSubscribe(Disposable disposable) {
        super.onSubscribe(disposable);
        ILoadingProgress lp = lpRef.get();
        if (lp != null) {
            lp.showLoadingDialog("Loading");
        }
    }

    @Override
    public void onError(Throwable t) {
        ILoadingProgress lp = lpRef.get();
        if (lp != null) {
            lp.dismissLoadingDialog();
        }
        super.onError(t);
    }

    @Override
    public void onComplete() {
        ILoadingProgress lp = lpRef.get();
        if (lp != null) {
            lp.dismissLoadingDialog();
        }
        super.onComplete();
    }
}
