package com.coder4.amvt.fragment;

import com.coder4.amvt.R;
import com.coder4.amvt.api.ApiClient;
import com.coder4.amvt.constant.ApiResultError;
import com.coder4.amvt.data.NeedAuth;
import com.coder4.amvt.data.NoNeedAuth;
import com.coder4.amvt.rx.AnimateApiCallback;
import com.coder4.amvt.rx.ApiCallback;
import com.coder4.amvt.rx.RxSchedulerUtils;

import butterknife.OnClick;
import retrofit2.Response;

/**
 * Created by coder4 on 2017/5/31.
 */

public class MyTabFragment extends StaticBaseFragment {

    public static MyTabFragment newInstance() {
        MyTabFragment fragment = new MyTabFragment();
        return fragment;
    }

    @Override
    protected int getHeaderLayoutResourceId() {
        return 0;
    }

    @Override
    protected int getBodyLayoutResourceId() {
        return R.layout.fragment_mytab;
    }

    @OnClick(R.id.card_need_auth)
    public void onClickNeedAuth() {
        ApiClient.get().getTestApi()
                .needAuth()
                .compose(RxSchedulerUtils.<Response<NeedAuth>>getApiSchedulers())
                .subscribe(new AnimateApiCallback<Response<NeedAuth>>(this) {

                    @Override
                    public void onApiSucc(Response<NeedAuth> o) {
                        NeedAuth needAuth = o.body();
                        if (needAuth == null) {
                            return ;
                        }
                        toast(needAuth.getMsg());
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
                .subscribe(new ApiCallback<Response<NoNeedAuth>>() {

                    @Override
                    public void onApiSucc(Response<NoNeedAuth> o) {
                        NoNeedAuth noNeedAuth = o.body();
                        if (noNeedAuth == null) {
                            return ;
                        }
                        toast(noNeedAuth.getMsg());
                    }

                    @Override
                    public void onApiFail(ApiResultError errType, int code) {
                        System.out.println("err " + errType + code);
                    }
                });
    }

    @OnClick(R.id.card_pull_to_refresh)
    public void onClickPullToRefresh() {
        launch(PullToRefreshDemoFragment.class);
    }

    @OnClick(R.id.card_load_more)
    public void onClickLoadMore() {
        launch(LoadMoreDemoFragment.class);
    }
}
