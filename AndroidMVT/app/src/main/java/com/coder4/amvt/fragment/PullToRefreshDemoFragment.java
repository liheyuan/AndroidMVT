package com.coder4.amvt.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.widget.ListView;

import com.coder4.amvt.R;
import com.coder4.amvt.adapter.ListViewDemoAdapter;
import com.coder4.amvt.util.ViewUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;

/**
 * Created by coder4 on 2017/6/2.
 */

public class PullToRefreshDemoFragment extends BaseFragment {

    @BindView(R.id.listView)
    ListView listView;
    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;

    private ListViewDemoAdapter adapter;

    @Override
    protected void setupView(LayoutInflater inflater, @Nullable Bundle savedInstanceState) {
        super.setupView(inflater, savedInstanceState);
        setTitle("Pull To Refresh Demo");
        initLoad();
    }

    @Override
    protected int getHeaderLayoutResourceId() {
        return R.layout.include_toolbar;
    }

    @Override
    protected int getBodyLayoutResourceId() {
        return R.layout.fragment_pulltorefresh_demo;
    }

    @Override
    protected void initLoad() {
        setupUI();
    }

    private void setupUI() {
        renderBody();
        adapter = new ListViewDemoAdapter(inflater);
        listView.setAdapter(adapter);
        adapter.updateData(getRandomData());

        ViewUtil.setSwipeRefreshLayoutColor(swipeRefreshLayout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {


                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefreshLayout.setRefreshing(false);
                        adapter.updateData(getRandomData());
                    }
                }, 500);

            }
        });
    }

    private List<String> getRandomData() {
        List<String> data = new ArrayList<>();
        Random rand = new Random(System.currentTimeMillis());
        for (int i=0; i<10; i++) {
            data.add("Demo String " + rand.nextInt(100));
        }
        return data;
    }
}
