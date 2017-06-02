package com.coder4.amvt.util;

import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;

import com.coder4.amvt.R;

/**
 * Created by coder4 on 2017/6/2.
 */

public class ViewUtil {
    public static void setSwipeRefreshLayoutColor(@Nullable SwipeRefreshLayout layout) {
        if (layout == null) {
            return ;
        }
        layout.setColorSchemeResources(R.color.colorPrimary);
    }
}
