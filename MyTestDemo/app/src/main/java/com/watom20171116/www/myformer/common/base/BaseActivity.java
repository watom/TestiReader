package com.watom20171116.www.myformer.common.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.watom20171116.www.myformer.R;

/**
 * 1、为titleBar的统一格式，添加监听事件
 * 2、
 * 说明：1.BaseActivity是基类
 * 2.去掉自带的titlebar只需要在风格或者主题中处理，
 */
public class BaseActivity extends FragmentActivity implements BaseActivityAction, View.OnClickListener {
    private RelativeLayout rlTitle;
    private ImageView ivTitleRight;
    private TextView tvTitle;
    private LinearLayout llBackContainer;
    private ImageView ivBack;
    private TextView tvLeft;
    private ImageView ivBackRight;
    private LinearLayout llRight;
    private TextView tvRight;
    private ImageView imageview1;
    private ImageView imageview2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initTitle() {

    }

    @Override
    public void initView() {
        rlTitle = (RelativeLayout) findViewById(R.id.rl_title);
        ivTitleRight = (ImageView) findViewById(R.id.iv_title_right);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        llBackContainer = (LinearLayout) findViewById(R.id.ll_back_container);
        ivBack = (ImageView) findViewById(R.id.iv_back);
        tvLeft = (TextView) findViewById(R.id.tv_left);
        ivBackRight = (ImageView) findViewById(R.id.iv_back_right);
        llRight = (LinearLayout) findViewById(R.id.ll_right);
        tvRight = (TextView) findViewById(R.id.tv_right);
        imageview1 = (ImageView) findViewById(R.id.imageview_1);
        imageview2 = (ImageView) findViewById(R.id.imageview_2);
    }

    @Override
    public void setListener() {

    }

    @Override
    public void setTitleText(String text) {

    }

    @Override
    public void changeRightButtonState(int state) {

    }

    @Override
    public void editRightButtonBg(int id) {

    }

    @Override
    public void changeLeftButtonState(int state) {

    }

    @Override
    public void editLeftButtonBg(int id) {

    }

    @Override
    public void hiddenTImage() {

    }

    @Override
    public void onClick(View view) {

    }
}
