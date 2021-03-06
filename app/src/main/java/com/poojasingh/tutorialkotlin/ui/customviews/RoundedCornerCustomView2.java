package com.poojasingh.tutorialkotlin.ui.customviews;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class RoundedCornerCustomView2 extends View {
    private RectF baseBarRect, progressBarRect;
    private Paint baseBarPaint, progressBarPaint;
    private float barHeight;
    private Bitmap baseBitmap;
    private float progress;
    private int progressGradientColor2, progressGradientColor1;

    public RoundedCornerCustomView2(Context context) {
        super(context);
        init();
    }

    public RoundedCornerCustomView2(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RoundedCornerCustomView2(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        baseBarPaint = new Paint();
        baseBarPaint.setAntiAlias(true);
        baseBarPaint.setColor(Color.parseColor("#ccffcc"));
        progressBarPaint = new Paint();
        progressBarPaint.setAntiAlias(true);
        baseBarRect = new RectF();
        progressGradientColor2 = Color.parseColor("#2E7D32");
        progressGradientColor1 = Color.parseColor("#9BE29E");
        progressBarRect = new RectF();
    }

    public void setProgress(float percentage) {
        progress = percentage;
        invalidate();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(View.MeasureSpec.getSize(widthMeasureSpec), MeasureSpec.getSize(heightMeasureSpec));
        barHeight = getMeasuredHeight() * .50f;
        baseBarRect.left = 0;
        baseBarRect.top = 0;
        baseBarRect.right = getMeasuredWidth();
        baseBarRect.bottom = (int) (getMeasuredHeight());
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (changed) {
            baseBitmap = Bitmap.createBitmap(right - left, bottom - top, Bitmap.Config.ARGB_4444);
            Canvas canvas = new Canvas(baseBitmap);
            canvas.drawRoundRect(baseBarRect, (int) barHeight >> 1, (int) barHeight >> 1, baseBarPaint);
            Shader shader = new LinearGradient(
                    baseBarRect.left,
                    baseBarRect.top,
                    baseBarRect.right,
                    baseBarRect.top + baseBarRect.height(),
                    progressGradientColor1,
                    progressGradientColor2,
                    Shader.TileMode.CLAMP
            );
            progressBarPaint.setShader(shader);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(baseBitmap, 0, 0, null);
        progressBarRect.set(baseBarRect.left,
                baseBarRect.top,
                baseBarRect.left + (baseBarRect.width() * progress),
                baseBarRect.top + baseBarRect.height()
        );
        canvas.drawRoundRect(progressBarRect, (int) barHeight >> 1, (int) barHeight >> 1, progressBarPaint);
    }
}
