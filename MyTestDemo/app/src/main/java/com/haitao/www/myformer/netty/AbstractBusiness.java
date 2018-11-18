package com.haitao.www.myformer.netty;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

/**
 * 根据回调的数据，处理公共的业务逻辑
 * 2个抽象方法：getData(Handler handler, BaseRequest baseRequest)
 * parseBaseRequest(Context context, String data)
 * Created by Administrator on 2018/2/1 0001.
 */

public abstract class AbstractBusiness implements BaseBusiness {
    protected Context context;
    public static final int START = -1;                         //    发起请求
    public static final int FAILURE = -2;                       //    请求失败
    public static final int FAILURE_NOT_CLOSE_PROGRESS = -3;    //    请求失败不关闭进度条
    public static final int END = -4;                           //    请求结束
    private boolean isCloseProgress = true;

    public AbstractBusiness() {super();}

    protected void setContext(){this.context=context;}
    protected void getTag(){getClass().getName();}

    public abstract void getData(Handler handler, BaseRequest baseRequest);
    public abstract BaseRequest parseBaseRequest(Context context, String data);


    @Override
    public void onStartHandler(Handler handler) {
        handler.sendEmptyMessage(START);
    }

    @Override
    public void onFailureHandler(Handler handler, String msg, int errorCode) {

    }

    @Override
    public void onSuccessHandler(Context context, Handler handler, String result) {
        BaseRequest baseRequest = parseBaseRequest(context, result);
        baseRequestDispose(handler,baseRequest);
    }

    /**
     * 分状态处理请求数据
     * @param handler
     * @param baseRequest
     */
    private void baseRequestDispose(Handler handler, BaseRequest baseRequest) {
        if (baseRequest.getStatusCode()==0){
            getData(handler,baseRequest);
        }else {
            onRequestFailure(handler,baseRequest);
        }
    }

    /**
     * 当数据请求失败时，关闭进度条、发送失败消息等
     * @param handler
     * @param baseRequest
     */
    private void onRequestFailure(Handler handler, BaseRequest baseRequest) {

    }

    @Override
    public void onEndHandler(Handler handler) {

    }

    protected void sendHandler(Handler handler,Object object, int what){
        Message message = handler.obtainMessage();
        message.obj=object;
        message.what=what;
        handler.sendMessage(message);
    }
}
