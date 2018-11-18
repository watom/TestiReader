package com.haitao.www.myformer.utils;

import android.util.Log;

import com.haitao.www.myformer.Config;

/**
 * Created by Administrator on 2017/12/6 0006.
 */

public class Lout {
    private static String mTag= "wanghaitao";//自定义APP的Log识别名称

    /**
     * log  debug
     * @param key 输入参数名
     * @param valueOrMsg 输出结果
     */
    public static void d(String key,String valueOrMsg) {
        if (Config.isPrintLog && Config.isDebug)
            Log.d(mTag, key+"的值是：" + valueOrMsg+"\r\n");
    }

    /**
     * log  info
     * @param key 输入参数名
     * @param valueOrMsg 输出结果
     */
    public static void i(String key,String valueOrMsg) {
        if (Config.isPrintLog && Config.isDebug)
            Log.i(mTag, key+"的值是：" + valueOrMsg+"\r\n");
    }


    /**
     * log  error
     * @param key 输入参数名
     * @param valueOrMsg 输出结果
     */
    public static void e(String key,String valueOrMsg) {
        if (Config.isPrintLog && Config.isDebug)
            Log.e(mTag, key+"的值是：" + valueOrMsg+"\r\n");
    }

    /**
     * log  v
     * @param key 输入参数名
     * @param valueOrMsg 输出结果
     */
    public static void v(String key,String valueOrMsg) {
        if (Config.isPrintLog && Config.isDebug)
            Log.v(mTag, key+"的值是：" + valueOrMsg+"\r\n");
    }
}
