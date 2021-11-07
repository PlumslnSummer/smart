package com.example.teacherdata.adapter;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.teacherdata.R;
import com.example.teacherdata.bean.DataBanner;
import com.youth.banner.loader.ImageLoader;

public class GlideImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        DataBanner dataBanner=(DataBanner) path;
        Log.i("type:","banner："+dataBanner.getImage());
        Log.i("type:","banner："+path);

        Glide.with(context)
                .load(dataBanner.getImage())
                .error(R.mipmap.ic_launcher)
                .into(imageView);
    }
}
