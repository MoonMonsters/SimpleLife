package com.chalmers.simplelife.fragment.news;

import com.chalmers.simplelife.fragment.BaseFragment;
import com.chalmers.simplelife.utils.Config;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Chalmers on 2016-09-04 15:32.
 * email:qxinhai@yeah.net
 */
public class FragmentFactory {

    /** 头条 */
    public static final int TOP_FRAGMENT = 0;
    /** 社会 */
    public static final int SHEHUI_FRAGMENT = 1;
    /** 国内 */
    public static final int GUONEI_FRAGMENT = 2;
    /** 国际 */
    public static final int GUOJI_FRAGMENT = 3;
    /** 娱乐 */
    public static final int YULE_FRAGMENT = 4;
    /** 体育 */
    public static final int TIYU_FRAGMENT = 5;
    /** 军事 */
    public static final int JUNSHI_FRAGMENT = 6;
    /** 科技 */
    public static final int KEJI_FRAGMENT = 7;
    /** 财经 */
    public static final int CAIJING_FRAGMENT = 8;
    /** 时尚 */
    public static final int SHISHANG_FRAGMENT = 9;

    private static Map<Integer,BaseFragment> mFragments = new HashMap<>();

    public static BaseFragment newInstance(int fragmentType){
        BaseFragment fragment = mFragments.get(fragmentType);
        if(fragment != null){
            return fragment;
        }

        switch (fragmentType){
            case TOP_FRAGMENT:
                fragment = new AllNewsFragment().instance(Config.COMMAND_TOP);
                break;
            case SHEHUI_FRAGMENT:
                fragment = new AllNewsFragment().instance(Config.COMMAND_SHEHUI);
                break;
            case GUONEI_FRAGMENT:
                fragment = new AllNewsFragment().instance(Config.COMMAND_GUONEI);
                break;
            case GUOJI_FRAGMENT:
                fragment = new AllNewsFragment().instance(Config.COMMAND_GUOJI);
                break;
            case YULE_FRAGMENT:
                fragment = new AllNewsFragment().instance(Config.COMMAND_YULE);
                break;
            case TIYU_FRAGMENT:
                fragment = new AllNewsFragment().instance(Config.COMMAND_TIYU);
                break;
            case JUNSHI_FRAGMENT:
                fragment = new AllNewsFragment().instance(Config.COMMAND_JUNSHI);
                break;
            case KEJI_FRAGMENT:
                fragment = new AllNewsFragment().instance(Config.COMMAND_KEJI);
                break;
            case CAIJING_FRAGMENT:
                fragment = new AllNewsFragment().instance(Config.COMMAND_CAIJING);
                break;
            case SHISHANG_FRAGMENT:
                fragment = new AllNewsFragment().instance(Config.COMMAND_SHISHANG);
                break;
        }

        mFragments.put(fragmentType,fragment);

        return fragment;
    }

}
