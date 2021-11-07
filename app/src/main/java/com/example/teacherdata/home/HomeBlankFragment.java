package com.example.teacherdata.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.teacherdata.R;
import com.example.teacherdata.adapter.GlideImageLoader;
import com.example.teacherdata.adapter.HomeClassAdapter;
import com.example.teacherdata.adapter.HomeListAdapter;
import com.example.teacherdata.adapter.HomeTypeAdapter;
import com.example.teacherdata.api.HttpbinService;
import com.example.teacherdata.bean.Data;
import com.example.teacherdata.bean.DataBanner;
import com.example.teacherdata.bean.DataType;
import com.example.teacherdata.myview.MyGridView;
import com.example.teacherdata.myview.Myviewpager;
import com.example.teacherdata.utils.ClassJsonParse;
import com.example.teacherdata.utils.Contants;
import com.example.teacherdata.utils.DensityUtil;
import com.example.teacherdata.utils.JsonParse;
import com.example.teacherdata.utils.TypeJsonParse;
import com.youth.banner.Banner;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeBlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeBlankFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private View rootview=null;
    public HomeBlankFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeBlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeBlankFragment newInstance(String param1, String param2) {
        HomeBlankFragment fragment = new HomeBlankFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    
    private HomeClassAdapter homeClassAdapter;
    private MyGridView gridView;
    private static final int MSG_OK=1;
    private MHandler mHandler;

    private GridView myGridView;
    private HomeTypeAdapter homeTypeAdapter;
    private static final int MSG_TYPE=1;
    private static final int MSG_Banner=2;
    private MHandlerty mHandlerty;


    private ListView listView;
    private HomeListAdapter homeListAdapter;
    private final String TAG="111";
    private Banner banner;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if(rootview==null){
            rootview=inflater.inflate(R.layout.fragment_home_blank, container, false);
        }
        mHandler=new MHandler();
        mHandlerty=new MHandlerty();

        initBanner();
        initData();
        initArticle();
        initType();
        initClassView();

        return rootview;
    }

    private void initBanner() {
//        OkHttpClient okHttpClient=new OkHttpClient();
//        Request request=new Request.Builder().url(Contants.WEB_INF).build();
//        Call call=okHttpClient.newCall(request);
//        call.enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                String resbanners=response.body().string();
//                Message msgbanner=new Message();
//                msgbanner.what=MSG_Banner;
//                msgbanner.obj=resbanners;
//                mHandlerty.sendMessage(msgbanner);
//            }
//        });

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(Contants.WEB_INF).build();
        HttpbinService httpbinService=retrofit.create(HttpbinService.class);
        retrofit2.Call<ResponseBody> call1=httpbinService.getBanner();
        call1.enqueue(new retrofit2.Callback<ResponseBody>() {
            @Override
            public void onResponse(retrofit2.Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
                try {
                    String banners=response.body().string();
                    List<DataBanner> dataBannerList= JsonParse.getMinstance().getBannersList(banners);

                    banner=rootview.findViewById(R.id.banner_home);
                    //设置图片加载器
                    banner.setImageLoader(new GlideImageLoader());
                    //                        设置图片集合
                    banner.setImages(dataBannerList);
                    banner.start();
                    Log.i("type:","banner："+dataBannerList);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(retrofit2.Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    private void initArticle() {
        OkHttpClient okHttpClient=new OkHttpClient();
        Request request=new Request.Builder().url(Contants.WEB_list).build();
        Call call=okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String reslist=response.body().string();
                Message msglist=new Message();
                msglist.what=MSG_OK;
                msglist.obj=reslist;
                mHandlerty.sendMessage(msglist);
            }
        });
    }

    private void initType() {
        OkHttpClient okHttpClient=new OkHttpClient();
        Request request=new Request.Builder().url(Contants.WEB_TYPE).build();
        Call call=okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String resty=response.body().string();
                Message msgty=new Message();
                msgty.what=MSG_TYPE;
                msgty.obj=resty;
                mHandlerty.sendMessage(msgty);

            }
        });
    }
    class MHandlerty extends Handler{
        @Override
        public void dispatchMessage(@NonNull Message msg) {
            super.dispatchMessage(msg);
            switch (msg.what){
                case MSG_TYPE:
                    if(msg.obj!=null){
                        String tyres= (String) msg.obj;
                        List<DataType> dataTypeList= TypeJsonParse.getmInstance().getDataType(tyres);
//                        Log.i("type:","空"+dataTypeList);
                        homeListAdapter.setDataList(dataTypeList);
                        homeTypeAdapter.setDataArrayList(dataTypeList);
                        changeGridView(dataTypeList);

                    }
                    break;
//                case MSG_Banner:
//                    if(msg.obj!=null){
//                        String banres= (String) msg.obj;
//                        List<DataBanner> dataBannerList= JsonParse.getMinstance().getBannersList(banres);
//
//                        banner=rootview.findViewById(R.id.banner_home);
//                        //设置图片加载器
//                        banner.setImageLoader(new GlideImageLoader());
//                        //                        设置图片集合
//                        banner.setImages(dataBannerList);
//                        banner.start();
//                        Log.i("type:","banner："+dataBannerList);
//                    }
//                    break;
            }
        }
    }


    private void initClassView() {
        gridView=rootview.findViewById(R.id.grid_home_class);
        homeClassAdapter=new HomeClassAdapter(getContext());
        gridView.setAdapter(homeClassAdapter);


        homeTypeAdapter=new HomeTypeAdapter(getContext());
        myGridView=rootview.findViewById(R.id.grid_home_type);
        myGridView.setAdapter(homeTypeAdapter);

        listView=rootview.findViewById(R.id.listview_acticle);
        homeListAdapter=new HomeListAdapter(getContext());
        listView.setAdapter(homeListAdapter);
    }
    private void changeGridView(List<DataType> dataTypeList){

        int size=dataTypeList.size();
        // item宽度
        int itemWIdth=DensityUtil.dip2px(getContext(),100);
        // item之间的间隔
        int itemPaddingH=DensityUtil.dip2px(getContext(),1);
        // 计算GridView宽度
        int gridviewWidth=size*(itemWIdth+itemPaddingH);
        LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(gridviewWidth,
                LinearLayout.LayoutParams.MATCH_PARENT);
        myGridView.setLayoutParams(params);
        myGridView.setColumnWidth(itemWIdth);
        myGridView.setHorizontalSpacing(itemPaddingH);
        myGridView.setStretchMode(GridView.NO_STRETCH);
        myGridView.setNumColumns(size);
    }

    private void initData() {
//        OkHttpClient okHttpClient=new OkHttpClient();
//        Request request=new Request.Builder().url(Contants.WEB_CLASS+Contants.REQUEST_URL).build();
//        Call call=okHttpClient.newCall(request);
//
//        call.enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//            }
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                String res=response.body().string();
//                Message msg=new Message();
//                msg.what=MSG_OK;
//                msg.obj=res;
//                mHandler.sendMessage(msg);
//
//            }
//        });


        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(Contants.WEB_CLASS).build();
        HttpbinService httpbinService=retrofit.create(HttpbinService.class);
        retrofit2.Call<ResponseBody> call=httpbinService.getAClass();
        call.enqueue(new retrofit2.Callback<ResponseBody>() {
            @Override
            public void onResponse(retrofit2.Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
                try {
                    String resclass=response.body().string();
//                    Message msgclass=new Message();
//                    msgclass.what=MSG_OK;
//                    msgclass.obj=resclass;
//                    mHandler.sendMessage(msgclass);
                    List<Data> dataList= ClassJsonParse.getMinstance().getdataClassList(resclass);
                    homeClassAdapter.setDataList(dataList);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(retrofit2.Call<ResponseBody> call, Throwable t) {

            }
        });
    }
    class MHandler extends Handler{
        @Override
        public void dispatchMessage(@NonNull Message msg) {
            super.dispatchMessage(msg);
//            switch (msg.what){
//                case MSG_OK:
//                    if(msg.obj!=null){
//                        String vlres=(String) msg.obj;
//                        List<Data> dataList= ClassJsonParse.getMinstance().getdataClassList(vlres);
//                        homeClassAdapter.setDataList(dataList);
//                    }
//                    break;
//
//            }
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}