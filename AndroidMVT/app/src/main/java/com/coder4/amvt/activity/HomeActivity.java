package com.coder4.amvt.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ListView;

import com.coder4.amvt.R;
import com.coder4.amvt.adapter.HomeTabPageAdapter;
import com.coder4.amvt.adapter.SlidingMenuAdapter;
import com.coder4.amvt.data.SlidingMenuEntry;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends BaseActivity {

    private HomeTabPageAdapter pagerAdapter;

    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.slidingMenuListView)
    ListView slidingMenuListView;
    @BindView(R.id.drawerLayout)
    DrawerLayout drawerLayout;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private ActionBarDrawerToggle toggle;

    private SlidingMenuEntry[] MENU_ENTRIES = new SlidingMenuEntry[] {
            new SlidingMenuEntry("Menu1", R.drawable.ic_home),
            new SlidingMenuEntry("Menu2", R.drawable.ic_camera),
            new SlidingMenuEntry("Menu3", R.drawable.ic_setting)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        pagerAdapter = new HomeTabPageAdapter(getSupportFragmentManager());

        viewPager.setAdapter(pagerAdapter);

        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);

        slidingMenuListView.setAdapter(new SlidingMenuAdapter(this, MENU_ENTRIES));

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.drawer_open, R.string.app_name);
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();
        drawerLayout.addDrawerListener(toggle);

    }

    @Override
    protected int getResourceLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(toggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
