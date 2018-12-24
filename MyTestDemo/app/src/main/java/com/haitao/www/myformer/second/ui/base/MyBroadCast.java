package com.haitao.www.myformer.second.ui.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/**
 *
 */
public class MyBroadCast {
    private MyBroadCastListener myBroadCastListener;
    private AppBroadCast        appBroadCast;
    private String[]            actions;
    private Context context;
    private int                 priority;

    public MyBroadCast(Context context, String[] actions, int priority) {
        this.actions = actions;
        this.context = context;
        this.priority = priority;
        init();
    }

    private void init() {
        appBroadCast = new AppBroadCast();
        IntentFilter mIntentFilter = new IntentFilter();
        mIntentFilter.setPriority(priority);
        for (String action : actions) {
            mIntentFilter.addAction(action);
        }
        context.registerReceiver(appBroadCast, mIntentFilter);

    }

    private class AppBroadCast extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (myBroadCastListener != null)
                myBroadCastListener.onReceive(this, context, intent);
        }
    }

    public void setOnMyBroadCastListener(MyBroadCastListener myBroadCastListener) {
        this.myBroadCastListener = myBroadCastListener;
    }

    public interface MyBroadCastListener {
        void onReceive(BroadcastReceiver broadcastReceiver, Context context, Intent intent);
    }

    public void onDestroy() {
        if (appBroadCast != null)
            context.unregisterReceiver(appBroadCast);
    }
}
