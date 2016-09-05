package com.chalmers.simplelife.utils;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

/**
 * Created by Chalmers on 2016-09-04 15:02.
 * email:qxinhai@yeah.net
 */
public class NetConnection {

    /**
     * 新闻的请求数据
     * @param context 上下文对象
     * @param command 请求的数据类型
     * @param dataCallback 回调方法
     */
    public static void netConnectionWithNews(Context context, String command, final DataCallback dataCallback){

        String url = Config.URL_NEWS_DATA+"?type="+command+"&key="+Config.NEWS_APP_KEY;
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                dataCallback.doSuccess(response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                dataCallback.doFail(error.getMessage());
            }
        }));
    }

    /**
     * 获得笑话大全的数据
     * @param context 上下文对象
     * @param url 访问url，因为有两种类型，文字笑话和图片笑话
     * @param page 页数
     * @param pageSize 每次访问的条数
     * @param dataCallback 回调
     */
    public static void netConnectionWithJoke(Context context, String url, int page, int pageSize, final DataCallback dataCallback){
        String mUrl = url + "?page="+page+"&pagesize="+pageSize+"&key="+Config.JOKE_APP_KEY;
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(new JsonObjectRequest(Request.Method.GET, mUrl, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                dataCallback.doSuccess(response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                dataCallback.doFail(error.getMessage());
            }
        }));
    }

    public interface DataCallback{
        void doSuccess(String jsonData);
        void doFail(String msg);
    }
}
