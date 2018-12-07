package com.haitao.www.myformer.second.ui.ui_common.dialog.popupwindow_dialog;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import android.view.inputmethod.InputMethodSubtype;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.haitao.www.myformer.R;
import com.haitao.www.myformer.second.ui.ui_common.tabActivity.tablayout.MyFragmentAdapter;
import com.haitao.www.myformer.utils.Lout;
import com.haitao.www.myformer.utils.ToastUtils;

import java.lang.reflect.Field;
import java.util.List;

public class BottomSheetTestActivity extends AppCompatActivity implements View.OnClickListener {

    private BottomSheetBehavior bottomSheetBehavior;
    private View bottomSheetLayout;
    private Button btnWechatKeyboard;
    private Button btnQqKeyboard;
    private Button btnSougoKeyboard;
    private Button btnSecurityKeyboard;
    private TextView tvEmojiSample;
    private LinearLayout parentLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_sheet_keyboard);
        initView();
        initData();
        initEvent();
    }

    private void initView() {
        parentLayout = findViewById(R.id.ll_parent);
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
        //通过BottomSheetBehavior控制bottom_sheet_layout布局的显示和隐藏
        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                switch (newState){
                    case BottomSheetBehavior.STATE_COLLAPSED:
                        Log.e("Bottom Sheet Behaviour", "STATE_COLLAPSED");
                        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);//展开
                        break;
                    case BottomSheetBehavior.STATE_DRAGGING:
                        Log.e("Bottom Sheet Behaviour", "STATE_DRAGGING");
                        break;
                    case BottomSheetBehavior.STATE_EXPANDED:
                        Log.e("Bottom Sheet Behaviour", "STATE_EXPANDED");
                        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);//折叠
                        break;
                    case BottomSheetBehavior.STATE_HIDDEN:
                        Log.e("Bottom Sheet Behaviour", "STATE_HIDDEN");
                        break;
                    case BottomSheetBehavior.STATE_SETTLING:
                        Log.e("Bottom Sheet Behaviour", "STATE_SETTLING");
                        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);//隐藏
                        break;

                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });
        //当为STATE_COLLAPSED（折叠）状态的时候bottom_sheet_layout残留的高度，默认为0px。
        bottomSheetBehavior.setPeekHeight(66);

        int unicodeJoy = 0x1F639;
        String emojiString = getEmojiStringByUnicode(unicodeJoy);
        tvEmojiSample.setText(emojiString);
    }

    /**
     * 功能：将emoji表情显示到页面上
     * 原理：通过emoji表情的通用Unicode编码就可以实现，直接使用Character.toChars()方法将unicode编码转换为一个char数组，
     * 再将这个char数组转换成为字符串就可以直接操作了，系统会自动将其解析为表情图片，可以直接显示在textview组件当中，不需要我们做任何其他的事情。
     *
     * @param unicode emoji表情对应的unicode编码
     * @return
     */
    private String getEmojiStringByUnicode(int unicode) {
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
            wechatKeyboard();//微信键盘的入口
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
        LinearLayout roundPointGroup = findViewById(R.id.dot_viewgroup);

        KeyboardFragmentAdapter keyboardFragmentAdapter = new KeyboardFragmentAdapter(getSupportFragmentManager(), this);
        keyboardContainerViewpager.setAdapter(keyboardFragmentAdapter);
        //绑定指示器与ViewPager,让用户点击标题切换viewpager,滑动viewpager可以切换标题
        keyboardTabLayout.setupWithViewPager(keyboardContainerViewpager);
        //设置圆点指示器
        keyboardFragmentAdapter.setupWithPagerPoint(keyboardContainerViewpager, roundPointGroup);
        //设置表情键盘的展开高度。根据软件键盘的高度来确定

        //设置表情键盘的高度
        setKeyboardHeight();
        getInputEditorHeight();
    }


    private void setKeyboardHeight() {
        LinearLayout llKeyboard = findViewById(R.id.ll_keyboard);
        LinearLayout.LayoutParams linearParams = (LinearLayout.LayoutParams) llKeyboard.getLayoutParams(); //取控件textView当前的布局参数
        linearParams.height = 970;// 强制设成控件的高
        llKeyboard.setLayoutParams(linearParams); //使设置好的布局参数应用到控件
    }

    /**
     * 获取输入框的高
     */
    private void getInputEditorHeight() {
        LinearLayout llInputEditor = findViewById(R.id.ll_input_editor);
    }

    /**
     * 获取键盘的高
     */
    private int getSoftInputHeight2() {
        final TextView tv_input_attribute = (TextView) findViewById(R.id.tv_input_attribute);
        final View myLayout = getWindow().getDecorView();
        parentLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            private int statusBarHeight;

            @Override
            public void onGlobalLayout() {
                Rect r = new Rect();
                // 使用最外层布局填充，进行测算计算
                parentLayout.getWindowVisibleDisplayFrame(r);
                int screenHeight = myLayout.getRootView().getHeight();
                int heightDiff = screenHeight - (r.bottom - r.top);
                if (heightDiff > 100) {
                    // 如果超过100个像素，它可能是一个键盘。获取状态栏的高度
                    statusBarHeight = 0;
                }
                try {
                    Class<?> c = Class.forName("com.android.internal.R$dimen");
                    Object obj = c.newInstance();
                    Field field = c.getField("status_bar_height");
                    int x = Integer.parseInt(field.get(obj).toString());
                    statusBarHeight = BottomSheetTestActivity.this.getResources().getDimensionPixelSize(x);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                int realKeyboardHeight = heightDiff - statusBarHeight;
                tv_input_attribute.setText("keyboard height(单位像素) = " + realKeyboardHeight);
            }
        });
        return 0;
    }

    private int getSoftInputHeight() {
        Rect r = new Rect();
        //decorView是window中的最顶层view，可以从window中通过getDecorView获取到decorView。
        //通过decorView获取到程序显示的区域，包括标题栏，但不包括状态栏。
        this.getWindow().getDecorView().getWindowVisibleDisplayFrame(r);
        //获取屏幕的高度
        int screenHeight = this.getWindow().getDecorView().getRootView().getHeight();
        //计算软件盘的高度
        int softInputHeight = screenHeight - r.bottom;
        return softInputHeight;
    }
}
