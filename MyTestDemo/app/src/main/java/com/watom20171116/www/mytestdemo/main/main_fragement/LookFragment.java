package com.watom20171116.www.mytestdemo.main.main_fragement;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.watom20171116.www.mytestdemo.R;

/**
 * Created by watom_Thinkpad on 2018/9/2.
 */

public class LookFragment extends Fragment {
    private View wodeView;
    private Context context;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        context = getActivity();
        wodeView = inflater.inflate(R.layout.activity_main_look, container, false);
        initView();
        return wodeView;
    }

    private void initView() {

    }
}