package com.haitao.www.myformer.second.ui.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.haitao.www.myformer.second.ui.ui_common.dialog.progressBar.LoadingDialog;

/**
 * Created by watom_Thinkpad on 2017/11/16.
 */

public abstract class BaseActivity extends AppCompatActivity {
    private LoadingDialog mProcessDialog;
    protected Handler handler;
    private MyBroadCast myBroadCast;//注册广播

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setTitleBar();
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        initHandler();
        initView();
        initData(savedInstanceState);
        initEvent();
        initAppMsgBroad();
    }

    /**
     * 设置标题栏
     */
    public void setTitleBar() {
        setBaseTitle();
    }

    /**
     * 加载初始化页面
     *
     * @return
     */
    public abstract int getContentView();

    /**
     * 初始化View
     */
    public abstract void initView();

    /**
     * 初始化数据
     */
    public abstract void initData(@Nullable Bundle savedInstanceState);

    /**
     * 注册监听事务
     */
    public abstract void initEvent();

    /**
     * 获取业务数据
     */
    protected abstract void updateData(Message msg);

    public abstract void initAppMsgBroad();

    protected void initHandler() {
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case BaseBusiness.START:
                        showProgressDialog();
                        break;

                    case BaseBusiness.FAILURE:
                        getDatafailure(msg.obj);
                        closeProgressDialog();
                        break;
                    case BaseBusiness.FAILURE_NOT_CLOSE_PROGRESS:
                        getDatafailure(msg.obj);
                        break;
                    case BaseBusiness.END:
                        closeProgressDialog();
                        break;
                    case BaseBusiness.RELOGIN:
                        closeProgressDialog();
                        ToastUtils.toastLong(getBaseContext(), getString(R.string.app_relogin));
                        relogin();
                        break;
                    default:
                        updateData(msg);
                        break;
                }
            }
        };

    }

    protected void setBaseTitle() {

    }

    /**
     * 可以根据需要发送消息
     */
    public void sendMsg(Handler handler, int what, Object object) {
        Message message = handler.obtainMessage();
        message.what = what;
        message.obj = object;
        handler.sendMessage(message);
    }

    private void initAppMsgBroad() {
        myBroadCast = new MyBroadCast(this, new String[]{"BROADCAST_LOGOUT"}, 0);
        myBroadCast.setOnMyBroadCastListener(new MyBroadCast.MyBroadCastListener() {
            @Override
            public void onReceive(BroadcastReceiver broadcastReceiver, Context context, Intent intent) {
                if (intent.getAction().equals(IntentFinal.BROADCAST_LOGOUT) && isFinish()) {
                    finish();
                }
            }

        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mProcessDialog != null) {
            mProcessDialog.dismiss();
        }
        if (myBroadCast != null) {
            myBroadCast.onDestroy();
        }
    }
}
