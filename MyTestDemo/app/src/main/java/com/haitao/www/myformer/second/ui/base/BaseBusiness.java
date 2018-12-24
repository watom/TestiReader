package com.haitao.www.myformer.second.ui.base;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;

import org.json.JSONObject;

/**
 *
 */
public abstract class BaseBusiness {

    protected Context context;
    //    发起请求
    public static final int START = -1;
    //    请求失败
    public static final int FAILURE = -2;
    //    请求失败不关闭进度条
    public static final int FAILURE_NOT_CLOSE_PROGRESS = -3;
    //    请求结束
    public static final int END = -4;
    //    重新登录
    public static final int RELOGIN = -5;
    private boolean isCloseProgress = true;


    protected void onStartHandler(Handler handler) {
        handler.sendEmptyMessage(START);
    }

    protected void onEndHandler(Handler handler) {
        if (isCloseProgress) {
            handler.sendEmptyMessage(END);
        }
    }

    protected void onFailureHandler(Context context, Handler handler, String msg, int errorCode) {
        onFailureDesc(context, handler, msg);
    }

    protected void onSuccessHandler(Context context, Handler handler, String result) {

        Log.d("isCloseProgress", Boolean.toString(isCloseProgress));
        BaseDataResp baseDataObj = parseBaseResp(context, result);
        Log.d("getData():", baseDataObj.getData());
        Log.d("getMessage():" , baseDataObj.getMessage());
        Log.d("getCode():" ,baseDataObj.getCode());
        baseParse(context, handler, baseDataObj);
    }

    protected void baseParse(Context context, Handler handler, BaseDataResp baseDataResp) {
        if (baseDataResp.getCode().equals("0000")) {
            getData(handler, baseDataResp);
        } else if (baseDataResp.getCode().equals("1002") || baseDataResp.getCode().equals("1005") || baseDataResp.getCode().equals("1004")) {
            sendHandler(handler, null, RELOGIN);

        } else {
            onFailureDesc(context, handler, baseDataResp.getMessage());
        }

    }

    public void onFailureDesc(Context context, Handler handler, String msg) {
        Log.d("isCloseProgress:" , Boolean.toString(isCloseProgress));
        if (isCloseProgress) {
            sendHandler(handler, msg, FAILURE);
        } else {
            sendHandler(handler, msg, FAILURE_NOT_CLOSE_PROGRESS);
        }

    }

    public abstract void getData(Handler handler, BaseDataResp baseDataResp);

    protected void sendHandler(Handler handler, Object object, int what) {
        Message msg = handler.obtainMessage();
        msg.obj = object;
        msg.what = what;
        handler.sendMessage(msg);
    }

    protected void setContext(Context context) {
        this.context = context;
    }

    protected BaseDataResp parseBaseResp(Context context, String responseStr) {

        BaseDataResp baseDataResp = null;
        try {
            if (TextUtils.isEmpty(responseStr)) {
                baseDataResp = new BaseDataResp("", "数据请求失败", "-1");
                return baseDataResp;
            }

            JSONObject jsonObject = new JSONObject(responseStr);
            String data = jsonObject.optString("data");
            String message = jsonObject.optString("message");
            String code = jsonObject.optString("code");
            baseDataResp = new BaseDataResp(data, message, code);


        } catch (Exception e) {
            baseDataResp = new BaseDataResp("", "数据解析失败", "-1");
        }

        return baseDataResp;
    }

    public String getFailureMsg() {
        return null;
    }

    /**
     * 将字符串分割开，注意方法 入参unSplitString 未分割字符串 入参way 表示方法"\\|"
     */
//    protected String[] mySplit(String unSplitString, String way) {
//        String[] splitedStrings = {""};
//        if (unSplitString.length() > 0) {
//            splitedStrings = unSplitString.substring(0,
//                    unSplitString.length() - 1).split(way, -1);
//        }
//        return splitedStrings;
//    }
//
//    public void getTag() {
//        getClass().getName();
//    }

    /**
     * 是否为ssl请求
     */
//    protected boolean getSsl() {
//        return Config.OPEN_SSL;
//    }

    /**
     * 业务请求数据添加前缀和后缀
     */
//    public String getCommonRequestStr(String requestEntity, String transcode) {
//        String commonRquestString;
//
//        StringBuffer buffer = new StringBuffer();
//        buffer.append(transcode + "|")
//                .append(requestEntity + "|");
//
//        int requeslen = buffer.toString().getBytes().length;
//        int strlen = (requeslen + "").length();
//
//        switch (strlen) {
//            case 1:
//                commonRquestString = "0000" + requeslen + buffer;
//                break;
//            case 2:
//                commonRquestString = "000" + requeslen + buffer;
//                break;
//            case 3:
//                commonRquestString = "00" + requeslen + buffer;
//                break;
//            case 4:
//                commonRquestString = "0" + requeslen + buffer;
//                break;
//            default:
//                commonRquestString = "" + requeslen + buffer;
//                break;
//        }
//        return commonRquestString;
//    }
//
//    protected void setCloseProgressBar(boolean b){
//       this.isCloseProgress=b;
//    }

}