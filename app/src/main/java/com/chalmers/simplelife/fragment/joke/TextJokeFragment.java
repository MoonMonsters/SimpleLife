package com.chalmers.simplelife.fragment.joke;

import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.chalmers.simplelife.R;
import com.chalmers.simplelife.adapter.JokeTextAdapter;
import com.chalmers.simplelife.bean.joke.Joke;
import com.chalmers.simplelife.bean.joke.JokeData;
import com.chalmers.simplelife.fragment.BaseFragment;
import com.chalmers.simplelife.utils.Config;
import com.chalmers.simplelife.utils.NetConnection;
import com.google.gson.Gson;

import java.util.ArrayList;

import butterknife.Bind;

/**
 * A simple {@link Fragment} subclass.
 */
public class TextJokeFragment extends BaseFragment {

    private int index = 1;
    private int pageSize = 20;
    private JokeTextAdapter mAdapter;
    private ArrayList<Joke> mJokes;

    @Bind(R.id.srl_fragment_joke_text)
    SwipeRefreshLayout srlFragmentJokeText;
    @Bind(R.id.lv_fragment_joke_text)
    ListView lvFragmentJokeText;
    @Override
    public int getLayoutResource() {
        return R.layout.fragment_text_joke;
    }

    @Override
    public void initData() {
        // 顶部刷新的样式
//        srlFragmentJokeText.setColorSchemeColors();

        mJokes = new ArrayList<>();
        mAdapter = new JokeTextAdapter(getActivity(),
                mJokes);
        lvFragmentJokeText.setAdapter(mAdapter);
        netGetData();
    }

    @Override
    public void initListener() {
        srlFragmentJokeText.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                index ++;
                netGetData();
            }
        });
    }

    private void netGetData(){
        NetConnection.netConnectionWithJoke(getActivity(), Config.URL_JOKE_DATA_TEXT,
                index, pageSize, new NetConnection.DataCallback() {
                    @Override
                    public void doSuccess(String jsonData) {
                        mJokes.addAll(0,new Gson().fromJson(jsonData, JokeData.class)
                                .getResult().getData());

                        mAdapter.notifyDataSetChanged();
                        Log.i("TextJokeFragment",mJokes.toString());
                        srlFragmentJokeText.setRefreshing(false);
                    }

                    @Override
                    public void doFail(String msg) {
                        Toast.makeText(getContext(),"网络连接错误",Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
