package com.haitao.www.myformer.ui.ui_common.component.ratingbarview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.haitao.www.myformer.R;

public class RatingBarView2 extends LinearLayout implements CompoundButton.OnCheckedChangeListener {
    private boolean mClickable = true;
    private OnRatingListener onRatingListener;
    private float starImageSize;
    private int starSpace;
    private int starCount;
    private Drawable starEmptyDrawable;
    private Drawable starFillDrawable;
    private int mStarCount;
    private int mSelectedPosition;

    public RatingBarView2(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setOrientation(LinearLayout.HORIZONTAL);
        initView(context, attrs);
        createView(context);
    }

    private void initView(Context context, AttributeSet attrs) {
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.RatingBarView);
        starImageSize = ta.getDimension(R.styleable.RatingBarView_starSize, 20);
        starSpace = ta.getDimensionPixelSize(R.styleable.RatingBarView_starSpace, 5);
        starCount = ta.getInteger(R.styleable.RatingBarView_starCount, 5);
        starEmptyDrawable = ta.getDrawable(R.styleable.RatingBarView_starEmpty);
        starFillDrawable = ta.getDrawable(R.styleable.RatingBarView_starFill);
        ta.recycle();
    }

    private void createView(Context context) {
        CheckBox checkBox=null;
        for (int i = 0; i < starCount; ++i) {
            checkBox = getStarView(context);
            addView(checkBox);
            checkBox.setOnCheckedChangeListener(this);
        }
    }

    private CheckBox getStarView(Context context) {
        CheckBox checkBox = new CheckBox(context);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(Math.round(starImageSize), Math.round(starImageSize));
        params.setMargins(starSpace/2,0,starSpace/2,0);
        checkBox.setLayoutParams(params);
        checkBox.setButtonDrawable(null);
        checkBox.setBackground(starEmptyDrawable);
        checkBox.setCompoundDrawablePadding(5);
        return checkBox;
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if (mClickable) {
            mSelectedPosition = indexOfChild(compoundButton);
            setStarStatus(mSelectedPosition);
            if (onRatingListener != null) {
                onRatingListener.onRating(mSelectedPosition);
            }
        }
    }

    public void setStarStatus(int selected) {
        for (int i = 0; i < starCount; ++i) {
            if (i > selected) {
                setStarBackground(i, starEmptyDrawable);
            } else {
                switch (selected) {
                    case 0:
                        setStarBackground(i, R.drawable.ic_rating_nu);
                        break;
                    case 1:
                        setStarBackground(i, R.drawable.ic_rating_sad);
                        break;
                    default:
                        setStarBackground(i, R.drawable.ic_rating_small);
                        break;
                }
            }
        }
    }

    private void setStarBackground(int i, Drawable drawable) {
        ((CheckBox) getChildAt(i)).setButtonDrawable(null);
        ((CheckBox) getChildAt(i)).setBackground(drawable);
    }

    private void setStarBackground(int i, int reference) {
        ((CheckBox) getChildAt(i)).setButtonDrawable(null);
        ((CheckBox) getChildAt(i)).setBackground(getResources().getDrawable(reference));
    }

    public void setClickable(boolean clickable) {
        this.mClickable = clickable;
    }

    public void setOnRatingListener(OnRatingListener onRatingListener) {
        this.onRatingListener = onRatingListener;
    }

    public interface OnRatingListener {
        void onRating(int mSelectedPosition);
    }
}
