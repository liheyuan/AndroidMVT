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

public class YourTabFragment extends BaseFragment {

    public static YourTabFragment newInstance() {
        YourTabFragment fragment = new YourTabFragment();
        return fragment;
    }

    @Override
    protected int getResourceLayoutId() {
        return R.layout.fragment_yourtab;
    }
}
