package com.watom20171116.www.myformer.common.base;

public interface BaseActivityAction {
    /**
     * 初始化tilte
     */
    void initTitle();

    /**
     * 初始化view
     */
    void initView();

    /**
     * 初始化Listener
     */
    void setListener();
    /**
     * 设置title名
     * @param text
     */
    void setTitleText(String text);

    /**
     * 改变title右侧button状态
     */
    void changeRightButtonState(int state);

    /**
     * 修改titie中右侧Button的背景及图标
     * @param view
     * @param id
     */
    void editRightButtonBg(int id);

    /**
     * 改变title左侧button状态
     */
    void changeLeftButtonState(int state);
    /**
     * 修改titie中左侧Button的背景及图标
     * @param view
     * @param id
     */
    void editLeftButtonBg(int id);

    /**
     * 初始化隐藏title中间image
     */
    void hiddenTImage();
}
