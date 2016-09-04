package com.chalmers.simplelife.utils;

/**
 * Created by Chalmers on 2016-09-04 15:02.
 * email:qxinhai@yeah.net
 */
public interface Config {

    /** 新闻类型 */
    int TYPE_NEWS = 0;
    /** 笑话类型 */
    int TYPE_JOKE = 1;
    /** 历史类型 */
    int TYPE_HISTORY = 2;

    /** 新闻的key值 */
    String NEWS_APP_KEY = "8ec1050ffa00100ec72d4a97ff9bf996";
    /** 笑话的key值 */
    String JOKE_APP_KEY = "99385a3fd731442fa2e26764b64c51aa";
    /** 历史的key值 */
    String HISTORY_APP_KEY = "269e331628300599ee835b9cf983bb4d";

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