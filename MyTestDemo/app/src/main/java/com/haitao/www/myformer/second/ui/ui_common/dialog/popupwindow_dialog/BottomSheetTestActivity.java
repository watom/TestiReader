package com.haitao.www.myformer.second.ui.ui_common.dialog.popupwindow_dialog;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.haitao.www.myformer.R;

public class BottomSheetTestActivity extends AppCompatActivity {

    private BottomSheetBehavior bottomSheetBehavior;
    private View bottomSheetLayout;
    private TextView tvBottomContent;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_sheet);
        initView();
        initData();
        initEvent();
    }

    private void initView() {
        bottomSheetLayout = findViewById(R.id.bottom_sheet_layout);
        tvBottomContent = findViewById(R.id.tv_bottom_content);
    }

    private void initData() {
        //把这个底部菜单和一个BottomSheetBehavior关联起来
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheetLayout);
    }

    private void initEvent() {
        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                if (newState == BottomSheetBehavior.STATE_EXPANDED) {
                    tvBottomContent.setText("你好");
                } else {
                    tvBottomContent.setText("世界");
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });
    }
}
