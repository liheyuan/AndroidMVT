package com.coder4.amvt.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.coder4.amvt.R;
import com.coder4.amvt.api.ApiClient;
import com.coder4.amvt.constant.ApiResultError;
import com.coder4.amvt.data.NoNeedAuth;
import com.coder4.amvt.rx.ApiResultCallback;
import com.coder4.amvt.rx.RxSchedulerUtils;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.OnClick;
import retrofit2.Response;

/**
 * Created by coder4 on 2017/5/10.
 */

public class HomeTabFragment extends BaseFragment {
    public static final String ARG_PAGE = "ARG_PAGE";
    private int mPage;
    @BindView(R.id.textView)
    TextView textView;

    public static HomeTabFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        HomeTabFragment pageFragment = new HomeTabFragment();
        pageFragment.setArguments(args);
        return pageFragment;
    }

    @Override
    protected void setupView(LayoutInflater inflater, View view, Bundle savedInstanceState) {
        mPage = getArguments().getInt(ARG_PAGE, 0);
        if (textView != null) {
            textView.setText("Tab " + mPage);
        }
    }

    @Override
    protected int getResourceLayoutId() {
        return R.layout.fragment_hometab;
    }

    @OnClick(R.id.textView)
    public void onClickTextView() {
        if (mPage == 1) {
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
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("key", "value");
            launch(DemoFragment.class, bundle, 0);
        }
    }
}
