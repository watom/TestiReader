package com.watom20171116.www.myformer.second.ui.ui_common.dialog.dialogUtils;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.watom20171116.www.myformer.R;
import com.watom20171116.www.myformer.utils.Logout;
import com.watom20171116.www.myformer.utils.Util;


/**
 * Created by Administrator on 2018/8/23 0023.
 */

public class DialogUtils {
    private View view;
    private TextView btnleft, btnright, btn_sure;
    private TextView dialogTitleText, dialogContentText, dialogLeftBtn, dialogRightorokBtn;

    public DialogUtils() {
    }

    private static DialogUtils dialog = new DialogUtils();

    public static final DialogUtils getInstance() {
        return dialog;
    }

    public void call(final Context context, String content, String title, final OnClickRightButtonListen right, final OnClickLeftButtonListen left) {
        final Dialog dialog = new AlertDialog.Builder(context, R.style.mDialog_background).create();
        if (right != null && left != null && !Util.isEmpty(content) && !Util.isEmpty(title)) {
            view = LayoutInflater.from(context).inflate(R.layout.xa_dialog_custom, null);    //有title，有2个btn
        } else if (right != null && left != null && !Util.isEmpty(content)) {
            view = LayoutInflater.from(context).inflate(R.layout.xa_dialog_custom_03, null); //无title，有2个btn
        } else if (right != null && !Util.isEmpty(title)) {
            view = LayoutInflater.from(context).inflate(R.layout.xa_dialog_custom_04, null); //有title，有1个btn
        } else if (right != null) {
            view = LayoutInflater.from(context).inflate(R.layout.xa_dialog_custom_02, null); //无title，有1个btn
        } else {
            Logout.v("DialogUtils", "可以填充自定义布局的Dilog");
        }
        initView(view, content, title);
        dialog.show();
        dialog.setCancelable(false);
        dialog.getWindow().setContentView(view);

        if (dialogLeftBtn != null) {
            dialogLeftBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View arg0) {
                    if (left != null) {
                        left.onClick(dialog);
                        dialog.dismiss();
                    }
                }
            });
        }

        if (dialogRightorokBtn != null) {
            dialogRightorokBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View arg0) {
                    if (right != null) {
                        right.onClick(dialog);
                        dialog.dismiss();
                    }
                }
            });
        } else {
            Logout.v("DialogUtils", "其他类型的Dilog");
        }
    }

    private void initView(View view, String content, String title) {
        dialogTitleText = (TextView) view.findViewById(R.id.dialog_title_text);
        dialogContentText = (TextView) view.findViewById(R.id.dialog_content_text);
        dialogLeftBtn = (TextView) view.findViewById(R.id.dialog_left_btn);
        dialogRightorokBtn = (TextView) view.findViewById(R.id.dialog_rightorok_btn);
        if (!Util.isEmpty(content)) dialogContentText.setText(content);
        if (!Util.isEmpty(title)) dialogTitleText.setText(title);
    }

    public interface OnClickLeftButtonListen {
        void onClick(Dialog dialog);
    }

    public interface OnClickRightButtonListen {
        void onClick(Dialog dialog);
    }
}
