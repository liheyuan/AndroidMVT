package com.coder4.amvt.adapter;

import android.view.LayoutInflater;
import android.widget.BaseAdapter;

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

    public void updateData(List<T> data) {
        dataList = data;
        notifyDataSetChanged();
    }
}
