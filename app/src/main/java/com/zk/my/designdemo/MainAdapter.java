package com.zk.my.designdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by My on 2016/9/28.
 * tablayout和viewpager适配器
 */
public class MainAdapter extends FragmentPagerAdapter{

    private List<Fragment> fragments;//------->数据源

    private String[] tabs;

    public MainAdapter(FragmentManager fm, List<Fragment> fragments, String[] tabs) {
        super(fm);
        this.fragments = fragments;
        this.tabs = tabs;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    //设置tab标题 不用这个就无法显示----->为什么使用同一套适配器呢?
    @Override
    public CharSequence getPageTitle(int position) {
        return tabs[position];
    }
}
