package com.haitao.www.myformer.nettys.netty;


/**
 * Created by quliang on 2017/9/14.
 * 独立于底层网络请求的获取业务数据接口
 */

public interface QDataStandard {
    void getData(String requestStr, boolean ssl, QResponseCall qResponseCall);
}
