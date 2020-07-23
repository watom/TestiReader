package com.watom.ireader.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class TuXingView extends View {
    public TuXingView(Context context) {
        super(context);
        initViewDeploy(context, null, 0);
    }

    public TuXingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TuXingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initViewDeploy(context, attrs, 0);
    }

    private void initViewDeploy(Context context, AttributeSet attrs, int defStyleAttr) {

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.YELLOW);
        Paint paint = new Paint();
        //设置画笔颜色
        paint.setColor(Color.BLACK);
        //设置抗锯齿
        paint.setAntiAlias(true);
        //设置防抖动
        paint.setDither(true);
        //设置填充风格
        paint.setStyle(Paint.Style.STROKE);
        //设置画笔宽度
        paint.setStrokeWidth(3);
        int width = this.getWidth();
        int height = this.getHeight();
        canvas.drawRect(40, 40, width - 40, height - 40, paint);
        int spaceX = (width - 80) / 10;
        int spaceY = (height - 80) / 20;
        Path path = new Path();
        paint.setTextSize(80);
        for (int i = 0; i < 9; i++) {
            path.moveTo(spaceX * (i + 1) + 40, 40);
            path.lineTo(spaceX * (i + 1) + 40, height - 40);
        }
        for (int i = 0; i < 19; i++) {
            canvas.drawText("永",40,spaceY * (i + 1)-20 + 40,paint);
            path.moveTo(40, spaceY * (i + 1) + 40);
            path.lineTo(width - 40, spaceY * (i + 1) + 40);
        }
        path.close();
        canvas.drawPath(path, paint);
    }
}
