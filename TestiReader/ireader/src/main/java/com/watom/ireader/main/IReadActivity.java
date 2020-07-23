package com.watom.ireader.main;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.watom.ireader.R;
import com.watom.ireader.adapter.IReaderAdapter;
import com.watom.ireader.adapter.IReaderAdapter01;
import com.watom.ireader.utils.ReadUtil;
import com.watom.ireader.widget.TuXingView;

import java.util.ArrayList;
import java.util.List;

public class IReadActivity extends Activity {
    private RecyclerView recyclerReader;
    private List<String> dataList = new ArrayList<>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tuxingceshi);
        initData();
        initView();
        initEvent();
    }

    private void initData() {
        for (int i = 0; i < 100; i++) {
            String books = ReadUtil.getFromAssets(this, "帐中娇妾.txt", null, 250, 200 * i);
            dataList.add(books);
        }
    }
    private void initView() {
    }

    private void initView02() {
        recyclerReader = findViewById(R.id.recycler_ireader);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerReader.setLayoutManager(layoutManager);
        IReaderAdapter iReaderAdapter = new IReaderAdapter(dataList);
        recyclerReader.setAdapter(iReaderAdapter);
    }
    private void initView01() {
        recyclerReader = findViewById(R.id.recycler_ireader);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerReader.setLayoutManager(layoutManager);
        IReaderAdapter01 iReaderAdapter = new IReaderAdapter01(dataList);
        recyclerReader.setAdapter(iReaderAdapter);
    }

    private void initEvent() {

    }
}
