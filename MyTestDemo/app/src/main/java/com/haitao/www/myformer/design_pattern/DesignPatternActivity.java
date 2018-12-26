package com.haitao.www.myformer.design_pattern;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;

import com.haitao.www.myformer.R;
import com.haitao.www.myformer.utils.Lout;

public class DesignPatternActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandablelistview);

        ExpandableListView expandableListView = (ExpandableListView) findViewById(R.id.elv_expandablelistview);
        AdapterDesignPattern adapter = new AdapterDesignPattern(this);
        expandableListView.setAdapter(adapter);
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Lout.e("显示参数值", "groupPosition:" + groupPosition + "  childPosition:" + childPosition + "  id:" + id);
                return false;
            }
        });
    }
}