package com.chalmers.simplelife.fragment;


import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.widget.Toast;

import com.chalmers.simplelife.R;
import com.chalmers.simplelife.adapter.HistoryAdapter;
import com.chalmers.simplelife.bean.history.History;
import com.chalmers.simplelife.bean.history.HistoryData;
import com.chalmers.simplelife.utils.NetConnection;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Calendar;

import butterknife.Bind;

/**
 * A simple {@link Fragment} subclass.
 */
public class HistoryFragment extends BaseFragment {

    private ArrayList<History> mHistories;
    private HistoryAdapter mAdapter;
    @Bind(R.id.rv_fragment_history)
    RecyclerView rvFragmentHistory;


    @Override
    public int getLayoutResource() {
        return R.layout.fragment_history;
    }

    @Override
    public void initData() {

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        int month = (calendar.get(Calendar.MONTH) + 1);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        NetConnection.netConnectionWithHistory(getContext(), month, day, new NetConnection.DataCallback() {
            @Override
            public void doSuccess(String jsonData) {
                mHistories = new Gson().fromJson(jsonData, HistoryData.class)
                        .getResult();

                Log.i("HistoryFragment",mHistories.toString());

                rvFragmentHistory.setHasFixedSize(true);
//                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                GridLayoutManager manager = new GridLayoutManager(getContext(),2);
                StaggeredGridLayoutManager manager1 = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
                rvFragmentHistory.setLayoutManager(manager1);
                mAdapter = new HistoryAdapter(getContext(),mHistories);
                rvFragmentHistory.setAdapter(mAdapter);
            }

            @Override
            public void doFail(String msg) {
                Toast.makeText(getContext(),"网络连接错误",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void initListener() {

    }
}
