package com.haitao.www.myformer.second.ui.ui_common.animation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.github.ahmadnemati.wind.WindView;
import com.github.ahmadnemati.wind.enums.TrendType;
import com.haitao.www.myformer.R;

/**
 * 开源：https://github.com/AhmadNemati/WindView
 * Created by Administrator on 2018/4/10 0010.
 *
 */

public class WindViewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wind_view);
        initView();
    }

    private void initView() {
        WindView windView= (WindView) findViewById(R.id.windview);
        windView.setPressure(30);
        windView.setPressureUnit("in Hg");
        windView.setWindSpeed(8);
        windView.setWindSpeedUnit(" km/h");
        windView.setTrendType(TrendType.UP);
        windView.start();
        //缺少设置风速和其他的设置界面，计划使用Bottomsheet实现
    }
}
