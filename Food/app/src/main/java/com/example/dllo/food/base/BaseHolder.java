package com.example.dllo.food.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * ✎﹏﹏﹏.₯㎕*﹏﹏﹏
 * 　　忍把浮名，
 * 　　　　换了浅斟低唱。
 * 　　　　 ﹏﹏﹏♥♥刘延涛✍♥♥﹏﹏
 */
public class BaseHolder extends RecyclerView.ViewHolder{
    private View mview;
    private SparseArray<View> sparseArray;
    private Context mcontext;

    public View getView() {
        return mview;
    }

    public BaseHolder(View itemView ,Context context) {
        super(itemView);
        mview = itemView;
        sparseArray = new SparseArray<>();
        mcontext = context;
    }
    //针对recycleview的初始化操作
    public static BaseHolder createViewHolder(Context context, ViewGroup group, int layoutId) {
        View itemView = LayoutInflater.from(context).inflate(layoutId, group, false);
        BaseHolder holder = new BaseHolder(itemView, context);
        return holder;
    }

    //针对listview的初始化操作
    public static BaseHolder createListViewHolder(View view, ViewGroup group, int layoutId) {
        BaseHolder holder = null;
        if (view == null) {
            view = LayoutInflater.from(group.getContext()).inflate(layoutId, group, false);
            holder = new BaseHolder(view, group.getContext());
            view.setTag(holder);
        } else {
            holder = (BaseHolder) view.getTag();
        }
        return holder;
    }
    //根据id获取我们想要的组件
    public <T extends View> T getView(int id) {
        //创建一个View 根据id从集合里面取出
        View view = sparseArray.get(id);
        //如果没有取到 那么就通过findViewById的方法绑定组件
        if (view == null) {
            view = mview.findViewById(id);
            sparseArray.put(id, view);
        }
        return (T) view;
    }

    public BaseHolder setText(int id, String s) {
        TextView textView = getView(id);
        if (s != null) {
            textView.setText(s);
        }
        return this;
    }

    public BaseHolder setImage(int id, String url) {
        ImageView imageView = getView(id);
        if (url != null) {
            Glide.with(mcontext).load(url).into(imageView);
        }
        return this;
    }

    public BaseHolder setImage(int id, int resource) {
        ImageView imageView = getView(id);
        if (resource != 0) {
            imageView.setImageResource(resource);
        }
        return this;
    }


}
