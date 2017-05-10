package com.coder4.amvt.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.coder4.amvt.R;
import com.coder4.amvt.data.SlidingMenuEntry;

/**
 * Created by coder4 on 2017/5/10.
 */

public class SlidingMenuAdapter extends ArrayAdapter<SlidingMenuEntry> {

    public SlidingMenuAdapter(Context mContext, SlidingMenuEntry[] data) {
        super(mContext, 0, data);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater
                    .from(getContext())
                    .inflate(R.layout.list_view_item_slidingmenu, parent, false);
        }

        SlidingMenuEntry entry = getItem(position);

        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageViewMenu);
        TextView textView = (TextView) convertView.findViewById(R.id.textViewMenu);

        imageView.setImageResource(entry.getIconId());
        textView.setText(entry.getText());

        return convertView;
    }
}
