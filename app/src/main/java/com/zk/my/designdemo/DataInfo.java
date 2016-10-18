package com.zk.my.designdemo;

import android.graphics.Bitmap;

/**
 * Created by bodhixu on 2016/9/28.
 */
public class DataInfo {

    private String txt1;//数据源根据最大的item布局来确定 内部的属性个数 没有的设置为空就行了

    private String txt2;

    //图片id
   private  int bitmapid;

    private int type;//标记该数据的类型是----->小技巧
    public int getBitmap() {
        return bitmapid;
    }

    public void setBitmap(int bitmapid) {
        this.bitmapid = bitmapid;
    }

    public String getTxt1() {
        return txt1;
    }

    public void setTxt1(String txt1) {
        this.txt1 = txt1;
    }

    public String getTxt2() {
        return txt2;
    }

    public void setTxt2(String txt2) {
        this.txt2 = txt2;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
