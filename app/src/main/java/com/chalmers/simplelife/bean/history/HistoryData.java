package com.chalmers.simplelife.bean.history;

import java.util.ArrayList;

/**
 * Created by Chalmers on 2016-09-06 20:25.
 * email:qxinhai@yeah.net
 */
public class HistoryData {

    /** 错误码 */
    private int error_code;
    /**  */
    private String reason;
    private ArrayList<History> result;

    public HistoryData(int error_code, String reason, ArrayList<History> result) {
        this.error_code = error_code;
        this.reason = reason;
        this.result = result;
    }

    public HistoryData() {
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

    public ArrayList<History> getResult() {
        return result;
    }

    public void setResult(ArrayList<History> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "HistoryData{" +
                "error_code=" + error_code +
                ", reason='" + reason + '\'' +
                ", result=" + result +
                '}';
    }
}