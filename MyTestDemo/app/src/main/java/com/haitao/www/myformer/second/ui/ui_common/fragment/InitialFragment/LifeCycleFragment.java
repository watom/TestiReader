package com.haitao.www.myformer.second.ui.ui_common.fragment.InitialFragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.haitao.www.myformer.R;
import com.haitao.www.myformer.utils.Lout;

/**
 * Created by Administrator on 2017/12/1 0001.
 */

public class LifeCycleFragment extends Fragment {
    private static final String Tag ="LifeCycleFragment";
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Lout.e(Tag,"onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Lout.e(Tag,"onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Lout.e(Tag,"onCreateView");
        View view = inflater.inflate(R.layout.fragment_lifecycle, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Lout.e(Tag,"onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Lout.e(Tag,"onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Lout.e(Tag,"onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Lout.e(Tag,"onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Lout.e(Tag,"onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Lout.e(Tag,"onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Lout.e(Tag,"onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Lout.e(Tag,"onDetach");
    }
}
