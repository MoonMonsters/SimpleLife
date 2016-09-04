package com.chalmers.simplelife.fragment.news;

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
                fragment = new TopFragment();
                break;
            case SHEHUI_FRAGMENT:
                fragment = new ShehuiFragment();
                break;
            case GUONEI_FRAGMENT:
                fragment = new GuoneiFragment();
                break;
            case GUOJI_FRAGMENT:
                fragment = new GuojiFragment();
                break;
            case YULE_FRAGMENT:
                fragment = new YuleFragment();
                break;
            case TIYU_FRAGMENT:
                fragment = new TiyuFragment();
                break;
            case JUNSHI_FRAGMENT:
                fragment = new JunshiFragment();
                break;
            case KEJI_FRAGMENT:
                fragment = new KejiFragment();
                break;
            case CAIJING_FRAGMENT:
                fragment = new CaijingFragment();
                break;
            case SHISHANG_FRAGMENT:
                fragment = new ShishangFragment();
                break;
        }

        mFragments.put(fragmentType,fragment);

        return fragment;
    }

}
