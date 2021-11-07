package com.example.teacherdata.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.teacherdata.R;
import com.example.teacherdata.bean.Data;

import java.util.ArrayList;
import java.util.List;

public class HomeClassAdapter extends BaseAdapter {
    private Context mContext;
    private List<Data> dataList =new ArrayList<>();

    private final String TAG1="222";

    public HomeClassAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public List<Data> getDataList() {
        return dataList;
    }

    public void setDataList(List<Data> dataList) {
        this.dataList = dataList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return dataList ==null?0: dataList.size();
    }

    @Override
    public Data getItem(int position) {
        return dataList ==null?null: dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if(convertView==null){
            convertView=View.inflate(mContext, R.layout.grid_home_class,null);
            holder=new ViewHolder();
            holder.iv_home_class=convertView.findViewById(R.id.iv_home_class);
            holder.tv_home_class=convertView.findViewById(R.id.tv_home_class);
            convertView.setTag(holder);
        }else{
            holder=(ViewHolder)convertView.getTag();
        }
        final Data dataClass=getItem(position);
        Log.e(TAG1, "adapter1："+dataClass.getTitle());
        if(dataClass!=null){
            holder.tv_home_class.setText(dataClass.getTitle());
            Glide.with(mContext)
                    .load(dataClass.getCoverImageUrl())
                    .error(R.drawable.hungry)
                    .into(holder.iv_home_class);
        }

        return convertView;
    }
    class ViewHolder{
        ImageView iv_home_class;
        TextView tv_home_class;
    }
}
