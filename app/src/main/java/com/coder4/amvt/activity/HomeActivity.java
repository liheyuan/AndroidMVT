package com.coder4.amvt.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.coder4.amvt.R;
import com.coder4.amvt.adapter.HomeTabPageAdapter;
import com.coder4.amvt.adapter.SlidingMenuAdapter;
import com.coder4.amvt.data.SlidingMenuEntry;

public class HomeActivity extends AppCompatActivity {

    private HomeTabPageAdapter pagerAdapter;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private ListView slidingMenuListView;

    private SlidingMenuEntry[] MENU_ENTRIES = new SlidingMenuEntry[] {
            new SlidingMenuEntry("Menu1", R.drawable.ic_home),
            new SlidingMenuEntry("Menu2", R.drawable.ic_camera),
            new SlidingMenuEntry("Menu3", R.drawable.ic_setting)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        pagerAdapter = new HomeTabPageAdapter(getSupportFragmentManager(), this);
        viewPager = (ViewPager)findViewById(R.id.viewPager);
        viewPager.setAdapter(pagerAdapter);

        tabLayout = (TabLayout)findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);

        slidingMenuListView = (ListView)findViewById(R.id.slidingMenuListView);
        slidingMenuListView.setAdapter(new SlidingMenuAdapter(this, MENU_ENTRIES));
    }

}
