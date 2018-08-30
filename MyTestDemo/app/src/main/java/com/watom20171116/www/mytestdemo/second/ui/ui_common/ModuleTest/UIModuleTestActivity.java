package com.watom20171116.www.mytestdemo.second.ui.ui_common.ModuleTest;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.watom20171116.www.mytestdemo.R;
import com.watom20171116.www.mytestdemo.second.ui.ui_common.ModuleTest.excellayout.ExcelTablayout;
import com.watom20171116.www.mytestdemo.second.ui.ui_common.ModuleTest.timeLine.TimeLineActivity;

/**
 * Created by Administrator on 2017/11/29 0029.
 */

public class UIModuleTestActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private String[] content;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_activity);
        ListView listview =  findViewById(R.id.list_view_enter);
        initData(listview);
    }

    private void initData(ListView view) {
        content = new String[]{"表格","时间轴"};
        ArrayAdapter stringArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,content);
        view.setAdapter(stringArrayAdapter);
        view.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String s = content[position];
        switch (s){
            case "表格":
                startActivity(new Intent(this, ExcelTablayout.class));
                break;
            case "时间轴":
                startActivity(new Intent(this, TimeLineActivity.class));
                break;
        }
    }
}
