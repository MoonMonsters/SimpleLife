package com.chalmers.simplelife.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.chalmers.simplelife.R;
import com.chalmers.simplelife.fragment.news.FragmentFactory;

/**
 * Created by Chalmers on 2016-09-04 16:36.
 * email:qxinhai@yeah.net
 */
public class FragmentViewPagerAdapter extends FragmentPagerAdapter {

    String mTitles[];

    public FragmentViewPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        mTitles = context.getResources().getStringArray(R.array.fragment_name);
    }

    @Override
    public Fragment getItem(int position) {
        return FragmentFactory.newInstance(position);
    }

    @Override
    public int getCount() {
        return mTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}
