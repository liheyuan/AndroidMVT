package com.coder4.amvt.view;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.widget.ListView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;

import com.coder4.amvt.R;

/**
 * Created by coder4 on 2017/6/2.
 */
public class LoadMoreListView extends ListView implements AbsListView.OnScrollListener {

    public interface OnLoadMoreListener {
        void onLoadMore();
    }

    private static final int MAX_VISIBLE_THRESHOLD = 5;

    private View footView;
    private OnLoadMoreListener loadMoreListener;
    private volatile boolean canLoadMore = true;
    private volatile boolean isLoading = false;

    public LoadMoreListView(Context context) {
        super(context);
        init(context);
    }

    public LoadMoreListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public LoadMoreListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        footView = LayoutInflater.from(context).inflate(R.layout.view_loadmore_footer, null);
        setOnScrollListener(this);

        // work for > L
        setOverscrollFooter(new ColorDrawable(Color.TRANSPARENT));
    }

    @Override
    public void onScrollStateChanged(AbsListView listView, int scrollState) {

    }

    @Override
    public void onScroll(AbsListView absListView, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        int lastItemIndex = firstVisibleItem + visibleItemCount;
        if (loadMoreListener != null && canLoadMore && !isLoading &&
                lastItemIndex + MAX_VISIBLE_THRESHOLD >= totalItemCount) {
            isLoading = true;
            loadMoreListener.onLoadMore();
            addFooterView(footView);
        }
    }

    public void setOnLoadMoreListener(OnLoadMoreListener listener) {
        loadMoreListener = listener;
    }


    public void setLoadCompleted() {
        isLoading = false;
        removeFooterView(footView);
    }

    public void setCanLoadMore(boolean loadMore) {
        canLoadMore = loadMore;
    }
}
