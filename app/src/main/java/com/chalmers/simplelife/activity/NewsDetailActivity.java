package com.chalmers.simplelife.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.chalmers.simplelife.R;
import com.chalmers.simplelife.utils.Config;

import butterknife.Bind;
import butterknife.ButterKnife;

public class NewsDetailActivity extends AppCompatActivity {

    @Bind(R.id.wv_news_detail_content)
    WebView wvNewsDetailContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        ButterKnife.bind(this);

        String url = getIntent().getStringExtra(Config.URL_NEWS_DETAIL_INTENT);

        wvNewsDetailContent.getSettings().setJavaScriptEnabled(true);
        wvNewsDetailContent.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                view.loadUrl(url);

                return true;
            }
        });
        wvNewsDetailContent.loadUrl(url);
    }
}
