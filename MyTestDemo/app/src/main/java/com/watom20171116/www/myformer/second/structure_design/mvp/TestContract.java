package com.watom20171116.www.myformer.second.structure_design.mvp;

public interface TestContract {
    interface View {
        //显示数据
        void showData(String str);
    }

    interface Presenter {
        //交换数据
        void getData();
    }

    interface Model {
        //处理数据
        String doData();
    }
}
