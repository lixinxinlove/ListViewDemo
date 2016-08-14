package com.love.lixinxin.listview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by lixinxin on 2016/8/14.
 */
public class ListAdapter extends BaseAdapter {


    public ArrayList<String> mData;
    public Context context;
    public ListAdapter(Context context, ArrayList<String> mData){
        this.mData=mData;
        this.context=context;

    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public String  getItem(int i) {
        return mData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder=new ViewHolder();
        if(view==null){
            view=View.inflate(context,R.layout.item_list,null);
            holder.tv= (TextView) view.findViewById(R.id.tv);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }


        holder.tv.setText(mData.get(i));


        return view;
    }


    static class ViewHolder{

       public TextView tv;

    }
}
