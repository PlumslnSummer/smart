package com.example.teacherdata.utils;

import android.content.Context;

public class DensityUtil {
    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     * @param context   上下文
     * @param dpValue   dp值
     * @return  px值
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

//    public static int dpl(Context context,float dpvalue){
//        final  float scale=context.getResources().getDisplayMetrics().density;
//        return(int)(dpvalue*scale+0.5f);
//    }
}
