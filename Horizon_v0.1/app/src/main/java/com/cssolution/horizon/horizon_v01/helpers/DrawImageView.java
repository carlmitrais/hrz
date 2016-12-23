package com.cssolution.horizon.horizon_v01.helpers;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.cssolution.horizon.horizon_v01.R;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Mohammad_T on 12/20/2016.
 */

enum DrawingType {
    LINE, TEXT
}

public class DrawImageView extends ImageView {

    private ArrayList<DrawingType> drawingActions = new ArrayList<>();
    private ArrayList<Path> linePaths = new ArrayList<>();
    private ArrayList<float[]> textCoordinates = new ArrayList<>();

    private Path path;
    
    private Bitmap mBitmap;

    private Paint paint;
    private Paint textPaint;
    
    private String type;
    private String note;

    private float mx, my;
    private Canvas mCanvas;
    private Context mContext;
    int mWidth, mHeight;
    private Boolean isDrawText = false;
    float textX = 0;
    float textY = 0;
    int current = 0;


    public DrawImageView(Context context, AttributeSet attrs){
        super(context, attrs);

        path = new Path();

        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(2);
    }

    public void setType(String type){
        this.type = type;
    }

    public void setNote(String note){
        this.note = note;
    }

//    @Override
//    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
//        super.onSizeChanged(w, h, oldw, oldh);
//
//        mWidth = w;
//        mHeight = h;
//        mBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
//        mCanvas = new Canvas(mBitmap);
//    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int width = getMeasuredWidth();
        int height = getMeasuredHeight();

        setMeasuredDimension(width, width);
//        setScaleType(ScaleType.FIT_XY);
//        setAdjustViewBounds(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (Path p : linePaths) {
            canvas.drawPath(p, paint);
        }

        if (!textCoordinates.isEmpty()) {
            for (float[] coordinate : textCoordinates) {
                canvas.drawText("Test.. Add text 1 ", coordinate[0], coordinate[1], paint);;
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (type != null ){
            float x = event.getX();
            float y = event.getY();
            if (type.contentEquals("Draw line")) {
                // code for draw line
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        onTouchDown(x, y);
                        invalidate();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        onTouchMove(x, y);
                        invalidate();
                        break;
                    case MotionEvent.ACTION_UP:
                        onTouchUp();
                        invalidate();
                        break;
                    default:
                        break;
                }
            }

            if (type.contentEquals("Write text")){
                // code for draw text, run the action on TOUCH DOWN motion event
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    textCoordinates.add(new float[]{x, y});
                    drawingActions.add(DrawingType.TEXT);
                }
            }
        }

        return true;
    }

    private void onTouchDown(float x, float y){
        linePaths.add(path);
        drawingActions.add(DrawingType.LINE);
        path.reset();
        path.moveTo(x, y);
        mx = x;
        my = y;
    }

    private void onTouchMove(float x, float y){
        if (Math.abs(x - mx) >= 0 || Math.abs(y - my) >= 0) {
            path.quadTo(x, y, (x + mx) / 2, (y + my) / 2);
            mx = x;
            my = y;
        }
    }

    private void onTouchUp(){
        path.lineTo(mx, my);
        path = new Path();
    }
    
    public void undo(){
        if (drawingActions.size() > 0) {
            if (drawingActions.get(drawingActions.size() - 1) == DrawingType.LINE) {
                if (linePaths.size() > 0) {
                    linePaths.remove(linePaths.size() - 1);
                    invalidate();
                    drawingActions.remove(drawingActions.size()-1);
                }
            }
            else if (drawingActions.get(drawingActions.size() - 1) == DrawingType.TEXT) {
                if (textCoordinates.size() > 0) {
                    textCoordinates.remove(textCoordinates.size() - 1);
                    invalidate();
                    drawingActions.remove(drawingActions.size() - 1);
                }
            }
        }
    }

    public void rotate(){
        current += 90;
        this.setRotation(current);
    }
}
