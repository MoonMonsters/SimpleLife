package com.chalmers.simplelife.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.chalmers.simplelife.R;
import com.chalmers.simplelife.bean.News;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Chalmers on 2016-09-04 21:31.
 * email:qxinhai@yeah.net
 */
public class NewsAdapter extends BaseAdapter {

    private ArrayList<News> mNewses;
    private Context mContext;

    public NewsAdapter(Context context, ArrayList<News> newses){
        this.mContext = context;
        this.mNewses = newses;
    }

    @Override
    public int getCount() {
        return mNewses.size();
    }

    @Override
    public Object getItem(int position) {
        return mNewses.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        if(convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_news,parent,false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.bindData(mNewses.get(position));

        return convertView;
    }

    class ViewHolder{

        @Bind(R.id.iv_news_pic)
        ImageView ivNewsPic;
        @Bind(R.id.tv_news_title)
        TextView tvNewsTitle;
        @Bind(R.id.tv_news_author)
        TextView tvNewsAuthor;
        @Bind(R.id.tv_news_date)
        TextView tvNewsDate;

        public ViewHolder(View view){
            ButterKnife.bind(this,view);
        }

        public void bindData(News news){
            Picasso.with(mContext)
                    .load(news.getThumbnail_pic_s())
                    .into(ivNewsPic);
            tvNewsTitle.setText(news.getTitle());
            tvNewsAuthor.setText(news.getAuthor_name());
            tvNewsDate.setText(news.getDate());
        }

    }
}
