package com.haitao.www.myformer.second.ui.ui_common.component.customassemblewidget;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.haitao.www.myformer.R;

/**
 * 自定义组合控件的activity展示界面
 * 注意：在使用自定义组合控件的属性时，要添加命名空间：xmlns:XXX="http://schemas.android.com/apk/res-auto"
 *
 */
public class CustomAssembleWidgetActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view);
        initView();
    }

    private void initView() {
        TitleBar titlebar = (TitleBar)findViewById(R.id.titlebar);
        titlebar.setTitle("你好");
        titlebar.setBackBtnText("返回");
        titlebar.setRightBtn1Icon(R.drawable.delete);
    }
}
