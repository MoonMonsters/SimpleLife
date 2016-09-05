package com.chalmers.simplelife.fragment.news;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.chalmers.simplelife.R;
import com.chalmers.simplelife.activity.NewsDetailActivity;
import com.chalmers.simplelife.adapter.NewsAdapter;
import com.chalmers.simplelife.bean.news.NewsData;
import com.chalmers.simplelife.bean.news.News;
import com.chalmers.simplelife.fragment.BaseFragment;
import com.chalmers.simplelife.utils.Config;
import com.chalmers.simplelife.utils.NetConnection;
import com.google.gson.Gson;

import java.util.ArrayList;

import butterknife.Bind;

/**
 * A simple {@link Fragment} subclass.
 */
public class AllNewsFragment extends BaseFragment {

    public static final String COMMAND = "command";

    private ArrayList<News> mNewses;
    private NewsAdapter mAdapter;

    @Bind(R.id.lv_top_news)
    ListView lvTopNews;

    @Override
    public int getLayoutResource() {
        return R.layout.fragment_all_news;
    }

    @Override
    public void initData() {

        String command = getArguments().getString(COMMAND,"top");

        NetConnection.netConnectionWithNews(getActivity(), command,
                new NetConnection.DataCallback() {
                    @Override
                    public void doSuccess(String jsonData) {
                        mNewses = new Gson().fromJson(jsonData, NewsData.class)
                                .getResult().getData();
                        Log.i("TAG",mNewses.toString());
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                mAdapter = new NewsAdapter(getActivity(),mNewses);
                                lvTopNews.setAdapter(mAdapter);
                            }
                        });
                    }

                    @Override
                    public void doFail(String msg) {

                    }
                });
    }

    @Override
    public void initListener() {
        lvTopNews.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), NewsDetailActivity.class);
                intent.putExtra(Config.URL_NEWS_DETAIL_INTENT,mNewses.get(position).getUrl());
                startActivity(intent);
            }
        });
    }

    public BaseFragment instance(String command ){
        Bundle bundle = new Bundle();
        bundle.putString(COMMAND,command);
        setArguments(bundle);

        return this;
    }
}
