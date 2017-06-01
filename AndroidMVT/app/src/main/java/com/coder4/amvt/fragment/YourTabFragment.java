package com.coder4.amvt.fragment;

import com.coder4.amvt.R;
import com.coder4.amvt.activity.LoginCheckActivity;
import com.coder4.amvt.activity.ReusingActivity;
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

public class YourTabFragment extends StaticBaseFragment {

    public static YourTabFragment newInstance() {
        YourTabFragment fragment = new YourTabFragment();
        return fragment;
    }

    @Override
    protected int getHeaderLayoutResourceId() {
        return 0;
    }

    @Override
    protected int getBodyLayoutResourceId() {
        return R.layout.fragment_yourtab;
    }

}
