package com.coder4.amvt.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.coder4.amvt.R;
import com.coder4.amvt.data.SlidingMenuEntry;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by coder4 on 2017/5/10.
 */

public class SlidingMenuAdapter extends ArrayAdapter<SlidingMenuEntry> {

    static class MyViewHolder {
        @BindView(R.id.iv_menu)
        ImageView imageView;
        @BindView(R.id.tv_menu)
        TextView textView;

        public MyViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    public SlidingMenuAdapter(Context mContext, SlidingMenuEntry[] data) {
        super(mContext, 0, data);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        MyViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater
                    .from(getContext())
                    .inflate(R.layout.list_item_slidingmenu, parent, false);
            holder = new MyViewHolder(convertView);
            convertView.setTag(holder);

        } else {
            holder = (MyViewHolder)convertView.getTag();
        }

        SlidingMenuEntry entry = getItem(position);

        holder.imageView.setImageResource(entry.getIconId());
        holder.textView.setText(entry.getText());

        return convertView;
    }
}
