package com.zk.my.designdemo;


import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {
    private int imgid[]={R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher};

    //数据源  适配器 控件 三大将
    private List<DataInfo> datas;
    private MyAdapter adapter;
    private RecyclerView recyclerView;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_main, container, false);
        initDatas();//实例化数据源
        initView(inflate);//实例化控件 设置监听
        return inflate;
    }
//TODO 初始化数据源
    private void initDatas() {
        datas =new ArrayList<>();
        for (int i=0; i<imgid.length; i++) {
            if(i%4==0){
                DataInfo data =new DataInfo();
                data.setType(0);
                data.setTxt1("标题"+datas.size());
                data.setTxt2("描述"+datas.size());
                data.setBitmap(imgid[i]);
                datas.add(data);
            }
           else{
                DataInfo data =new DataInfo();
                data.setType(1);
                data.setTxt1("标题"+datas.size());
                data.setBitmap(imgid[i]);
                datas.add(data);
            }

        }

    }
// TODO 初始化视图
    private void initView(View frragmentView) {
        adapter=new MyAdapter(getContext(),datas);
        recyclerView=(RecyclerView) frragmentView.findViewById(R.id.recyclerview);
        recyclerView.setAdapter(adapter);

        //加载布局管理器----------->布局加载器动态设置recyclerView的方向, 默认的好想就是vertical方向吧,和listview一样
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(OrientationHelper.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
    }

}
