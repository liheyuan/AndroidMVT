package com.coder4.amvt.fragment;

import com.coder4.amvt.R;
import com.coder4.amvt.api.ApiClient;
import com.coder4.amvt.constant.ApiResultError;
import com.coder4.amvt.data.NeedAuth;
import com.coder4.amvt.data.NoNeedAuth;
import com.coder4.amvt.rx.ApiResultCallback;
import com.coder4.amvt.rx.RxSchedulerUtils;

import butterknife.OnClick;
import retrofit2.Response;

/**
 * Created by coder4 on 2017/5/31.
 */

public class MyTabFragment extends BaseFragment {

    public static MyTabFragment newInstance() {
        MyTabFragment fragment = new MyTabFragment();
        return fragment;
    }

    @Override
    protected int getResourceLayoutId() {
        return R.layout.fragment_mytab;
    }

    @OnClick(R.id.card_need_auth)
    public void onClickNeedAuth() {
        ApiClient.get().getTestApi()
                .needAuth()
                .compose(RxSchedulerUtils.<Response<NeedAuth>>getApiSchedulers())
                .subscribe(new ApiResultCallback<Response<NeedAuth>>() {

                    @Override
                    public void onApiSucc(Response<NeedAuth> o) {
                        System.out.println(o.body());
                    }

                    @Override
                    public void onApiFail(ApiResultError errType, int code) {
                        System.out.println("err " + errType + code);
                    }
                });
    }

    @OnClick(R.id.card_no_need_auth)
    public void onClickNoNeedAuth() {
        ApiClient.get().getTestApi()
                .noNeedAuth("extra message")
                .compose(RxSchedulerUtils.<Response<NoNeedAuth>>getApiSchedulers())
                .subscribe(new ApiResultCallback<Response<NoNeedAuth>>() {

                    @Override
                    public void onApiSucc(Response<NoNeedAuth> o) {
                        System.out.println(o.body());
                    }

                    @Override
                    public void onApiFail(ApiResultError errType, int code) {
                        System.out.println("err " + errType + code);
                    }
                });
    }
}
