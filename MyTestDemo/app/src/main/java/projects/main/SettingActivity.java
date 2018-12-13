package projects.main;

import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.haitao.www.myformer.R;
import com.haitao.www.myformer.second.ui.ui_common.widget.ColorPicker;
import com.haitao.www.myformer.utils.ToastUtils;

public class SettingActivity extends AppCompatActivity {
    private ColorPicker panColorPicker;
    private TextView tvColor;
    private TextView btnPick;
    private TextView btn_tint;
    private int colorValue;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        findView();
    }

    private void findView() {
        TextView btn_system_tint = findViewById(R.id.btn_system_tint);

        btn_system_tint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showfillCustomizeDialog();
            }
        });
    }

    private void showfillCustomizeDialog() {
        final Dialog dialog = new AlertDialog.Builder(this).create();
        View view = LayoutInflater.from(this).inflate(
                R.layout.layout_color_pick, null);
        dialog.show();
        dialog.setCancelable(false);//物理返回时，false禁止。
        dialog.getWindow().setContentView(view);

        panColorPicker = (ColorPicker)view.findViewById( R.id.pan_color_picker );
        tvColor = (TextView)view.findViewById( R.id.tv_color );
        btnPick = (TextView)view.findViewById( R.id.btn_pick );
        btn_tint = (TextView)view.findViewById( R.id.btn_tint );
        tvColor.setText("选取的颜色值:"+getSelectedColor(panColorPicker));
        btnPick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                colorValue = getSelectedColor(panColorPicker);
                tvColor.setText("选取的颜色值:"+colorValue);
                tvColor.setBackgroundColor(colorValue);
            }
        });
        btn_tint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                ToastUtils.showToast(SettingActivity.this,"您选择的颜色是"+colorValue);
                dialog.dismiss();
            }
        });
    }

    private int getSelectedColor(ColorPicker colorPicker) {
        int selected = colorPicker.getColor();
        int color = Color.argb(153, Color.red(selected), Color.green(selected), Color.blue(selected));
       return color;
    }
}
