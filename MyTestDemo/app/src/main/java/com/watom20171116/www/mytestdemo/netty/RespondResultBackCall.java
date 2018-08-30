package com.watom20171116.www.mytestdemo.netty;

/**
 * Created by Administrator on 2018/2/5 0005.
 */

public abstract class RespondResultBackCall {
    public void onStart() {}

    public void onEnd() {}

    public abstract void onFailure(String arg0, int error);

    public abstract void onSuccess(int type, String result);
}
