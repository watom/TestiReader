package com.watom20171116.www.mytestdemo.utils;

import android.util.Log;

import com.watom20171116.www.mytestdemo.Config;

/**
 * Created by Administrator on 2017/12/6 0006.
 */

public class Logout {
    private static String mTag= "wanghaitao";//自定义APP的Log识别名称

    /**
     * log  debug
     * @param tag
     * @param msg
     */
    public static void d(String tag,String msg) {
        if (Config.isPrintLog && Config.isDebug)
            Log.d(mTag, tag+" ☚☚ ㊥ ☛☛ message:[" + msg+"]");
    }

    /**
     * log  info
     * @param tag
     * @param msg
     */
    public static void i(String tag,String msg) {
        if (Config.isPrintLog && Config.isDebug)
            Log.i(mTag, tag+" ☚☚ ☯ ☛☛ message:[" + msg+"]");
    }


    /**
     * log  error
     * @param tag
     * @param msg
     */
    public static void e(String tag,String msg) {
        if (Config.isPrintLog && Config.isDebug)
            Log.e(mTag, tag+" ☚☚ ☹ ☛☛ message:[" + msg+"]");
    }

    /**
     * log  v
     * @param tag
     * @param msg
     */
    public static void v(String tag,String msg) {
        if (Config.isPrintLog && Config.isDebug)
            Log.v(mTag, tag+" ☚☚ ♬ ☛☛ message:[" + msg+"]");
    }
}
