package com.example.teacherdata.myview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

import com.example.teacherdata.adapter.HomeTypeAdapter;

public class HorizontalGridVew extends GridView {
    public HorizontalGridVew(Context context) {
        super(context);
    }

    public HorizontalGridVew(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HorizontalGridVew(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(expandSpec, heightMeasureSpec);
    }
}
