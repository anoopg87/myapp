package com.example.mfluid.myapp;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Toast;


public class SemiCircleProgressBarView extends View {

    private Path mClippingPath;
    private Context mContext;
    private Bitmap mBitmap;
    private float mPivotX;
    private float mPivotY;
    int mParentWidth;
    int mParentHeight;
    int mResourceID;

    public SemiCircleProgressBarView(Context context,int resourceID,int parentWidth,int parentHeight) {
        super(context);
        mContext = context;
        mResourceID=resourceID;
        mParentWidth=parentWidth;
        mParentHeight=parentHeight;
        initilizeImage();

    }

    public SemiCircleProgressBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        mParentWidth=164;
        mParentHeight=164;
        mResourceID=R.drawable.white;
        initilizeImage();
    }

    public void setBackgroundSpec(int resourceID,int parentWidth,int parentHeight){
        mResourceID=resourceID;
        mParentWidth=parentWidth;
        mParentHeight=parentHeight;
        initilizeImage();
    }



    private void initilizeImage() {
        mClippingPath = new Path();

        //Top left coordinates of image. Give appropriate values depending on the position you wnat image to be placed
        mPivotX = 0;
        mPivotY = 0;

        //Adjust the image size to support different screen sizes
        Bitmap bitmap = BitmapFactory.decodeResource(mContext.getResources(),mResourceID);
        int imageWidth = (int) ( mParentWidth );
        int imageHeight = (int) ( mParentWidth );
        mBitmap = Bitmap.createScaledBitmap(bitmap, imageWidth, imageHeight, false);
    }

    public void setClipping(float progress) {

        //Convert the progress in range of 0 to 100 to angle in range of 0 180. Easy math.
        float angle = (progress * 270) / 100;
        mClippingPath.reset();
        //Define a rectangle containing the image
        RectF oval = new RectF(mPivotX, mPivotY, mPivotX + mBitmap.getWidth(), mPivotY + mBitmap.getHeight());
        //Move the current position to center of rect
        mClippingPath.moveTo(oval.centerX(), oval.centerY());
        //Draw an arc from center to given angle
        mClippingPath.addArc(oval, 135, angle);
        //Draw a line from end of arc to center
        mClippingPath.lineTo(oval.centerX(), oval.centerY());
        //Redraw the canvas
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //Clip the canvas
        canvas.clipPath(mClippingPath);
        canvas.drawBitmap(mBitmap, mPivotX, mPivotY, null);

    }



}