package com.coder4.amvt.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.coder4.amvt.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by coder4 on 2017/6/2.
 */

public class ListViewDemoAdapter extends C4MVTBaseAdapter<String> {

    static class MyViewHolder {
        @BindView(R.id.tv_text)
        TextView textView;

        public MyViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    public ListViewDemoAdapter(LayoutInflater inflater) {
        super(inflater);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ListViewDemoAdapter.MyViewHolder holder;

        if (convertView == null) {
            convertView = inflater
                    .inflate(R.layout.list_item_listviewdemo, parent, false);
            holder = new ListViewDemoAdapter.MyViewHolder(convertView);
            convertView.setTag(holder);

        } else {
            holder = (ListViewDemoAdapter.MyViewHolder)convertView.getTag();
        }

        String str = getItem(position);

        holder.textView.setText(str);

        return convertView;
    }

}
