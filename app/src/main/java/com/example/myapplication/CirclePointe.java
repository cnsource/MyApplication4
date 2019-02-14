package com.example.myapplication;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

public class CirclePointe extends View implements View.OnClickListener {
    private Paint mPain;
    private int mNumber;
    private float mWidth;
    private float mHeight;
    private Rect mRect;
    private float textWidth;
    private float textHeight;
    private int backGroundColor;
    public CirclePointe(Context context) {
        this(context,null);
    }

    public CirclePointe(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CirclePointe(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }

    private void init(Context context,AttributeSet attrs) {
        //声明画布
        mPain=new Paint();

        mRect=new Rect();
        mNumber=13;
        setOnClickListener(this);
        /*
        * 获得资源文件中的自定义属性
        * */
        TypedArray typedArray=context.obtainStyledAttributes(attrs,R.styleable.CirclePointe);
        backGroundColor=typedArray.getColor(R.styleable.CirclePointe_backGroundColor,Color.RED);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPain.setColor(backGroundColor);
        canvas.drawCircle(getWidth()/2,getHeight()/2,getWidth()/2,mPain);
        String number= String.valueOf(mNumber);
        mPain.setTextSize(150);
        mPain.getTextBounds(number,0,number.length(),mRect);
        textWidth=mRect.width();
        textHeight=mRect.height();
        mPain.setColor(Color.WHITE);
        canvas.drawText(number,getWidth()/2-textWidth/2,getHeight()/2+textHeight/2,mPain);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }

    @Override
    public void onClick(View v) {
        mNumber++;
        //刷新
        invalidate();
    }
}
