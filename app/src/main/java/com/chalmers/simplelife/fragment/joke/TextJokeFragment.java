package com.chalmers.simplelife.fragment.joke;


import android.support.v4.app.Fragment;
import android.widget.ListView;

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

    private ArrayList<Joke> mJokes;

    @Bind(R.id.lv_fragment_joke_text)
    ListView lvFragmentJokeText;

    @Override
    public int getLayoutResource() {
        return R.layout.fragment_text_joke;
    }

    @Override
    public void initData() {
        NetConnection.netConnectionWithJoke(getActivity(), Config.URL_JOKE_DATA_TEXT,
                index, pageSize, new NetConnection.DataCallback() {
                    @Override
                    public void doSuccess(String jsonData) {
                        mJokes = new Gson().fromJson(jsonData, JokeData.class)
                                .getResult().getData();

                        JokeTextAdapter adapter = new JokeTextAdapter(getActivity(),
                                mJokes);
                        lvFragmentJokeText.setAdapter(adapter);
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
