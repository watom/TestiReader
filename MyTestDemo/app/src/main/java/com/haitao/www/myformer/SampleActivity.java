package com.haitao.www.myformer;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.haitao.www.myformer.h5.H5HomeActivity;
import com.haitao.www.myformer.second.function.FunctionImpActivity;
import com.haitao.www.myformer.second.logic.ModuleTestActivity;
import com.haitao.www.myformer.second.nettys.NettysActivity;
import com.haitao.www.myformer.second.structure_design.StructureDesignActivity;
import com.haitao.www.myformer.second.ui.ui_common.UIActivity;
import com.haitao.www.myformer.utils.Lout;

/***********************************************
 *@Copyright: 2017(C), 国电通__期
 *@Author&Email: wanghaitao 1164973719@qq.com
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
        setContentView(R.layout.activity_listview);
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
                Lout.d("watom", "onAttach");
                break;
            case "设计模式":
                break;
            case "架构设计":
                startActivity(new Intent(this, StructureDesignActivity.class));
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
