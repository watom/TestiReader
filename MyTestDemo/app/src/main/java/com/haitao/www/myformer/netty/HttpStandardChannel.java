package com.haitao.www.myformer.netty;

/**
 * 封装抽象逻辑
 * Created by Administrator on 2018/2/5 0005.
 */

public abstract class HttpStandardChannel extends HttpBusiness implements RequestServerModule {
    //返回需要网络请求方式
    public RequestServerMethod getRequestMethod() {
        return null;
    }

}
