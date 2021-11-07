package com.example.teacherdata.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.teacherdata.R;
import com.example.teacherdata.adapter.MyFragmentAdapter;
import com.example.teacherdata.news.NewsBlankFragment;
import com.example.teacherdata.party.PartyBlankFragment;
import com.example.teacherdata.person.PersonBlankFragment;
import com.example.teacherdata.services.ServicesBlankFragment;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener{

    private LinearLayout linear_home,linear_services,linear_news,linear_party,linear_person;
    private ImageView iv_home,iv_services,iv_news,iv_party,iv_person,iv_current;
    private ViewPager2 viewPager2;
    private MyFragmentAdapter myFragmentAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
        initPager();
    }

    private void initView() {
        linear_home=findViewById(R.id.linear_home);
        linear_services=findViewById(R.id.linear_services);
        linear_news=findViewById(R.id.linear_news);
        linear_party=findViewById(R.id.linear_party);
        linear_person=findViewById(R.id.linear_person);

        linear_home.setOnClickListener(this);
        linear_services.setOnClickListener(this);
        linear_news.setOnClickListener(this);
        linear_party.setOnClickListener(this);
        linear_person.setOnClickListener(this);

        iv_home=findViewById(R.id.iv_home);
        iv_services=findViewById(R.id.iv_services);
        iv_news=findViewById(R.id.iv_news);
        iv_party=findViewById(R.id.iv_party);
        iv_person=findViewById(R.id.iv_person);
        iv_current=iv_home;
        iv_home.setSelected(true);
    }

    private void initPager() {
        viewPager2=findViewById(R.id.viewpager2_home);
        ArrayList<Fragment> fragments=new ArrayList<>();
        fragments.add(HomeBlankFragment.newInstance("首页","首页"));
        fragments.add(ServicesBlankFragment.newInstance("服务","服务"));
        fragments.add(NewsBlankFragment.newInstance("新闻","新闻"));
        fragments.add(PartyBlankFragment.newInstance("活动","活动"));
        fragments.add(PersonBlankFragment.newInstance("个人","个人"));
        myFragmentAdapter=new MyFragmentAdapter(getSupportFragmentManager(),getLifecycle(),fragments);
        viewPager2.setAdapter(myFragmentAdapter);
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                changeTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
    }

    private void changeTab(int position) {
        iv_current.setSelected(false);
        switch (position){
            case R.id.linear_home:
                viewPager2.setCurrentItem(0);
            case 0:
                iv_home.setSelected(true);
                iv_current=iv_home;
                break;
            case R.id.linear_services:
                viewPager2.setCurrentItem(1);
            case 1:
                iv_services.setSelected(true);
                iv_current=iv_services;
                break;
            case R.id.linear_news:
                viewPager2.setCurrentItem(2);
            case 2:
                iv_news.setSelected(true);
                iv_current=iv_news;
                break;
            case R.id.linear_party:
                viewPager2.setCurrentItem(3);
            case 3:
                iv_party.setSelected(true);
                iv_current=iv_party;
                break;
            case R.id.linear_person:
                viewPager2.setCurrentItem(4);
            case 4:
                iv_person.setSelected(true);
                iv_current=iv_person;
                break;
        }
    }

    @Override
    public void onClick(View v) {
        changeTab(v.getId());
    }
}