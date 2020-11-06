package com.example.myapplication.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.fragmentin.Fragment_In_One;
import com.example.myapplication.fragmentin.Fragment_In_Two;

import java.lang.reflect.Field;


public class BlankFragment extends Fragment {
    private static final String TAG = "BlankFragment";

    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    View rootView;

    private TabLayout tabLayout = null;

    private ViewPager viewPager;

    private Fragment[] mFragmentArrays = new Fragment[2];

    private String[] mTabTitles = new String[2];

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         rootView = inflater.inflate(R.layout.fragment_blank, container, false);
         tabLayout = (TabLayout)rootView.findViewById(R.id.tablayout);
         viewPager = (ViewPager)rootView.findViewById(R.id.tab_viewpager);
         initView();
         return  rootView;
    }



    private void initView() {
        mTabTitles[0] = "内部标题0";
        mTabTitles[1] = "内部标题1";
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        //设置tablayout距离上下左右的距离
        //tab_title.setPadding(20,20,20,20);

        mFragmentArrays[0] = new Fragment_In_One();
        mFragmentArrays[1] = new Fragment_In_Two();
        final PagerAdapter pagerAdapter = new MyViewPagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        //将ViewPager和TabLayout绑定
        tabLayout.setupWithViewPager(viewPager);
      /*  tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Log.d(TAG,"this is onTabSelected:" + tab.getPosition());
                if(tab.getPosition() == 2){
                   viewPager.setCurrentItem(2);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });*/

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


    @Override

    public void onDetach() {

        super.onDetach();

        try {

            Field childFragmentManager = Fragment.class.getDeclaredField("mChildFragmentManager");

            childFragmentManager.setAccessible(true);

            childFragmentManager.set(this, null);

        } catch (NoSuchFieldException e) {

            throw new RuntimeException(e);

        } catch (IllegalAccessException e) {

            throw new RuntimeException(e);

        }

    }

}