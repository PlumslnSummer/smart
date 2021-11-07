package com.example.teacherdata.utils;


import android.util.Log;

import com.example.teacherdata.bean.Data;
import com.example.teacherdata.bean.DataBanner;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonParse {
    private static JsonParse minstance=null;

    public JsonParse() {
    }

    public static JsonParse getMinstance() {
        if(minstance==null){
            minstance=new JsonParse();
        }
        return minstance;
    }

    public List<DataBanner> getBannersList(String json){
        Gson gson=new Gson();
        Type type=new TypeToken<List<DataBanner>>(){}.getType();
        List<DataBanner> bannerList=new ArrayList<>();

        try {
            JSONObject jsonObject=new JSONObject(json);
            JSONArray jsonArray=jsonObject.getJSONArray("data");

            bannerList=gson.fromJson(String.valueOf(jsonArray),type);
//            Log.d("jsonArraybanner数据输出：", String.valueOf(jsonArray));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.e("jsonparse","data:"+bannerList);
        return bannerList;
    }

}
