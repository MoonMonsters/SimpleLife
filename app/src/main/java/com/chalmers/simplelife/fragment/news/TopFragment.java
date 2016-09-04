package com.chalmers.simplelife.fragment.news;


import android.support.v4.app.Fragment;
import android.util.Log;
import android.widget.ListView;

import com.chalmers.simplelife.R;
import com.chalmers.simplelife.adapter.NewsAdapter;
import com.chalmers.simplelife.bean.AllData;
import com.chalmers.simplelife.bean.News;
import com.chalmers.simplelife.utils.Config;
import com.chalmers.simplelife.utils.NetConnection;
import com.google.gson.Gson;

import java.util.ArrayList;

import butterknife.Bind;

/**
 * A simple {@link Fragment} subclass.
 */
public class TopFragment extends BaseFragment {

    private ArrayList<News> mNewses;
    private NewsAdapter mAdapter;

    @Bind(R.id.lv_top_news)
    ListView lvTopNews;

    @Override
    public int getLayoutResource() {
        return R.layout.fragment_top;
    }

    @Override
    public void initData() {
        NetConnection.netConnetion(getActivity(), Config.COMMAND_TOP, Config.TYPE_NEWS,
                new NetConnection.DataCallback() {
                    @Override
                    public void doSuccess(String jsonData) {
                        mNewses = new Gson().fromJson(jsonData, AllData.class)
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

    }
}
