package com.poojasingh.tutorialkotlin.ui.customviews;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.poojasingh.tutorialkotlin.R;

public class CustomViewExample extends View {
    private static final int SQUARE_SIZE = 5000;

    public CustomViewExample(Context context) {
        super(context);
        init(null);
    }

    public CustomViewExample(Context context, AttributeSet attrs) {
        super(context,attrs);
        init(attrs);
    }

    public CustomViewExample(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context,attrs,defStyleAttr);
        init(attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CustomViewExample(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context,attrs,defStyleAttr, defStyleRes);
        init(attrs);
    }

    private void init(@Nullable AttributeSet set){

    }

    @Override
    protected void onDraw(Canvas canvas) {

        RectF rect = new RectF();
        rect.left = 0;
        rect.top = 0;
        rect.right = rect.left + SQUARE_SIZE;
        rect.bottom = rect.top + SQUARE_SIZE;

        Paint paint = new Paint();
        paint.setColor(getContext().getResources().getColor(R.color.green_light3));

        //canvas.drawRect(rect, paint);
        canvas.drawRoundRect(rect,100,100,paint);

        super.onDraw(canvas);
    }
}
