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
import android.widget.Toast;

import com.chalmers.simplelife.R;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbarMain);
        actionBar = getSupportActionBar();
        setTitle(R.string.app_name);

        initData();
    }

    private void initData() {
        drawerToggle = new ActionBarDrawerToggle(this, dlMainDrawer, toolbarMain,
                R.string.app_name, R.string.app_name);
        drawerToggle.syncState();
        dlMainDrawer.addDrawerListener(drawerToggle);
        nvMainNavigation.setNavigationItemSelectedListener(onNavigationItemSelectedListener);
    }

    NavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener = new NavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            if (item.getGroupId() == R.id.group_nav) {

                if (item.getItemId() == R.id.menu_nav_news) {
                    Toast.makeText(MainActivity.this, "新闻", Toast.LENGTH_SHORT).show();
                } else if (item.getItemId() == R.id.menu_nav_joke) {
                    Toast.makeText(MainActivity.this, "笑话", Toast.LENGTH_SHORT).show();
                } else if (item.getItemId() == R.id.menu_nav_history) {
                    Toast.makeText(MainActivity.this, "历史", Toast.LENGTH_SHORT).show();
                }
            }

            dlMainDrawer.closeDrawers();
            return true;
        }
    };
}