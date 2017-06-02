package com.coder4.amvt.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;

import com.coder4.amvt.R;
import com.coder4.amvt.activity.LoginCheckActivity;

import butterknife.OnClick;

/**
 * Created by coder4 on 2017/5/10.
 */

public class HomeTabFragment extends StaticBaseFragment {
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
    protected void setupView(LayoutInflater inflater, @Nullable Bundle savedInstanceState) {
        Bundle arg = getArguments();
        if (arg == null) {
            return ;
        }
        mPage = arg.getInt(ARG_PAGE, 0);
        initLoad();
    }

    @Override
    protected int getBodyLayoutResourceId() {
        return R.layout.fragment_hometab;
    }

    @Override
    protected int getHeaderLayoutResourceId() {
        return 0;
    }

    @OnClick(R.id.card_login_protect)
    public void onClickCardLoginProtect() {

        final Activity activity = getActivity();

        LoginCheckActivity.checkLogin(activity, DemoFragment.class);

    }

    @OnClick(R.id.card_mock_loading)
    public void onClickCardMockLoading() {
        launch(MockLoadingFragment.class);
    }

    @OnClick(R.id.card_toast)
    public void onClickCardToast() {
        toast("Hello Toast");
    }
}
