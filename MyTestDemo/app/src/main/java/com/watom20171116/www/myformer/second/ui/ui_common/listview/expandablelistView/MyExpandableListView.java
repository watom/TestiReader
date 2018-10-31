package com.watom20171116.www.myformer.second.ui.ui_common.listview.expandablelistView;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;

import com.watom20171116.www.myformer.R;
import com.watom20171116.www.myformer.utils.Logout;

/**
 * Created by Administrator on 2018/8/20 0020.
 */

public class MyExpandableListView extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandablelistview);

        ExpandableListView expandableListView = (ExpandableListView) findViewById(R.id.elv_expandablelistview);
        MyExpandableListAdapter adapter = new MyExpandableListAdapter(this);
        expandableListView.setAdapter(adapter);
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Logout.e("wanghaitao222","groupPosition:"+groupPosition+"  childPosition:"+childPosition+"  id:"+id);
                return false;
            }
        });
    }
}
