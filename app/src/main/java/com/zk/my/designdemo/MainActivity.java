package com.zk.my.designdemo;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private NavigationView navigationView;

    //----------------ViewPager相关-----------------
    private static final String[] TABS = {"新闻","娱乐","体育","经济","政治","新闻","娱乐","体育","经济"};
    private List<Fragment> mainFragments;
    private MainAdapter mainAdapter;
    private ViewPager mainViewPager;
    private TabLayout tabLayout;


    //TODO 浮窗按钮
    private FloatingActionButton mainFab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initToolBar();
        initNavigationView();
        initMainViewPager();
        initFloatingActionButton();
    }
    //TODO floatButton
    private void initFloatingActionButton() {
        mainFab = (FloatingActionButton) findViewById(R.id.fab_main);
        mainFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //弹出SnackBar
                Snackbar.make(view, "是否收藏?", Snackbar.LENGTH_LONG)
                        .setAction("嗯哼", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                showToast("我点击了SnackBar的按钮");
                                //将对象的id 收藏,或者将url收藏
                            }
                        })
                        .show();
            }
        });
    }

    //TODO viewpager
    private void initMainViewPager() {
        // 初始化数据源(fragments)-->在Demo中数据源其实就是相同的MainFragment对象--->自己使用时可以添加多个
        mainFragments = new ArrayList<>();
        for (int i=0; i<TABS.length; i++) {
            Fragment fragment = new MainFragment();
            mainFragments.add(fragment);
        }
        //初始化适配器
        mainAdapter = new MainAdapter(getSupportFragmentManager(), mainFragments, TABS);//-----为什么适配器传递tabs
        //绑定适配器
        mainViewPager = (ViewPager) findViewById(R.id.viewpager_main);
        mainViewPager.setAdapter(mainAdapter);


        //绑定Tab
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(mainViewPager);//------------------>tablayout和viewpager关联
        //设置超屏数量
        mainViewPager.setOffscreenPageLimit(mainFragments.size() - 1);
    }

    //TODO 侧滑栏
    private void initNavigationView() {
        navigationView = (NavigationView) findViewById(R.id.navigationview);
        //监听菜单中item的点击事件
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_tab1:
                        showToast("Tab1");
                        mainViewPager.setCurrentItem(0);
                        break;
                    case R.id.menu_tab2:
                        showToast("Tab2");
                        mainViewPager.setCurrentItem(1);
                        break;
                    case R.id.menu_tab3:
                        showToast("Tab3");
                        mainViewPager.setCurrentItem(2);
                        break;
                    case R.id.menu_tab4:
                        showToast("Tab4");
                        mainViewPager.setCurrentItem(3);
                        break;
                }
                //关闭菜单
                drawerLayout.closeDrawers();
                return true;
            }
        });
    }

    private void showToast(String msg) {
        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
    }
    //TODO Toolbar
    private void initToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        //设置标题
        toolbar.setTitle("Material Design");


        //替换ActionBar
        setSupportActionBar(toolbar);

        //返回按钮设置
        //ActionBarDrawerToggle搭配DrawerLayout：1.改变android.R.id.home返回图标2.监听Drawer的展开与隐藏3.实现动画效果(返回按钮的动画效果)
        drawerLayout= (DrawerLayout) findViewById(R.id.drawerlayout);//------------>drawelayout到这一步才实例化!!
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, //字符串随便写的 就写名字吧
                R.string.navigation_drawer_close
        );
        toggle.syncState(); //展现返回按钮，监听Drawer的展开与隐藏
        drawerLayout.addDrawerListener(toggle); //实现按钮的动画效果
    }
}
