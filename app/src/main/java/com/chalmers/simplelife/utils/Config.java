package com.chalmers.simplelife.utils;

/**
 * Created by Chalmers on 2016-09-04 15:02.
 * email:qxinhai@yeah.net
 */
public interface Config {

    /** 新闻的key值 */
    String NEWS_APP_KEY = "8ec1050ffa00100ec72d4a97ff9bf996";
    /** 笑话的key值 */
    String JOKE_APP_KEY = "99385a3fd731442fa2e26764b64c51aa";
    /** 历史的key值 */
    String HISTORY_APP_KEY = "269e331628300599ee835b9cf983bb4d";

    /** 从Fragment中传递数据到Activity中的key值 */
    String URL_NEWS_DETAIL_INTENT = "url_news_detail";

    /** 获取新闻的url */
    String URL_NEWS_DATA = "http://v.juhe.cn/toutiao/index";
    /** 文字笑话接口 */
    String URL_JOKE_DATA_TEXT = "http://japi.juhe.cn/joke/content/text.from";
    /** 图片笑话接口 */
    String URL_JOKE_DATA_IMG = "http://japi.juhe.cn/joke/img/text.from";
    /** 获取历史上的今天数据接口 */
    String URL_HISTORY_DATA = "http://api.juheapi.com/japi/toh";

    /** 头条 */
    String COMMAND_TOP = "top";
    /** 社会 */
    String COMMAND_SHEHUI = "shehui";
    /** 国内 */
    String COMMAND_GUONEI = "guonei";
    /** 国际 */
    String COMMAND_GUOJI = "guoji";
    /** 娱乐 */
    String COMMAND_YULE = "yule";
    /** 体育 */
    String COMMAND_TIYU = "tiyu";
    /** 军事 */
    String COMMAND_JUNSHI = "junshi";
    /** 科技 */
    String COMMAND_KEJI = "keji";
    /** 财经 */
    String COMMAND_CAIJING = "caijing";
    /** 时尚 */
    String COMMAND_SHISHANG = "shishang";
}
