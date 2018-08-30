package com.watom20171116.www.mytestdemo.netty;

import android.content.Context;

/**
 *
 * Created by Administrator on 2018/2/5 0005.
 */

public class CommonRequstEntity {

    private Context context;
    private String data;
    private String requestCode;
    private String versionCode;

    public CommonRequstEntity(Context context) {
        this.context = context;
    }

    public CommonRequstEntity(Context context, String data, String requestCode) {
        this.context = context;
        this.data = data;
        this.requestCode = requestCode;
    }

    public CommonRequstEntity(Context context, String data, String requestCode, String versionCode) {
        this.context = context;
        this.data = data;
        this.requestCode = requestCode;
        this.versionCode = versionCode;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getRequestCode() {
        return requestCode;
    }

    public void setRequestCode(String requestCode) {
        this.requestCode = requestCode;
    }

    public String getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(String versionCode) {
        this.versionCode = versionCode;
    }

    @Override
    public String toString() {
        return "CommonRequstEntity{" +
                "context=" + context +
                ", data='" + data + '\'' +
                ", requestCode='" + requestCode + '\'' +
                ", versionCode='" + versionCode + '\'' +
                '}';
    }


}
