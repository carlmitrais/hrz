package com.cssolution.horizon.horizon_v01.helpers;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;

/**
 * Created by Mohammad_T on 12/20/2016.
 */
public class DrawImageView extends ImageView {

    private Paint linePaint;
    private Paint textPaint;
    private Path path;
    private Canvas mCanvas;

    private String type;
    private String note;

    private float mx, my;

    public DrawImageView(Context context, AttributeSet attrs){
        super(context, attrs);

        linePaint = new Paint();
        linePaint.setColor(Color.RED);
        linePaint.setStyle(Paint.Style.STROKE);
        linePaint.setStrokeJoin(Paint.Join.ROUND);
        linePaint.setStrokeCap(Paint.Cap.ROUND);
        linePaint.setStrokeWidth(4);

        textPaint = new Paint();
        textPaint.setColor(Color.RED);
        textPaint.setStyle(Paint.Style.STROKE);
        textPaint.setStrokeWidth(4);

        path = new Path();
    }

    public void setType(String type){
        this.type = type;
    }

    public void setNote(String note){
        this.note = note;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        canvas.drawPath(path, linePaint);
//        canvas.drawText("Test.. Add text",50, 50, textPaint);
        mCanvas = canvas;
        mCanvas.drawPath(path, linePaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (type != null ){
            float x = event.getX();
            float y = event.getY();
            switch (event.getAction()){
                case MotionEvent.ACTION_DOWN:
                    onTouchDown(x, y);
                    invalidate();
                    break;
                case MotionEvent.ACTION_MOVE:
                    onTouchMove(x, y);
                    invalidate();
                    break;
                case MotionEvent.ACTION_UP:
                    onTouchUp(x, y);
                    invalidate();
                    break;
                default:
                    break;
            }
        }

        return true;
    }

    private void onTouchDown(float x, float y){
//        mCanvas.drawPath(path, linePaint);
        path.moveTo(x, y);
        mx = x;
        my = y;
    }

    private void onTouchMove(float x, float y){
        if (Math.abs(x - mx) >= 4 || Math.abs(y - my) >= 4) {
            path.quadTo(x, y, (x + mx) / 2, (y + my) / 2);
            mx = x;
            my = y;
        }
//        path.lineTo(x, y);
    }

    private void onTouchUp(float x, float y){
        path.lineTo(mx, my);
//        if (type.contentEquals("Draw line")){
//            mCanvas.drawPath(path, linePaint);
//        path.reset();
//        }
    }

}
