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
import com.example.teacherdata.bean.DataType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HomeTypeAdapter extends BaseAdapter {
    private List<DataType> dataArrayList=new ArrayList<>();
    private Context mContext;
    private final String TAG="111";

    public HomeTypeAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public List<DataType> getDataArrayList() {
        return dataArrayList;
    }

    public void setDataArrayList(List<DataType> dataArrayList) {
        this.dataArrayList = dataArrayList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return dataArrayList==null?0:dataArrayList.size();
    }

    @Override
    public DataType getItem(int position) {
        return dataArrayList==null?null:dataArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if(convertView==null){
            convertView=View.inflate(mContext, R.layout.grid_type,null);
            holder=new ViewHolder();
            holder.iv_type=convertView.findViewById(R.id.iv_home_type);
            holder.tv_type=convertView.findViewById(R.id.tv_type);
            convertView.setTag(holder);
        }else {
            holder=(ViewHolder)convertView.getTag();
        }
        final DataType data=getItem(position);
        if(data!=null){
            holder.tv_type.setText(data.getTitle());
            Glide.with(mContext)
                    .load(data.getUrl())
                    .error(R.mipmap.ic_launcher)
                    .into(holder.iv_type);
        }

        return convertView;
    }
    class ViewHolder{
        ImageView iv_type;
        TextView tv_type;
    }
}
