package com.haitao.www.myformer.nettys.netty;

public abstract class QResponseCall {
    public void onStart() {
    }

    public void onEnd() {
    }

    public abstract void onFailure(String arg0, int error);


    public abstract void onSuccess(int type, String result);

}
