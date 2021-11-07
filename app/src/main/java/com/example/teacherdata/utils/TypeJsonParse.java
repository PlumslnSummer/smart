package com.example.teacherdata.utils;

import android.util.Log;

import com.example.teacherdata.bean.Data;
import com.example.teacherdata.bean.DataType;
import com.example.teacherdata.bean.TypeResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class TypeJsonParse {
    private static TypeJsonParse mInstance=null;

    public TypeJsonParse() {
    }

    public static TypeJsonParse getmInstance() {
        if(mInstance==null){
            mInstance=new TypeJsonParse();
        }
        return mInstance;
    }

    public static void setmInstance(TypeJsonParse mInstance) {
        TypeJsonParse.mInstance = mInstance;
    }

    public List<DataType> getDataType(String json)  {
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        Type type=new TypeToken<List<DataType>>(){}.getType();
        List<DataType> dataTypeList=new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray=jsonObject.getJSONArray("data");
            dataTypeList=gson.fromJson(String.valueOf(jsonArray),type);
//            Log.d("jsonArray数据输出：", String.valueOf(jsonArray));
        } catch (JSONException e) {
            e.printStackTrace();
        }
//        Log.e("type","datatype:"+dataTypeList);
        return dataTypeList;
    }
}
