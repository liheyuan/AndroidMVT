package com.coder4.amvt.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.coder4.amvt.R;
import com.coder4.amvt.adapter.ComplexListViewDemoAdapter;
import com.coder4.amvt.adapter.ListViewDemoAdapter;
import com.coder4.amvt.data.ComplexOne;
import com.coder4.amvt.util.ViewUtil;
import com.coder4.amvt.view.LoadMoreListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;

/**
 * Created by coder4 on 17-9-6.
 */

public class ComplexListViewDemoFragment extends StaticBaseFragment {

    @BindView(R.id.listView)
    ListView listView;

    private ComplexListViewDemoAdapter adapter;

    @Override
    protected int getHeaderLayoutResourceId() {
        return R.layout.include_toolbar;
    }

    @Override
    protected int getBodyLayoutResourceId() {
        return R.layout.fragment_complex_listview_demo;
    }

    @Override
    protected void setupView(LayoutInflater inflater, @Nullable Bundle savedInstanceState) {
        super.setupView(inflater, savedInstanceState);
        setTitle("ComplexListView Demo");
        initLoad();
    }

    @Override
    protected void initLoad() {
        setupUI();
    }

    private void setupUI() {
        renderBody();
        adapter = new ComplexListViewDemoAdapter(inflater);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), String.format("click %d", position), Toast.LENGTH_SHORT).show();
            }
        });
        listView.setAdapter(adapter);
        adapter.updateData(getMockData());
    }

    private List<ComplexOne> getMockData() {
        List<ComplexOne> complexOnes = new ArrayList<>();
        Random rand = new Random(System.currentTimeMillis());
        for (int i = 0; i < 100; i++) {
            ComplexOne one = new ComplexOne();
            one.setId(rand.nextInt(1000));
            one.setName(String.format("Name%d", rand.nextInt(1000)));
            one.setShowTime(Math.abs(rand.nextInt()));

            complexOnes.add(one);
        }
        return complexOnes;
    }
}
