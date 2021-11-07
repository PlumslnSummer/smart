package com.example.teacherdata.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.teacherdata.R;
import com.example.teacherdata.bean.DataType;

import java.util.ArrayList;
import java.util.List;

public class HomeListAdapter extends BaseAdapter {
    private List<DataType>  dataList=new ArrayList<>();
    private Context mContext;

    public HomeListAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public List<DataType> getDataList() {
        return dataList;
    }

    public void setDataList(List<DataType> dataList) {
        this.dataList = dataList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return dataList==null?0:dataList.size();
    }

    @Override
    public DataType getItem(int position) {
        return dataList==null?null:dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if(convertView==null){
            convertView=View.inflate(mContext, R.layout.list_item_article,null);
            holder=new ViewHolder();
            holder.iv_home_article=convertView.findViewById(R.id.iv_home_article1);
            holder.tv_title=convertView.findViewById(R.id.tv_home_article_title);
            holder.tv_author=convertView.findViewById(R.id.tv_home_article_author);
            holder.tv_view=convertView.findViewById(R.id.tv_home_article_view);
            holder.tv_date=convertView.findViewById(R.id.tv_home_article_date);
            convertView.setTag(holder);
        }else{
            holder=(ViewHolder)convertView.getTag();
        }
        final DataType dataType=getItem(position);
        if(dataType!=null){
            holder.tv_title.setText(dataType.getDesc());
            holder.tv_author.setText(dataType.getAuthor());
            holder.tv_view.setText(dataType.getViews()+"阅读");
            holder.tv_date.setText(dataType.getCreatedAt());
            Glide.with(mContext)
                    .load(dataType.getUrl())
                    .error(R.mipmap.ic_launcher)
                    .into(holder.iv_home_article);
        }
        return convertView;
    }
    class ViewHolder{
        ImageView iv_home_article;
        TextView tv_title,tv_author,tv_view,tv_date;

    }
}
