package com.watom20171116.www.mytestdemo.second.logic.kernel_module.barcode;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;
import com.uuzuche.lib_zxing.activity.ZXingLibrary;
import com.watom20171116.www.mytestdemo.R;

/**
 * Created by Administrator on 2018/2/27 0027.
 */

public class BarCodeTestActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnBarcodeScan;
    private Button btnBarcodeScan02;
    private Button btnBarcodeScan03;
    private TextView tvBarcodeContent;
    int REQUEST_CODE = 1;
    String TAG = "BarCodeTestActivity";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barcode);
        findViews();
        getCameraPermission();
        ZXingLibrary.initDisplayOpinion(this); //ZXingLibrary初始化

    }

    /**
     * 获取摄像头权限
     */
    private void getCameraPermission() {
        if (Build.VERSION.SDK_INT>22){
            if (ContextCompat.checkSelfPermission(BarCodeTestActivity.this,
                    android.Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED){
                //先判断有没有权限 ，没有就在这里进行权限的申请
                ActivityCompat.requestPermissions(BarCodeTestActivity.this,
                        new String[]{android.Manifest.permission.CAMERA},2);
            }else {
                //说明已经获取到摄像头权限了，想干嘛干嘛
            }
        }else {
            //这个说明系统版本在6.0之下，不需要动态获取权限。

        }
    }


    private void findViews() {
        btnBarcodeScan = (Button)findViewById( R.id.btn_barcode_scan );
        btnBarcodeScan02 = (Button)findViewById( R.id.btn_barcode_scan02 );
        btnBarcodeScan03 = (Button)findViewById( R.id.btn_barcode_scan03 );
        tvBarcodeContent = (TextView)findViewById( R.id.tv_barcode_content );
        btnBarcodeScan.setOnClickListener( this );
        btnBarcodeScan02.setOnClickListener( this );
        btnBarcodeScan03.setOnClickListener( this );
    }

    @Override
    public void onClick(View v) {
        if ( v == btnBarcodeScan ) {
            Intent intent = new Intent(BarCodeTestActivity.this, CaptureActivity.class);
            startActivityForResult(intent, REQUEST_CODE);
        } else if ( v == btnBarcodeScan02 ) {
            // Handle clicks for btnBarcodeScan02
        } else if ( v == btnBarcodeScan03 ) {
            // Handle clicks for btnBarcodeScan03
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            //处理扫描结果（在界面上显示）
            if (null != data) {
                Bundle bundle = data.getExtras();
                if (bundle == null) {
                    return;
                }
                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                    String result = bundle.getString(CodeUtils.RESULT_STRING);
                    Toast.makeText(this, "解析结果:" + result, Toast.LENGTH_LONG).show();
                    Log.e(TAG,"解析结果:" + result);
                    tvBarcodeContent.append(result);//解析结果显示在TextView
                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                    Toast.makeText(BarCodeTestActivity.this, "解析二维码失败", Toast.LENGTH_LONG).show();
                }
            }
        }
    }

}