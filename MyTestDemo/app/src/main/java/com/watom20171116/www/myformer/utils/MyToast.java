package com.watom20171116.www.myformer.utils;

import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;

import com.watom20171116.www.myformer.R;

public class MyToast extends Toast {

    public static Toast toast;

    public MyToast(Context context) {
        super(context);
    }

    /**
     * 显示操作失败的提示
     * @param mContext 上下文
     * @param result   结果
     */
    public static void showFailToast(Context mContext, int result) {
        toast = Toast.makeText(mContext, "", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        if (result == -3) {
            toast.setText("网络连接失败");
        } else if (result == -2) {
            toast.setText("访问超时");
        } else {
            toast.setText("系统临时维护，请稍候尝试!\\n给您带来的不便敬请谅解!");
        }
        toast.show();
    }

    /**
     * 显示提示信息--通过id
     * @param mContext 上下文
     * @param id       字符串id
     */
    public static void showToast(Context mContext, int id) {
        toast = Toast.makeText(mContext, id, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setText(id);
        toast.show();
    }

    /**
     * 显示提示信息--通过字符串
     * @param mContext 上下文
     * @param content  字符串
     */
    public static void showToast(Context mContext, String content) {
        if (!Util.isEmpty(content)) {
            toast = Toast.makeText(mContext, content, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.setText(content);
            toast.show();
            Logout.i(mContext.toString(), content);
        } else {

        }
    }
}
