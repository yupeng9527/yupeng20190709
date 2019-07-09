package com.bawei.yupeng201979.view.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.yupeng201979.R;
import com.bawei.yupeng201979.bean.Bean;
import com.bawei.yupeng201979.moudel.http.HttpUtils;
import com.bawei.yupeng201979.view.activity.MainActivity;

import java.util.List;

/*
 *
 * 姓名：于鹏
 * 创建时间：
 * 具体功能：
 */public class MyAdapter extends BaseAdapter {
     private List<Bean> list;
     private Context context;
     private HttpUtils httpUtils = HttpUtils.getInstance();

    public MyAdapter(List<Bean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView ==null){
            convertView = View.inflate(context, R.layout.item,null);
            holder = new ViewHolder();
            holder.iv = convertView.findViewById(R.id.iv);
            holder.tv = convertView.findViewById(R.id.tv);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tv.setText(list.get(position).getCommodityName());
        final ViewHolder finholder = holder;
        httpUtils.Taskb(list.get(position).getMasterPic(), new HttpUtils.Backb() {
            @Override
            public void getDatab(Bitmap bitmap) {
                finholder.iv.setImageBitmap(bitmap);
            }
        });
        return convertView;
    }
    class ViewHolder{
        TextView tv;
        ImageView iv;
    }
}
