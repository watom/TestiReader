package com.watom20171116.www.mytestdemo.second.structure_design;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.watom20171116.www.mytestdemo.R;
import com.watom20171116.www.mytestdemo.second.ui.ui_common.ModuleTest.UIModuleTestActivity;
import com.watom20171116.www.mytestdemo.second.ui.ui_common.ModuleTest.measureScreen.MeasureScreenActivity;
import com.watom20171116.www.mytestdemo.second.ui.ui_common.animation.AnimationActivity;
import com.watom20171116.www.mytestdemo.second.ui.ui_common.bitmap.BitmapActivity;
import com.watom20171116.www.mytestdemo.second.ui.ui_common.component.ComponentActivity;
import com.watom20171116.www.mytestdemo.second.ui.ui_common.dialog.DialogActivity;
import com.watom20171116.www.mytestdemo.second.ui.ui_common.fragment.FragmentCategory;
import com.watom20171116.www.mytestdemo.second.ui.ui_common.listview.ListViewCategory;
import com.watom20171116.www.mytestdemo.second.ui.ui_common.tabActivity.MyTabActivity;
import com.watom20171116.www.mytestdemo.second.ui.ui_common.viewpager.ViewPagerActivity;
import com.watom20171116.www.mytestdemo.utils.MyToast;

/**
 * Created by Administrator on 2017/11/27 0027.
 */

public class StructureDesignActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private String[] content;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_activity);
        ListView listview = (ListView) findViewById(R.id.list_view_enter);
        initData(listview);
    }

    private void initData(ListView view) {
        content = new String[]{"MVP架构", "MVVP架构"};
        ArrayAdapter stringArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,content);
        view.setAdapter(stringArrayAdapter);
        view.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String s = content[position];
        switch (s){
            case "MVP架构":
                startActivity(new Intent(this, StructureDesignActivity.class));
                break;
            case "MVVP架构":
                MyToast.showToast(StructureDesignActivity.this,"暂缓实现");
                break;
        }
    }
}
