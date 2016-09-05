package com.chalmers.simplelife.fragment.joke;


import android.support.v4.app.Fragment;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.Toast;

import com.chalmers.simplelife.R;
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
public class ImgJokeFragment extends BaseFragment {

//    @Bind(R.id.iv_fragment_joke_img)
//    ImageView ivImg;
    @Bind(R.id.wv_fragment_joke_img)
    WebView wvJokeImg;
    @Bind(R.id.iv_fragment_joke_left)
    ImageView ivLeft;
    @Bind(R.id.iv_fragment_joke_right)
    ImageView ivRight;

    private int page = 1;
    private int pageSize = 20;
    private int index = 0;
    private ArrayList<Joke> mJokes;

    @Override
    public int getLayoutResource() {
        return R.layout.fragment_img_joke;
    }

    @Override
    public void initData() {
        NetConnection.netConnectionWithJoke(getActivity(), Config.URL_JOKE_DATA_IMG,
                page, pageSize, new NetConnection.DataCallback() {
                    @Override
                    public void doSuccess(String jsonData) {
                        mJokes = new Gson().fromJson(jsonData, JokeData.class)
                                .getResult().getData();
                        setShowImage();
                    }

                    @Override
                    public void doFail(String msg) {

                    }
                });
    }

    @Override
    public void initListener() {
        ImgClickListener imgClickListener = new ImgClickListener();
        ivLeft.setOnClickListener(imgClickListener);
        ivRight.setOnClickListener(imgClickListener);
    }

    private void setShowImage(){
//        Picasso.with(getActivity())
//                .load(mJokes.get(index).getUrl())
//                .into(ivImg);
//        Glide.with(getContext())
//                .load(mJokes.get(index).getUrl())
//                .asGif()
//                .error(R.drawable.home1)
//                .into(ivImg);
        wvJokeImg.getSettings().setJavaScriptEnabled(true);
        wvJokeImg.loadUrl(mJokes.get(index).getUrl());
    }

    class ImgClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            if(v == ivLeft){
                if(index == 0){
                    Toast.makeText(getActivity(),"已经是第一张",Toast.LENGTH_SHORT).show();
                    return ;
                }
                index --;
            }else if(v == ivRight){
                if(index == mJokes.size() - 1){
                    Toast.makeText(getActivity(),"已经是最后一张",Toast.LENGTH_SHORT).show();
                    return ;
                }
                index ++;
            }

            setShowImage();
        }
    }

}
