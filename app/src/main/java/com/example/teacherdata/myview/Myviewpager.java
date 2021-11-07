package com.example.teacherdata.myview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

public class Myviewpager extends ViewPager {
    private onTouchEventListeners onTouchEventListeners;

    public Myviewpager.onTouchEventListeners getOnTouchEventListeners() {
        return onTouchEventListeners;
    }

    public void setOnTouchEventListeners(Myviewpager.onTouchEventListeners onTouchEventListeners) {
        this.onTouchEventListeners = onTouchEventListeners;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                if(onTouchEventListeners!=null){
                    onTouchEventListeners.onTouchEventListener(true);
                }
                break;
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:
                if (onTouchEventListeners!=null){
                    onTouchEventListeners.onTouchEventListener(false);
                    onTouchEventListeners.onPosition(getCurrentItem());
                }
                break;
        }
        return super.onTouchEvent(ev);
    }

    public Myviewpager(@NonNull Context context) {
        super(context);
    }

    public Myviewpager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    public interface onTouchEventListeners{
        void onTouchEventListener(boolean isTouch);
        void onPosition(int position);
    }
}
