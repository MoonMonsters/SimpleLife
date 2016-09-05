package com.chalmers.simplelife.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.chalmers.simplelife.R;
import com.chalmers.simplelife.fragment.BaseFragment;

import java.util.ArrayList;

/**
 * Created by Chalmers on 2016-09-05 20:56.
 * email:qxinhai@yeah.net
 */
public class JokeViewPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<BaseFragment> mFragments;
    private String mTitles[];

    public JokeViewPagerAdapter(FragmentManager fm, Context context, ArrayList<BaseFragment> fragments) {
        super(fm);
        this.mFragments = fragments;
        mTitles = context.getResources().getStringArray(R.array.joke_fragment_name);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
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
