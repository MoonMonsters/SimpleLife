package com.chalmers.simplelife.bean.joke;

import java.util.ArrayList;

/**
 * Created by Chalmers on 2016-09-05 19:31.
 * email:qxinhai@yeah.net
 */
public class JokeResult {

    private ArrayList<Joke> data;

    public JokeResult(ArrayList<Joke> data) {
        this.data = data;
    }

    public JokeResult(){}

    public ArrayList<Joke> getData() {
        return data;
    }

    public void setData(ArrayList<Joke> data) {
        this.data = data;
    }

}
