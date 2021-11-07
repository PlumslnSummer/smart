package com.example.teacherdata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.teacherdata.adapter.ShuffingAdapter;
import com.example.teacherdata.home.HomeActivity;
import com.example.teacherdata.myview.Myviewpager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static List<Integer> slist=new ArrayList<>();
    private Myviewpager myviewpager;
    private ShuffingAdapter shuffingAdapter;
    private boolean istouchEvent=false;
    private LinearLayout linear_points;
    private Handler handler;
    static {
        slist.add(R.drawable.sky);
        slist.add(R.drawable.self);
        slist.add(R.drawable.hi);
        slist.add(R.drawable.please);
        slist.add(R.drawable.cat);
    }
    private Button btn_getInto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handler=new Handler();
        initView();
        initPager();
    }

    private void initPager() {
        btn_getInto=findViewById(R.id.btn_getIntoHome);
        btn_getInto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        myviewpager=findViewById(R.id.myviewpager);
        myviewpager.setOnTouchEventListeners(new Myviewpager.onTouchEventListeners() {
            @Override
            public void onTouchEventListener(boolean isTouch) {
                istouchEvent=isTouch;
            }

            @Override
            public void onPosition(int position) {

            }
        });
        shuffingAdapter=new ShuffingAdapter();
        shuffingAdapter.setMlist(slist);
        myviewpager.setAdapter(shuffingAdapter);
        myviewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                int relposition=0;
                if(shuffingAdapter.getMlist()!=0){
                    relposition=position%shuffingAdapter.getMlist();
                }
                setSelectedPoints(relposition);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        linear_points=findViewById(R.id.linear_points);
        initPoints();
        myviewpager.setCurrentItem(shuffingAdapter.getMlist()*100-1,false);
    }

    private void initPoints() {
        for(int i=0;i<shuffingAdapter.getMlist();i++){
            View points=new View(this);
            points.setBackgroundResource(R.drawable.points_normal);
            LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(40,40);
            params.leftMargin=20;
            points.setLayoutParams(params);
            linear_points.addView(points);
        }

    }

    private void setSelectedPoints(int relposition) {
        for(int i=0;i<linear_points.getChildCount();i++){
            View points=linear_points.getChildAt(i);
            if(i==relposition){
                points.setBackgroundResource(R.drawable.points_press);
            }else {
                points.setBackgroundResource(R.drawable.points_normal);
            }
        }
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        handler.post(runnable);
    }

    public Runnable runnable=new Runnable() {
        @Override
        public void run() {
            if(!istouchEvent){
                int current=myviewpager.getCurrentItem();
                myviewpager.setCurrentItem(++current,false);
            }
            handler.postDelayed(this,3000);

        }
    };
    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        handler.removeCallbacks(runnable);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}