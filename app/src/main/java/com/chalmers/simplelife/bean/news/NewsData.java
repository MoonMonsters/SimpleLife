package com.chalmers.simplelife.bean.news;

/**
 * Created by Chalmers on 2016-09-04 19:29.
 * email:qxinhai@yeah.net
 */
public class NewsData {

    private String reason;
    private NewsResult result;
    private int error_code;

    public NewsData(String reason, NewsResult result, int error_code) {
        this.reason = reason;
        this.result = result;
        this.error_code = error_code;
    }

    public NewsData(){}

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public NewsResult getResult() {
        return result;
    }

    public void setResult(NewsResult result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }
}
