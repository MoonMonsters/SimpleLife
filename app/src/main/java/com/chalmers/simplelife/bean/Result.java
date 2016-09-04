package com.chalmers.simplelife.bean;

import java.util.ArrayList;

/**
 * Created by Chalmers on 2016-09-04 19:29.
 * email:qxinhai@yeah.net
 */
public class Result {

    private String stat;
    private ArrayList<News> data;

    public Result(String stat, ArrayList<News> data) {
        this.stat = stat;
        this.data = data;
    }

    public Result(){}

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public ArrayList<News> getData() {
        return data;
    }

    public void setData(ArrayList<News> data) {
        this.data = data;
    }
}
