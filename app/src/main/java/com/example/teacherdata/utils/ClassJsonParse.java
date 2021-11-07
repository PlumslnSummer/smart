package com.example.teacherdata.utils;

import android.util.Log;
import android.widget.Toast;

import com.example.teacherdata.bean.Data;
import com.example.teacherdata.bean.HomeClassBean;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ClassJsonParse {
    private static ClassJsonParse minstance=null;

    private final String TAG="111";
    public ClassJsonParse() {
    }

    public static ClassJsonParse getMinstance() {
        if(minstance==null){
            minstance=new ClassJsonParse();
        }
        return minstance;
    }

    public List<Data> getdataClassList(String json){
        Gson gson=new Gson();
        //纯数组的解析方式
        Type type=new TypeToken<List<Data>>(){}.getType();
        List<Data> dataList1=new ArrayList<>();
        try {
            JSONObject object =  new JSONObject(new String(json));//获取json数据
            JSONArray jsonArray = object.getJSONArray("data");//获取数据集名称为obj的数据
            dataList1=gson.fromJson(String.valueOf(jsonArray),type);

        } catch (JSONException e) {
            Log.e(TAG, "数据请求失败，请稍后重试：" +json);
        }
//        Log.e("class","dataclass:"+dataList1);
        return dataList1;
    }
}
