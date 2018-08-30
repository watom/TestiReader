package com.watom20171116.www.mytestdemo.second.ui.ui_common.dialog;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.watom20171116.www.mytestdemo.R;
import com.watom20171116.www.mytestdemo.second.ui.ui_common.ModuleTest.timeLine.TimeLineActivity;
import com.watom20171116.www.mytestdemo.second.ui.ui_common.ModuleTest.excellayout.ExcelTablayout;
import com.watom20171116.www.mytestdemo.second.ui.ui_common.dialog.alert_dialog.AlertDialogDemo;
import com.watom20171116.www.mytestdemo.second.ui.ui_common.dialog.dialogUtils.DialogUtilsActivity;
import com.watom20171116.www.mytestdemo.second.ui.ui_common.dialog.dialogfragment.FragmentDialog;
import com.watom20171116.www.mytestdemo.second.ui.ui_common.dialog.popupwindow_dialog.PopupWindowDialog;

/**
 * Created by Administrator on 2017/11/21 0021.
 */

public class DialogActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private String[] content;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_activity);
        ListView listview =  findViewById(R.id.list_view_enter);
        initData(listview);
    }

    private void initData(ListView view) {
        content = new String[]{"PopupWindowDialog","AlertDialogDemo","FragmentDialog","封装的Dialog工具"};
        ArrayAdapter stringArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,content);
        view.setAdapter(stringArrayAdapter);
        view.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String s = content[position];
        switch (s){
            case "PopupWindowDialog":
                startActivity(new Intent(this, PopupWindowDialog.class));
                break;
            case "AlertDialogDemo":
                startActivity(new Intent(this, AlertDialogDemo.class));
                break;
            case "FragmentDialog":
                startActivity(new Intent(this, FragmentDialog.class));
                break;
            case "封装的Dialog工具":
                startActivity(new Intent(this, DialogUtilsActivity.class));
                break;
        }
    }
}
