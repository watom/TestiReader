package com.watom20171116.www.mytestdemo.netty;

import android.content.Context;
import android.os.Handler;

/**
 * Created by Administrator on 2018/2/1 0001.
 */

public interface BaseBusiness {
    void onStartHandler(Handler handler);

    void onFailureHandler(Handler handler, String msg, int errorCode);

    void onSuccessHandler(Context context, Handler handler, String result);

    void onEndHandler(Handler handler);
}
