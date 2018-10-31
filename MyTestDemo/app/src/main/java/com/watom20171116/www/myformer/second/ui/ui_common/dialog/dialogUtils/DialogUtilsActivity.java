package com.watom20171116.www.myformer.second.ui.ui_common.dialog.dialogUtils;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.watom20171116.www.myformer.R;

/**
 * Created by Administrator on 2018/8/23 0023.
 */

public class DialogUtilsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_button_layout);
        initView();

    }

    private void initView() {
        findViewById(R.id.btn_common);
    }
}
