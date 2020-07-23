package com.watom.testireader;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.watom.ireader.main.IReadActivity;
import com.watom.pdflibrary.main.IReadPdfActivity;

public class MainActivity extends AppCompatActivity {
    Button openReader;
    Button openPdfReader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
        initEvent();
    }

    private void initEvent() {
        openReader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, IReadActivity.class);
                startActivity(intent) ;
            }
        });
        openPdfReader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, IReadPdfActivity.class);
                startActivity(intent) ;
            }
        });
    }

    private void initData() {

    }

    private void initView() {
        openReader = findViewById(R.id.openReader);
        openPdfReader = findViewById(R.id.openPdfReader);
    }
}
