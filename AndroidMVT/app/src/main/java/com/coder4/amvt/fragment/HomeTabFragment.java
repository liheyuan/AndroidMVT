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
    }

    @Override
    protected int getResourceLayoutId() {
        return R.layout.fragment_hometab;
    }

    @OnClick(R.id.card_login_protect)
    public void onClickTextView() {
        Bundle bundle = new Bundle();
        bundle.putString("key", "value");
        launch(DemoFragment.class, bundle, 0);
    }
}
