package com.example.dsmolyak.mapapp;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.RelativeLayout;

/**
 * Created by dsmolyak on 4/5/16.
 */
public class ZoomableRelativeLayout extends RelativeLayout {
    private static final float MIN_SCALE = 1;
    private static final float MAX_SCALE = 4;
    float mScaleFactor = 1;
    float mPivotX;
    float mPivotY;

    public ZoomableRelativeLayout(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
    }

    public ZoomableRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

    public ZoomableRelativeLayout(Context context, AttributeSet attrs,
                                  int defStyle) {
        super(context, attrs, defStyle);
        // TODO Auto-generated constructor stub
    }

    protected void dispatchDraw(Canvas canvas) {
        canvas.save(Canvas.MATRIX_SAVE_FLAG);
        canvas.scale(mScaleFactor, mScaleFactor, mPivotX, mPivotY);
        super.dispatchDraw(canvas);
//        canvas.restore();
    }

    public void scale(float scaleFactor, float pivotX, float pivotY) {
        mScaleFactor = scaleFactor;
        mPivotX = pivotX;
        mPivotY = pivotY;
        this.invalidate();
    }

    public void restore() {
        mScaleFactor = 2;
        this.invalidate();
    }

    public void relativeScale(float scaleFactor, float pivotX, float pivotY)
    {
        mScaleFactor *= scaleFactor;

        if(scaleFactor >= 1) {
            mPivotX = mPivotX + (pivotX - mPivotX) * (1 - 1 / scaleFactor);
            mPivotY = mPivotY + (pivotY - mPivotY) * (1 - 1 / scaleFactor);
        }
        else {
            pivotX = getWidth()/2;
            pivotY = getHeight()/2;

            mPivotX = mPivotX + (pivotX - mPivotX) * (1 - scaleFactor);
            mPivotY = mPivotY + (pivotY - mPivotY) * (1 - scaleFactor);
        }

        this.invalidate();
    }

    public void release()
    {
        if(mScaleFactor < MIN_SCALE)
        {
            final float startScaleFactor = mScaleFactor;

            Animation a = new Animation()
            {
                @Override
                protected void applyTransformation(float interpolatedTime, Transformation t) {
                    scale(startScaleFactor + (MIN_SCALE - startScaleFactor)*interpolatedTime,mPivotX,mPivotY);
                }
            };

            a.setDuration(300);
            startAnimation(a);
        }
        else if(mScaleFactor > MAX_SCALE)
        {
            final float startScaleFactor = mScaleFactor;

            Animation a = new Animation()
            {
                @Override
                protected void applyTransformation(float interpolatedTime, Transformation t)
                {
                    scale(startScaleFactor + (MAX_SCALE - startScaleFactor)*interpolatedTime,mPivotX,mPivotY);
                }
            };

            a.setDuration(300);
            startAnimation(a);
        }
    }

}