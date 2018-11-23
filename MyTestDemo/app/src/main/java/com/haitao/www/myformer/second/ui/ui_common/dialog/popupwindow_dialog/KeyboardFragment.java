package com.haitao.www.myformer.second.ui.ui_common.dialog.popupwindow_dialog;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.haitao.www.myformer.R;

public class KeyboardFragment extends Fragment {
    private static final String Arguments = "position";
    Activity activity;
    TextView context_title;
    View view;

    /**
     * 创建页面并传入参数
     *
     * @param position 传入的参数
     * @return 为调用者返回一个fragment对象
     */
    public static KeyboardFragment getInstance(int position, int total) {
        KeyboardFragment fragment = new KeyboardFragment();
        Bundle args = new Bundle();
        args.putInt(Arguments, position);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.layout_text, container, false);
        activity = getActivity();
        findView(view);
        initView();
        return view;
    }

    private void initView() {
        int value = getArguments().getInt(Arguments);
        context_title.setText("页面" + value);
        if (value % 2 == 0) {
            view.setBackgroundColor(getResources().getColor(R.color.red));
        } else {
            view.setBackgroundColor(getResources().getColor(R.color.blue));
        }

    }

    private void findView(View view) {
        context_title = view.findViewById(R.id.context_title);
    }
}
