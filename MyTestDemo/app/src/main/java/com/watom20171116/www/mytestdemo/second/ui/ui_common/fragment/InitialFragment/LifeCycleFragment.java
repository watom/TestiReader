package com.watom20171116.www.mytestdemo.second.ui.ui_common.fragment.InitialFragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.watom20171116.www.mytestdemo.R;
import com.watom20171116.www.mytestdemo.utils.Logout;

/**
 * Created by Administrator on 2017/12/1 0001.
 */

public class LifeCycleFragment extends Fragment {
    private static final String Tag ="LifeCycleFragment";
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Logout.e(Tag,"onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logout.e(Tag,"onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Logout.e(Tag,"onCreateView");
        View view = inflater.inflate(R.layout.fragment_lifecycle, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Logout.e(Tag,"onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Logout.e(Tag,"onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Logout.e(Tag,"onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Logout.e(Tag,"onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Logout.e(Tag,"onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Logout.e(Tag,"onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Logout.e(Tag,"onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Logout.e(Tag,"onDetach");
    }
}
