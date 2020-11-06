package com.example.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import com.example.myapplication.fragment.BlankFragment;
import com.example.myapplication.fragment.FragmentOne;
import com.example.myapplication.fragment.FragmentThr;
import com.example.myapplication.fragment.FragmentTwo;

/**
 * Created by zq on 2017/1/12.
 */

public class TabLessActivity extends AppCompatActivity {

    private TabLayout tabLayout = null;

    private ViewPager viewPager;

    private Fragment[] mFragmentArrays = new Fragment[4];

    private String[] mTabTitles = new String[4];

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.tab_layout);
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        viewPager = (ViewPager) findViewById(R.id.tab_viewpager);
        initView();
    }

    private void initView() {
        mTabTitles[0] = "外部标题0";
        mTabTitles[1] = "外部标题1";
        mTabTitles[2] = "外部标题2";
        mTabTitles[3] = "外部标题3";
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        //设置tablayout距离上下左右的距离
        //tab_title.setPadding(20,20,20,20);
        mFragmentArrays[0] = new BlankFragment();
        mFragmentArrays[1] = new FragmentOne();
        mFragmentArrays[2] = new FragmentTwo();
        mFragmentArrays[3] = new FragmentThr();

        PagerAdapter pagerAdapter = new MyViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        //将ViewPager和TabLayout绑定
        tabLayout.setupWithViewPager(viewPager);
    }

    final class MyViewPagerAdapter extends FragmentPagerAdapter {
        public MyViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentArrays[position];
        }


        @Override
        public int getCount() {
            return mFragmentArrays.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTabTitles[position];

        }
    }
}
