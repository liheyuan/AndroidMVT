package com.coder4.amvt.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.coder4.amvt.R;
import com.coder4.amvt.data.ComplexOne;
import com.coder4.amvt.util.DateFormatUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by coder4 on 2017/6/2.
 */

public class ComplexListViewDemoAdapter extends C4MVTBaseAdapter<ComplexOne> {

    static class MyViewHolder {
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_id)
        TextView tvId;
        @BindView(R.id.tv_time)
        TextView tvTime;

        public MyViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    public ComplexListViewDemoAdapter(LayoutInflater inflater) {
        super(inflater);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ComplexListViewDemoAdapter.MyViewHolder holder;

        if (convertView == null) {
            convertView = inflater
                    .inflate(R.layout.list_item_complexlistviewdemo, parent, false);
            holder = new ComplexListViewDemoAdapter.MyViewHolder(convertView);
            convertView.setTag(holder);

        } else {
            holder = (ComplexListViewDemoAdapter.MyViewHolder)convertView.getTag();
        }

        ComplexOne object = getItem(position);

        holder.tvName.setText(object.getName());
        holder.tvId.setText(String.format("%d", object.getId()));
        holder.tvTime.setText(DateFormatUtil.format(object.getShowTime()));

        return convertView;
    }

}
