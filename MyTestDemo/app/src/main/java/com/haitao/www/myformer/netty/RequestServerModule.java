package com.haitao.www.myformer.netty;

/**
 * 定义请求服务器的抽象方式
 * Created by Administrator on 2018/2/5 0005.
 */

public interface RequestServerModule {
   //获取请求方式
   RequestServerMethod getRequestMethod();
}
