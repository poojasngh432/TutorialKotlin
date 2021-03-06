package com.poojasingh.tutorialkotlin.ui.customviews;

import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;

public class SquareToCircleCV extends View {

    private static final String PROPERTY_RADIUS = "property_radius";
    private static final String PROPERTY_ROTATE = "property_rotate";

    private RectF rectF = new RectF();

    private int radius = 0;
    private Paint backgroundPaint;
    private ValueAnimator animator;
    private int rotate;

    public SquareToCircleCV(Context context) {
        this(context, null);
    }

    public SquareToCircleCV(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SquareToCircleCV(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();

    }

    private void init() {
        backgroundPaint = new Paint();
        backgroundPaint.setDither(true);
        backgroundPaint.setStrokeWidth(5);
        backgroundPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        backgroundPaint.setColor(Color.RED);
        backgroundPaint.setColorFilter(new ColorFilter());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int viewWidth = getWidth() / 2;
        int viewHeight = getHeight() / 2;

        int leftTopX = viewWidth - 150;
        int leftTopY = viewHeight - 150;

        int rightBotX = viewWidth + 150;
        int rightBotY = viewHeight + 150;
        // Add rotation effect
//        canvas.rotate(rotate, viewWidth, viewHeight);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            canvas.drawRoundRect(leftTopX, leftTopY, rightBotX, rightBotY, radius, radius, backgroundPaint);
        } else {
            rectF.set(leftTopX,leftTopY,rightBotX,rightBotY);
            canvas.drawRoundRect(rectF, radius, radius, backgroundPaint);
        }
    }


    /**
     * Turn on animation
     */
    public void startAnimation() {
        PropertyValuesHolder propertyRadius = PropertyValuesHolder.ofInt(PROPERTY_RADIUS, 0, 150);
        // rotation property
        PropertyValuesHolder propertyRotate = PropertyValuesHolder.ofInt(PROPERTY_ROTATE, 0, 360);

        animator = new ValueAnimator();
        animator.setValues(propertyRadius, propertyRotate);
        animator.setDuration(2000);
        animator.addUpdateListener(animation -> {
            radius = (int) animation.getAnimatedValue(PROPERTY_RADIUS);
//            rotate = (int) animation.getAnimatedValue(PROPERTY_ROTATE);
            invalidate();
        });
        animator.start();
    }
}