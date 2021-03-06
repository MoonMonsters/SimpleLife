package com.chalmers.simplelife.fragment;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.chalmers.simplelife.R;
import com.chalmers.simplelife.adapter.NewsViewPagerAdapter;

import butterknife.Bind;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends BaseFragment {

    @Bind(R.id.tl_fragment_tab)
    TabLayout tlFragmentTab;
    @Bind(R.id.vp_fragment_content)
    ViewPager vpFragmentContent;

    private NewsViewPagerAdapter adapter ;

    @Override
    public int getLayoutResource() {
        return R.layout.fragment_news;
    }

    @Override
    public void initData() {
        adapter = new NewsViewPagerAdapter(getActivity().getSupportFragmentManager(),
                getActivity());
        vpFragmentContent.setAdapter(adapter);
        tlFragmentTab.setupWithViewPager(vpFragmentContent);
    }

    @Override
    public void initListener() {

    }
}