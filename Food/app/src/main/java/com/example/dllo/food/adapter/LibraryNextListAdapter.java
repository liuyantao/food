package com.example.dllo.food.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dllo.food.R;
import com.example.dllo.food.base.BaseHolder;
import com.example.dllo.food.bean.LibraryNextBean;
import com.example.dllo.food.util.NextTool;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * ✎﹏﹏﹏.₯㎕*﹏﹏﹏
 *
 *
 * 　　　　 ﹏﹏﹏♥♥刘延涛✍♥♥﹏﹏
 */
public class LibraryNextListAdapter extends BaseAdapter {
  private   Context mContext;
    private  List<LibraryNextBean.FoodsBean> datas;


    public LibraryNextListAdapter(Context context) {
        mContext = context;

    }

    public void setDatas(List<LibraryNextBean.FoodsBean> datas) {
        this.datas = datas;
        Log.d("LibraryNextListAdapter", "datas.size():" + datas.size());
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return datas.size() > 0 && datas !=null ? datas.size():0;
    }

    @Override
    public Object getItem(int i) {
        return datas.size() >= 0 && datas != null ? datas.get(i) : null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        MyViewHolder myViewHolder = null;
        if (view == null){
            view = LayoutInflater.from(mContext).
                    inflate(R.layout.item_library_next,viewGroup,false);
            myViewHolder = new MyViewHolder(view);
            view.setTag(myViewHolder);


        }else {
            myViewHolder = (MyViewHolder) view.getTag();
        }

        Glide.with(mContext).load(datas.get(i).getThumb_image_url()).into(myViewHolder.circle);
        myViewHolder.title.setText(datas.get(i).getName());
        myViewHolder.weight.setText(datas.get(i).getCalory() + "");

        if ( 1 == datas.get(i).getHealth_light()){
            myViewHolder.light.setImageResource(R.mipmap.ic_food_light_green);
        }if (2 == datas.get(i).getHealth_light()){
            myViewHolder.light.setImageResource(R.mipmap.ic_food_light_yellow);
        }if (3 == datas.get(i).getHealth_light()){
            myViewHolder.light.setImageResource(R.mipmap.ic_food_light_red);
        }
        return view;
    }
    class MyViewHolder{
        ImageView circle ,light;
        TextView title ,weight;
        public MyViewHolder(View view){
            circle = (ImageView) view.findViewById(R.id.item_library_next_ci);
            light = (ImageView) view.findViewById(R.id.item_library_next_iv);
            title = (TextView) view.findViewById(R.id.item_library_next_tv);
            weight = (TextView) view.findViewById(R.id.item_library_next_textview);
        }
    }

}
