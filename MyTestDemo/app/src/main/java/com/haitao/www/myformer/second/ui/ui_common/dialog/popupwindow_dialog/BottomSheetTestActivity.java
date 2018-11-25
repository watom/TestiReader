package com.haitao.www.myformer.second.ui.ui_common.dialog.popupwindow_dialog;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.haitao.www.myformer.R;
import com.haitao.www.myformer.second.ui.ui_common.tabActivity.tablayout.MyFragmentAdapter;
import com.haitao.www.myformer.utils.ToastUtils;

public class BottomSheetTestActivity extends AppCompatActivity implements View.OnClickListener {

    private BottomSheetBehavior bottomSheetBehavior;
    private View bottomSheetLayout;
    private Button btnWechatKeyboard;
    private Button btnQqKeyboard;
    private Button btnSougoKeyboard;
    private Button btnSecurityKeyboard;
    private TextView tvEmojiSample;
    private LinearLayout roundPointGroup;
    private int lastPosition;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_sheet_keyboard);
        initView();
        initData();
        initEvent();
    }

    private void initView() {
        bottomSheetLayout = findViewById(R.id.bottom_sheet_layout);
        btnWechatKeyboard = (Button) findViewById(R.id.btn_wechat_keyboard);
        btnQqKeyboard = (Button) findViewById(R.id.btn_qq_keyboard);
        btnSougoKeyboard = (Button) findViewById(R.id.btn_sougo_keyboard);
        btnSecurityKeyboard = (Button) findViewById(R.id.btn_security_keyboard);
        tvEmojiSample = (TextView) findViewById(R.id.tv_emoji_sample);


    }

    private void initData() {
        //把这个底部菜单和一个BottomSheetBehavior关联起来
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheetLayout);

        int unicodeJoy = 0x1F602;
        String emojiString = getEmojiStringByUnicode(unicodeJoy);
        tvEmojiSample.setText(emojiString);
    }

    /**
     * 功能：将emoji表情显示到页面上
     *
     * 原理：通过emoji表情的通用Unicode编码就可以实现，直接使用Character.toChars()方法将unicode编码转换为一个char数组，
     * 再将这个char数组转换成为字符串就可以直接操作了，系统会自动将其解析为表情图片，可以直接显示在textview组件当中，不需要我们做任何其他的事情。
     * @param unicode emoji表情对应的unicode编码
     * @return
     */
    private String getEmojiStringByUnicode(int unicode){
        return new String(Character.toChars(unicode));
    }

    private void initEvent() {
        btnWechatKeyboard.setOnClickListener(this);
        btnQqKeyboard.setOnClickListener(this);
        btnSougoKeyboard.setOnClickListener(this);
        btnSecurityKeyboard.setOnClickListener(this);
        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                if (newState == BottomSheetBehavior.STATE_EXPANDED) {

                } else {

                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        if (view == btnWechatKeyboard) {
            wechatKeyboard();
        } else if (view == btnQqKeyboard) {
            ToastUtils.showToast(this, "qq键盘暂未开发");
        } else if (view == btnSougoKeyboard) {
            ToastUtils.showToast(this, "搜狗键盘暂未开发");
        } else if (view == btnSecurityKeyboard) {
            ToastUtils.showToast(this, "安全键盘暂未开发");
        }
    }

    private void wechatKeyboard() {
        TabLayout keyboardTabLayout = findViewById(R.id.keyboard_tab_layout);
        ViewPager keyboardContainerViewpager = findViewById(R.id.keyboard_container_viewpager);
        roundPointGroup = findViewById(R.id.dot_viewgroup);

        KeyboardFragmentAdapter keyboardFragmentAdapter = new KeyboardFragmentAdapter(getSupportFragmentManager(), this);
        keyboardContainerViewpager.setAdapter(keyboardFragmentAdapter);
        //绑定指示器与ViewPager,让用户点击标题切换viewpager,滑动viewpager可以切换标题
        keyboardTabLayout.setupWithViewPager(keyboardContainerViewpager);

        //根据页面的个数动态添加圆点指示器
        final int count = keyboardFragmentAdapter.getCount();
        ImageView point = null;
        for (int i = 0; i < count; i++) {
            // 添加指示点
            point = new ImageView(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.rightMargin = 20;
            point.setLayoutParams(params);
            point.setBackgroundResource(R.drawable.lunbotu_round_point_selector);
            if (i == 0) {
                point.setEnabled(true);
            } else {
                point.setEnabled(false);
            }
            roundPointGroup.addView(point);
        }

        keyboardContainerViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                roundPointGroup.getChildAt(position).setEnabled(true);
                roundPointGroup.getChildAt(lastPosition).setEnabled(false); // 把上一个点设为false
                lastPosition = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }
}
