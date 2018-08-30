package com.watom20171116.www.mytestdemo.utils;

import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;

import com.watom20171116.www.mytestdemo.R;

public class MyToast extends Toast {

    public static Toast toast;

    public MyToast(Context context) {
        super(context);
    }

    /**
     * 显示操作失败的提示
     *
     * @param mContext 上下文
     * @param result   结果
     */
    public static void showFailToast(Context mContext, int result) {
//		if (toast==null) {
//
//		}

        toast = Toast.makeText(mContext, "", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        if (result == -3) {
            toast.setText("网络连接失败");
        } else if (result == -2) {
            toast.setText("访问超时");
        } else {
            //	toast.setText(R.string.common_operatefail);
        }
        toast.show();
    }

    /**
     * 显示提示信息——通过id
     *
     * @param mContext
     * @param id       字符串id
     */
    public static void showToast(Context mContext, int id) {
        toast = Toast.makeText(mContext, id, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setText(id);
        toast.show();
    }

    /**
     * 显示提示信息——通过字符串
     *
     * @param mContext
     * @param content  字符串
     */
    public static void showToast(Context mContext, String content) {
        /**-----------------解决返回为空----------**/
        if (null != content && !"".equals(content)) {
            toast = Toast.makeText(mContext, content, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.setText(content);
            toast.show();
            Logout.i(mContext.toString(), content);
        } else {

        }
    }


}
