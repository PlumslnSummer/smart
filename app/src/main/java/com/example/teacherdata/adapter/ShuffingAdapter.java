package com.example.teacherdata.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.teacherdata.bean.DataBanner;

import java.util.ArrayList;
import java.util.List;

public class ShuffingAdapter extends PagerAdapter {
    private List<Integer> mlist;
    private List<DataBanner> bannersBeanList;

    public int getBannersBeanList() {
        if(bannersBeanList!=null){
            return bannersBeanList.size();
        }
        return 0;
    }

    public void setBannersBeanList(List<DataBanner> bannersBeanList) {
        this.bannersBeanList = bannersBeanList;

    }

    public int getMlist() {
        if(mlist!=null){
            return mlist.size();
        }
        return 0;
    }

    public void setMlist(List<Integer> list) {
        mlist=new ArrayList<>();
        mlist.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        if(mlist!=null){
            return Integer.MAX_VALUE;
        }
        return 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        int relposition=position%mlist.size();
        ImageView imageView=new ImageView(container.getContext());
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setBackgroundResource(mlist.get(relposition));
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
