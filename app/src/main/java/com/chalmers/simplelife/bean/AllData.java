package com.chalmers.simplelife.bean;

/**
 * Created by Chalmers on 2016-09-04 19:29.
 * email:qxinhai@yeah.net
 */
public class AllData {

    private String reason;
    private Result result;
    private int error_code;

    public AllData(String reason, Result result, int error_code) {
        this.reason = reason;
        this.result = result;
        this.error_code = error_code;
    }

    public AllData(){}

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }
}
