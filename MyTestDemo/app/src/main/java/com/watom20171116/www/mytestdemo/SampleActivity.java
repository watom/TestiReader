package com.watom20171116.www.mytestdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.watom20171116.www.mytestdemo.h5.H5HomeActivity;
import com.watom20171116.www.mytestdemo.second.function.FunctionImpActivity;
import com.watom20171116.www.mytestdemo.second.logic.ModuleTestActivity;
import com.watom20171116.www.mytestdemo.second.nettys.NettysActivity;
import com.watom20171116.www.mytestdemo.second.ui.ui_common.UIActivity;
import com.watom20171116.www.mytestdemo.utils.Logout;

/***********************************************
 *@Copyright: 2017(C), 国电通__期
 *@Author&Email: wanghaitao 1164973719@qq.com
 *@FileName: com.watom20171116.www.mytestdemo.ui.ui_common
 *@Function: 1、
 *@Description: 1、       
 *@CreatedDate: 2017/11/19 18:12
 *@UpDate: 1、
 ***********************************************/

public class SampleActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private String[] content;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_activity);
        ListView listview = (ListView) findViewById(R.id.list_view_enter);
        initData(listview);
    }

    private void initData(ListView view) {
        content = new String[]{"UI设计", "Data处理", "网络请求", "设计模式", "架构设计", "逻辑单元","功能模块","H5"};
        ArrayAdapter stringArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, content);
        view.setAdapter(stringArrayAdapter);
        view.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String s = content[position];
        switch (s) {
            case "UI设计":
                startActivity(new Intent(this, UIActivity.class));
                break;
            case "Data处理":
                break;
            case "网络请求":
                startActivity(new Intent(this, NettysActivity.class));
                Logout.d("watom", "onAttach");
                break;
            case "设计模式":
                break;
            case "架构设计":
                break;
            case "逻辑单元":
                startActivity(new Intent(this, ModuleTestActivity.class));
                break;
            case "功能模块":
                startActivity(new Intent(this, FunctionImpActivity.class));
                break;
            case "H5":
                startActivity(new Intent(this, H5HomeActivity.class));
                break;
        }
    }
}
