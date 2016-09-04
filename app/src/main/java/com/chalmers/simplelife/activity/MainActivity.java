package com.chalmers.simplelife.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.chalmers.simplelife.R;
import com.chalmers.simplelife.fragment.HistoryFragment;
import com.chalmers.simplelife.fragment.JokeFragment;
import com.chalmers.simplelife.fragment.NewsFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.nv_main_navigation)
    NavigationView nvMainNavigation;
    @Bind(R.id.dl_main_drawer)
    DrawerLayout dlMainDrawer;
    @Bind(R.id.toolbar_main)
    Toolbar toolbarMain;

    private ActionBarDrawerToggle drawerToggle;
    private ActionBar actionBar;

    private NewsFragment mNewsFragment ;
    private JokeFragment mJokeFragment;
    private HistoryFragment mHistoryFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //用toolbar替代ActionBar
        setSupportActionBar(toolbarMain);
        actionBar = getSupportActionBar();
        //设置标题
        setTitle(R.string.app_name);

        initData();
    }

    private void initData() {
        //得到DrawerToggle对象
        drawerToggle = new ActionBarDrawerToggle(this, dlMainDrawer, toolbarMain,
                R.string.app_name, R.string.app_name);
        //同步
        drawerToggle.syncState();
        //监听事件
        dlMainDrawer.addDrawerListener(drawerToggle);
        nvMainNavigation.setNavigationItemSelectedListener(onNavigationItemSelectedListener);

        mNewsFragment = new NewsFragment();
        mJokeFragment = new JokeFragment();
        mHistoryFragment = new HistoryFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.frameLayout_main,mNewsFragment)
                .add(R.id.frameLayout_main,mJokeFragment)
                .add(R.id.frameLayout_main,mHistoryFragment)
                .hide(mJokeFragment)
                .hide(mHistoryFragment)
                .show(mNewsFragment)
                .commit();
    }

    NavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener = new NavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            if (item.getGroupId() == R.id.group_nav) {

                if (item.getItemId() == R.id.menu_nav_news) {
                    getSupportFragmentManager().beginTransaction()
                            .hide(mJokeFragment)
                            .hide(mHistoryFragment)
                            .show(mNewsFragment)
                            .commit();

                } else if (item.getItemId() == R.id.menu_nav_joke) {
                    getSupportFragmentManager().beginTransaction()
                            .hide(mNewsFragment)
                            .hide(mHistoryFragment)
                            .show(mJokeFragment)
                            .commit();
                } else if (item.getItemId() == R.id.menu_nav_history) {
                    getSupportFragmentManager().beginTransaction()
                            .hide(mNewsFragment)
                            .hide(mJokeFragment)
                            .show(mHistoryFragment)
                            .commit();
                }
            }

            dlMainDrawer.closeDrawers();
            return true;
        }
    };
}