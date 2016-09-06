package com.chalmers.simplelife.bean.history;

/**
 * Created by Chalmers on 2016-09-06 20:25.
 * email:qxinhai@yeah.net
 */
public class History {

    /** id */
    private String _id;
    /** 年 */
    private int year;
    /** 月 */
    private int month;
    /** 日 */
    private int day;
    /** 具体事件 */
    private String des;
    /** 未知 */
    private String lunar;
    /** 图片 */
    private String pic;
    /** 标题 */
    private String title;

    public History(String _id, int year, int month, int day,
                   String des, String lunar, String pic, String title) {
        this._id = _id;
        this.year = year;
        this.month = month;
        this.day = day;
        this.des = des;
        this.lunar = lunar;
        this.pic = pic;
        this.title = title;
    }

    public History(){}

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getLunar() {
        return lunar;
    }

    public void setLunar(String lunar) {
        this.lunar = lunar;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "History{" +
                "_id='" + _id + '\'' +
                ", year=" + year +
                ", month=" + month +
                ", day=" + day +
                ", des='" + des + '\'' +
                ", lunar='" + lunar + '\'' +
                ", pic='" + pic + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
