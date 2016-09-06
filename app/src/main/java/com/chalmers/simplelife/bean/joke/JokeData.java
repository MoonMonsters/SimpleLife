package com.chalmers.simplelife.bean.joke;

/**
 * Created by Chalmers on 2016-09-05 19:31.
 * email:qxinhai@yeah.net
 */
public class JokeData {

    private int error_code;
    private String reason;
    private JokeResult result;

    public JokeData(int error_code, String reason, JokeResult result) {
        this.error_code = error_code;
        this.reason = reason;
        this.result = result;
    }

    public JokeData() {
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public JokeResult getResult() {
        return result;
    }

    public void setResult(JokeResult result) {
        this.result = result;
    }
}
