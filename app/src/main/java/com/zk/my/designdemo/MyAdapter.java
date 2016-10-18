package com.zk.my.designdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by bodhixu on 2016/9/29
 * recyclerView适配器.

 */
public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context context;
    private List<DataInfo> datas;


    public MyAdapter(Context context, List<DataInfo> datas) {//传入上下文和数据源,上下文是为了加载布局,数据源是为了 进入适配器
        this.context = context;
        this.datas = datas;
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    @Override
    public int getItemViewType(int position) {
        return datas.get(position).getType();//===================>通过data获得type 妈的 真是小技巧
    }

    @Override//--返回viewholder啊,不用自己设置真好,加载控件
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView;
        if (viewType == 0) {
            itemView = LayoutInflater.from(context).inflate(R.layout.layout_item1, parent, false);//------这里不嗯给你使用parent啊!!
            return new MyViewHolder1(itemView);
        } else {
            itemView = LayoutInflater.from(context).inflate(R.layout.layout_item2, parent, false);
            return  new MyViewHolder2(itemView);
        }
    }

    @Override//--------有了viewholder之后 绑定数据 形成适配器
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        DataInfo data = datas.get(position);//拿到数据

        if (holder instanceof MyViewHolder1) {//----根据holder的类型分配属性=====>根据viewholder绑定---其实,说白了,viewholder的type哪里来的,不还是data那里得到吗!
            MyViewHolder1 viewHolder1 = (MyViewHolder1) holder;
            viewHolder1.tv1.setText(data.getTxt1());//控件设置数据
            viewHolder1.tv2.setText(data.getTxt2());
            viewHolder1.iv.setImageResource(data.getBitmap());
        } else if (holder instanceof MyViewHolder2) {
            MyViewHolder2 viewHolder2 = (MyViewHolder2) holder;
            viewHolder2.tv1.setText(data.getTxt1());
            viewHolder2.iv.setImageResource(data.getBitmap());
        }

//        switch (data.getType()){//==============================================>根据数据data绑定
//            case 0:
//                MyViewHolder1 viewHolder1 = (MyViewHolder1) holder;
//                viewHolder1.tv1.setText(data.getTxt1());
//                viewHolder1.tv2.setText(data.getTxt2());
//                break;
//            case 1:
//                MyViewHolder2 viewHolder2 = (MyViewHolder2) holder;
//                viewHolder2.tv1.setText(data.getTxt1());
//                break;
//        }
    }

    class MyViewHolder1 extends RecyclerView.ViewHolder{
        TextView tv1, tv2;//实例化控件哎
        ImageView iv;
        public MyViewHolder1(View itemView) {
            super(itemView);
            tv1 = (TextView) itemView.findViewById(R.id.tv1);
            tv2 = (TextView) itemView.findViewById(R.id.tv2);
            iv=(ImageView) itemView.findViewById(R.id.iv);
        }
    }

    class MyViewHolder2 extends RecyclerView.ViewHolder{
        TextView tv1;ImageView iv;
        public MyViewHolder2(View itemView) {
            super(itemView);
            tv1 = (TextView) itemView.findViewById(R.id.tv1);
            iv=(ImageView) itemView.findViewById(R.id.iv);
        }
    }
}
