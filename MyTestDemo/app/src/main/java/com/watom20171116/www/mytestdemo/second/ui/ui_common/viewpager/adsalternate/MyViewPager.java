package com.watom20171116.www.mytestdemo.second.ui.ui_common.viewpager.adsalternate;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.View;

import com.nineoldandroids.view.ViewHelper;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/3/6 0006.
 */

public class MyViewPager extends ViewPager {

    private View mLeft;
    private View mRight;

    private float mTrans;
    private float mScale;

    private static final float MIN_SCALE = 0.6f;
    private Map<Integer, View> mChildren = new HashMap<>();

    public MyViewPager(Context context) {
        super(context);
    }

    public MyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onPageScrolled(int position, float offset, int offsetPixels) {


        mLeft = mChildren.get(position);
        mRight = mChildren.get(position + 1);

        animStack(mLeft, mRight, offset, offsetPixels);// 创建动画效果

        super.onPageScrolled(position, offset, offsetPixels);
    }

    private void animStack(View left, View right, float offset, int offsetPixels) {
        if (right != null) {

            // 从0-1页，offset:0`1
            mScale = (1 - MIN_SCALE) * offset + MIN_SCALE;

            mTrans = -getWidth() - getPageMargin() + offsetPixels;

            ViewHelper.setScaleX(right, mScale);
            ViewHelper.setScaleY(right, mScale);

            ViewHelper.setTranslationX(right, mTrans);
        }
        if (left != null) {
            left.bringToFront();
        }
    }
}