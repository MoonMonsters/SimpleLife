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

    public static void netConnetion(Context context, String command, int type, final DataCallback dataCallback){

        String url = "http://v.juhe.cn/toutiao/index?type="+command+"&key="+Config.NEWS_APP_KEY;
        final RequestQueue requestQueue = Volley.newRequestQueue(context);
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

    public interface DataCallback{
        void doSuccess(String jsonData);
        void doFail(String msg);
    }
}
