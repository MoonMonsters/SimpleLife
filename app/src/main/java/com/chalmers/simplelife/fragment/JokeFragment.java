package com.chalmers.simplelife.fragment;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.chalmers.simplelife.R;
import com.chalmers.simplelife.adapter.JokeViewPagerAdapter;
import com.chalmers.simplelife.fragment.joke.ImgJokeFragment;
import com.chalmers.simplelife.fragment.joke.TextJokeFragment;

import java.util.ArrayList;

import butterknife.Bind;

/**
 * A simple {@link Fragment} subclass.
 */
public class JokeFragment extends BaseFragment {


    @Bind(R.id.tl_fragment_joke)
    TabLayout tlFragmentJoke;
    @Bind(R.id.vp_fragment_joke)
    ViewPager vpFragmentJoke;

    private ArrayList<BaseFragment> mFragments;

    @Override
    public int getLayoutResource() {
        return R.layout.fragment_joke;
    }

    @Override
    public void initData() {
        mFragments = new ArrayList<>();
        mFragments.add(new TextJokeFragment());
        mFragments.add(new ImgJokeFragment());

        JokeViewPagerAdapter adapter = new JokeViewPagerAdapter(getActivity().getSupportFragmentManager(),
                getActivity(),mFragments);
        vpFragmentJoke.setAdapter(adapter);
        tlFragmentJoke.setupWithViewPager(vpFragmentJoke);
    }

    @Override
    public void initListener() {

    }
}
