package com.watom20171116.www.myformer.second.ui.ui_common.listview.recyclerview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;

import com.watom20171116.www.myformer.R;
import com.watom20171116.www.myformer.utils.MyToast;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/3/1 0001.
 */

public class RecyclerViewTestActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnAdd;
    private Button btnDelete;
    private Button btnHorizontal;
    private Button btnVertical;
    private Button btnListview;
    private Button btnGridview;
    private Button btnFlowview;
    private RecyclerView recyclerview;
    private RecyclerViewAdapter recyclerViewAdapter;
    private int orientation;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        findViews();
        //LayoutManager设置布局样式：（1）LinerLayoutManager-ListView（2）GridLayoutManager-GridView （3）StaggeredGridLayoutManager-瀑布流
        recyclerview.setLayoutManager(new LinearLayoutManager(RecyclerViewTestActivity.this, LinearLayoutManager.VERTICAL, false));
        //设置数据适配器RecyclerViewAdapter
        recyclerViewAdapter = new RecyclerViewAdapter(this, getData());
        recyclerview.setAdapter(recyclerViewAdapter);
        //设置默认动画，也可以自定义动画。
        recyclerview.setItemAnimator(new DefaultItemAnimator());
        //设置item的点击事件
        recyclerViewAdapter.setOnItemClickListener(new RecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                MyToast.showToast(RecyclerViewTestActivity.this, "短按点击了-" + position);
            }

            @Override
            public void onItemLongClick(View view, int position) {
                MyToast.showToast(RecyclerViewTestActivity.this, "长按点击了-" + position);
            }
        });
    }

    private void findViews() {
        btnAdd = (Button) findViewById(R.id.btn_add);
        btnDelete = (Button) findViewById(R.id.btn_delete);
        btnHorizontal = (Button) findViewById(R.id.btn_horizontal);
        btnVertical = (Button) findViewById(R.id.btn_vertical);
        btnListview = (Button) findViewById(R.id.btn_listview);
        btnGridview = (Button) findViewById(R.id.btn_gridview);
        btnFlowview = (Button) findViewById(R.id.btn_flowview);
        recyclerview = (RecyclerView) findViewById(R.id.recyclerview);

        btnAdd.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnHorizontal.setOnClickListener(this);
        btnVertical.setOnClickListener(this);
        btnListview.setOnClickListener(this);
        btnGridview.setOnClickListener(this);
        btnFlowview.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == btnAdd) {
            // 增加item
            recyclerViewAdapter.addData(0, "New_Content");
            recyclerview.scrollToPosition(0);  //滑动到某个位置
        } else if (v == btnDelete) {
            // 删除item
            recyclerViewAdapter.removeData(0);
        } else if (v == btnGridview) {
            // 设置GridView类型效果
            recyclerview.setLayoutManager(new GridLayoutManager(RecyclerViewTestActivity.this, 3, orientation, false));
        } else if (v == btnFlowview) {
            // 设置瀑布流类型效果
            int vertical = StaggeredGridLayoutManager.VERTICAL;
            recyclerview.setLayoutManager(new StaggeredGridLayoutManager(4, orientation));
        } else if (v == btnListview) {
            // 默认加载:设置ListView类型效果
            recyclerview.setLayoutManager(new LinearLayoutManager(RecyclerViewTestActivity.this, orientation, false));
        } else if (v == btnHorizontal) {
            orientation = 0;
        } else if (v == btnVertical) {
            orientation = 1;
        }
    }

    /**
     * 制造假数据
     *
     * @return
     */
    private ArrayList <String> getData() {
        ArrayList <String> data = new ArrayList <>();
        String temp = "item ☛ ";
        for (int i = 0; i < 100; i++) {
            data.add(temp + i);
        }
        return data;
    }
}
