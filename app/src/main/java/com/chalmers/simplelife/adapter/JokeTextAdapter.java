package com.chalmers.simplelife.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.chalmers.simplelife.R;
import com.chalmers.simplelife.bean.joke.Joke;
import com.chalmers.simplelife.view.CircleDot;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Chalmers on 2016-09-05 21:32.
 * email:qxinhai@yeah.net
 */
public class JokeTextAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<Joke> mJokes;

    public JokeTextAdapter(Context context, ArrayList<Joke> jokes){
        this.mContext = context;
        this.mJokes = jokes;
    }

    @Override
    public int getCount() {
        return mJokes.size();
    }

    @Override
    public Object getItem(int position) {
        return mJokes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        if(convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_joke_text,parent,false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.bindData(mJokes.get(position));

        return convertView;
    }

    class ViewHolder{
        @Bind(R.id.cd_fragment_joke_text)
        CircleDot cdFragmentJokeText;
        @Bind(R.id.tv_fragment_joke_text)
        TextView tvFragmentJokeText;

        public ViewHolder(View view){
            ButterKnife.bind(this,view);
        }

        public void bindData(Joke joke){
            cdFragmentJokeText.setData(mJokes.indexOf(joke) + 1);
            tvFragmentJokeText.setText(joke.getContent());
        }
    }
}
