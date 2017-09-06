package com.coder4.amvt.adapter;

import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by coder4 on 2017/6/2.
 */

public abstract class C4MVTBaseAdapter<T> extends BaseAdapter {

    protected List<T> dataList = null;
    protected LayoutInflater inflater;

    public C4MVTBaseAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    @Override
    public T getItem(int position) {
        if (dataList == null) {
            return null;
        }
        if (position < 0 || position >= dataList.size()) {
            return null;
        }
        return dataList.get(position);
    }

    @Override
    public int getCount() {
        if (dataList == null) {
            return 0;
        }
        return dataList.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void updateData(@Nullable List<T> data) {
        dataList = data;
        notifyDataSetChanged();
    }

    public void appendData(@Nullable List<T> data) {
        if (data == null) {
            return ;
        }
        if (dataList == null) {
            dataList = new ArrayList();
        }
        dataList.addAll(data);
        notifyDataSetChanged();
    }

    protected boolean isLast(int position) {
        return position >= dataList.size() - 1 ;
    }

    protected boolean isFirst(int position) {
        return position == 0;
    }
}
