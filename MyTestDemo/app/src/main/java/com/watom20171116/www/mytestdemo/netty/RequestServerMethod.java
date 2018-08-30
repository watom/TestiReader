package com.watom20171116.www.mytestdemo.netty;

/**
 * 定义请求参数，发起网络请求
 * Created by Administrator on 2018/2/5 0005.
 */

public abstract class RequestServerMethod implements Runnable {

    /**
     * 定义：（设置请求参数requstEntity，返回数据回调respondBackCall）
     */
    public abstract RequestServerMethod getRequestQarameter(CommonRequstEntity requstEntity,RespondResultBackCall respondBackCall);

    //发起网络请求
    public void startRequest(){
        new Thread().start();
    }
}
