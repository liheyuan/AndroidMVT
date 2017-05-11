package com.coder4.amvt.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
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
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;

    private ActionBarDrawerToggle toggle;

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

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        drawerLayout = (DrawerLayout)findViewById(R.id.drawerLayout);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.drawer_open, R.string.app_name);
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();
        drawerLayout.addDrawerListener(toggle);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(toggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
