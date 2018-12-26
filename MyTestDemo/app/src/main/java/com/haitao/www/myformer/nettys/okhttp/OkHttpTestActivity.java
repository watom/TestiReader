package com.haitao.www.myformer.nettys.okhttp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.haitao.www.myformer.R;
import com.haitao.www.myformer.utils.ToastUtils;
import com.haitao.www.myformer.utils.NetUtils;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by Administrator on 2018/2/28 0028.
 */

public class OkHttpTestActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView btnGetOkhttp,btnPostOkhttp,btnUploadOkhttp,btnDownloadOkhttp,tvResultOkhttp;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp);
        findViews();
    }

    private void findViews() {
        btnGetOkhttp = findViewById( R.id.btn_get_okhttp );
        btnPostOkhttp = findViewById( R.id.btn_post_okhttp );
        btnUploadOkhttp = findViewById( R.id.btn_upload_okhttp );
        btnDownloadOkhttp = findViewById( R.id.btn_download_okhttp );
        tvResultOkhttp = findViewById( R.id.tv_result_okhttp );

        btnGetOkhttp.setOnClickListener( this );
        btnPostOkhttp.setOnClickListener( this );
        btnUploadOkhttp.setOnClickListener( this );
        btnDownloadOkhttp.setOnClickListener( this );
    }

    @Override
    public void onClick(View v) {
        if ( v == btnGetOkhttp ) {
            getRequest("https://www.baidu.com/");
        } else if ( v == btnPostOkhttp ) {
            NetUtils.getRequest("https://www.baidu.com/", new NetUtils.Callback() {
                @Override
                public void onResponse(String response) {
                    tvResultOkhttp.append(response);
                }
            });

        } else if ( v == btnUploadOkhttp ) {
            ToastUtils.showToast(this,"暂空");
        } else if ( v == btnDownloadOkhttp ) {
            ToastUtils.showToast(this,"暂空");
        }
    }

    private void getRequest(String url) {
        OkHttpClient client = new OkHttpClient();

        //创建一个Request。先实例化okhttp,构建一个request，使用的是get方式，放入一个url地址
        Request request = new Request.Builder().get().url(url).build();
        //通过client发起一个请求,放入队列。等待任务完成，在Callback中取结果。
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                ToastUtils.showToast(OkHttpTestActivity.this,"请求网络失败");
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    //通过response.body().string()获取返回来的字符串。
                    ResponseBody body = response.body();//这个body()其实就是ResponseBody的对象
                    String string = body.string();//ResponseBody里面涉及到一些流的传输，里面有很多方法，常用的 就是string()
//                    ToastUtils.showToast(OkHttpTestActivity.this,string);
                    tvResultOkhttp.append(string);
                }
            }
        });

    }

}
