package com.haitao.www.myformer.netty;

/**
 * Created by Administrator on 2018/2/1 0001.
 */

public class BaseRequest {

    private int statusCode = -1; //0:成功执行业务逻辑 -1:失败提示
    private String returnCode; //-1:解析基础数据失败 或 服务器返回数据为空
    private String msg;
    private String success;
    private String requestCode;

    public BaseRequest() {
    }

    public BaseRequest(String msg) {
        this.msg = msg;
    }

    public BaseRequest(String returnCode, String msg, String success, String requestCode) {
        this.returnCode = returnCode;
        this.msg = msg;
        this.success = success;
        this.requestCode = requestCode;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getRequestCode() {
        return requestCode;
    }

    public void setRequestCode(String requestCode) {
        this.requestCode = requestCode;
    }
}
