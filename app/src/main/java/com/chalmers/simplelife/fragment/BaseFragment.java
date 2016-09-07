package com.chalmers.simplelife.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class BaseFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(getLayoutResource(),container,false);
        ButterKnife.bind(this,view);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        initData();
        initListener();
    }

    /** 返回布局id */
    public abstract int getLayoutResource();

    /** 初始化数据 */
    public abstract void initData();

    /** 初始化监听器 */
    public abstract void initListener();

}
