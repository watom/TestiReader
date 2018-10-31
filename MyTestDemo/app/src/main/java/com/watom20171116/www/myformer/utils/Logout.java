package com.watom20171116.www.myformer.utils;

import android.util.Log;

import com.watom20171116.www.myformer.Config;

/**
 * Created by Administrator on 2017/12/6 0006.
 */

public class Logout {
    private static String mTag= "wanghaitao";//自定义APP的Log识别名称

    /**
     * log  debug
     * @param key 输入参数名
     * @param valueOrMsg 输出结果
     */
    public static void d(String key,String valueOrMsg) {
        if (Config.isPrintLog && Config.isDebug)
            Log.d(mTag, key+" ☚☚ ㊥ ☛☛ message:[" + valueOrMsg+"]");
    }

    /**
     * log  info
     * @param key 输入参数名
     * @param valueOrMsg 输出结果
     */
    public static void i(String key,String valueOrMsg) {
        if (Config.isPrintLog && Config.isDebug)
            Log.i(mTag, key+" ☚☚ ☯ ☛☛ message:[" + valueOrMsg+"]");
    }


    /**
     * log  error
     * @param key 输入参数名
     * @param valueOrMsg 输出结果
     */
    public static void e(String key,String valueOrMsg) {
        if (Config.isPrintLog && Config.isDebug)
            Log.e(mTag, key+" ☚☚ ☹ ☛☛ message:[" + valueOrMsg+"]");
    }

    /**
     * log  v
     * @param key 输入参数名
     * @param valueOrMsg 输出结果
     */
    public static void v(String key,String valueOrMsg) {
        if (Config.isPrintLog && Config.isDebug)
            Log.v(mTag, key+" ☚☚ ♬ ☛☛ message:[" + valueOrMsg+"]");
    }
}
