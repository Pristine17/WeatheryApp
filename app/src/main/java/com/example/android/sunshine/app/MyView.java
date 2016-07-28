package com.example.android.sunshine.app;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by DavidDell on 7/2/2016.
 */
public class MyView extends View {

    private float direction;

    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, AttributeSet attrs, int DefaultStyle) {
        super(context, attrs, DefaultStyle);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int hSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        int hSpecSize = MeasureSpec.getSize(heightMeasureSpec);
        int myHeight = hSpecSize;

        if (hSpecMode == MeasureSpec.EXACTLY) {
            myHeight = hSpecSize;
        } else if (hSpecMode == MeasureSpec.AT_MOST) {

        }

        int wSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int wSpecSize = MeasureSpec.getSize(widthMeasureSpec);
        int myWidth = wSpecSize;

        if (wSpecMode == MeasureSpec.EXACTLY) {
            myWidth = wSpecSize;
        } else if (wSpecMode == MeasureSpec.AT_MOST) {

        }

        setMeasuredDimension(myWidth, myHeight);
    }


    @Override
    protected void onDraw(Canvas canvas) {

        int w = getMeasuredWidth();
        int h = getMeasuredHeight();
        int r;
        if (w > h) {
            r = h / 2;
        } else {
            r = w / 2;
        }

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        paint.setColor(Color.GRAY);

        canvas.drawCircle(w / 2, h / 2, r, paint);

        paint.setColor(getResources().getColor(R.color.sunshine_dark_blue));
        canvas.drawLine(
                w / 2,
                h / 2,
                (float) (w / 2 + r * Math.sin(-direction)),
                (float) (h / 2 - r * Math.cos(-direction)),
                paint);

    }

    public void update(float dir) {
        direction = -dir * ((float) Math.PI / 180);

        // Call invalidate to force drawing on page.

        invalidate();
    }
}
