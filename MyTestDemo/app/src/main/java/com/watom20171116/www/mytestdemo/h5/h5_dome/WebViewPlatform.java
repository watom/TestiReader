package com.watom20171116.www.mytestdemo.h5.h5_dome;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.watom20171116.www.mytestdemo.R;
import com.watom20171116.www.mytestdemo.utils.WebViewTool;

public class WebViewPlatform extends AppCompatActivity {
    private Context context = this;
    private WebView webView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.h5_layout_webview);
        webView = (WebView) findViewById(R.id.where_webview);
        new WebViewTool(context).init(webView, "http://www.runoob.com/");
    }
}
