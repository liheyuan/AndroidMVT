package com.coder4.amvt.fragment;

import com.coder4.amvt.R;

import butterknife.OnClick;

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
        System.out.print(true);
    }

    @OnClick(R.id.card_no_need_auth)
    public void onClickNoNeedAuth() {

    }
}
