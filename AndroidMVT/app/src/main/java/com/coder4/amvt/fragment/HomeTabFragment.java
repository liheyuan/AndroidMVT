package com.coder4.amvt.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.coder4.amvt.R;

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
        TextView textView = (TextView) view.findViewById(R.id.textView);
        textView.setText("Fragment #" + mPage);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("key", "value");
                launch(DemoFragment.class, bundle, 0);
            }
        });
    }

    @Override
    protected int getResourceLayoutId() {
        return R.layout.fragment_hometab;
    }
}
