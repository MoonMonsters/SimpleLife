package com.chalmers.simplelife.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.chalmers.simplelife.R;
import com.chalmers.simplelife.bean.history.History;
import com.chalmers.simplelife.view.CircleDot;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Chalmers on 2016-09-06 22:15.
 * email:qxinhai@yeah.net
 */
public class HistoryAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private ArrayList<History> mHistories;

    public HistoryAdapter(Context context, ArrayList<History> histories){
        this.mContext = context;
        this.mHistories = histories;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_history,parent,false);

        MyViewHolder vh = new MyViewHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((MyViewHolder)holder).bindData(mHistories.get(position));
    }

    @Override
    public int getItemCount() {
        return mHistories.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        @Bind(R.id.cd_fragment_history)
        CircleDot cdHistory;
        @Bind(R.id.tv_history_title)
        TextView tvHistoryTitle;
        @Bind(R.id.tv_history_content)
        TextView tvHistoryContent;
        @Bind(R.id.iv_history_img)
        ImageView ivHistoryImg;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }


        public void bindData(History history){

            Log.i("TAG",history.toString());

            cdHistory.setData(mHistories.indexOf(history) + 1);
            tvHistoryTitle.setText(history.getTitle());
            tvHistoryContent.setText(history.getDes());
            if(!TextUtils.isEmpty(history.getPic())){
                Picasso.with(mContext)
                        .load(history.getPic())
                        .into(ivHistoryImg);
            }
        }
    }
}
