package com.example.dllo.food.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.dllo.food.R;
import com.example.dllo.food.base.BaseHolder;
import com.example.dllo.food.bean.HomePageFoodBean;

import java.util.List;

/**
 * ✎﹏﹏﹏.₯㎕*﹏﹏﹏
 * 　　忍把浮名，
 * 　　　　换了浅斟低唱。
 * 　　　　 ﹏﹏﹏♥♥刘延涛✍♥♥﹏﹏
 */
public class HomePageFoodAdapter extends RecyclerView.Adapter<BaseHolder> {
    private  Context context;
    private List<HomePageFoodBean.FeedsBean> datas;

    public HomePageFoodAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<HomePageFoodBean.FeedsBean> datas) {

        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public BaseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return BaseHolder.createViewHolder(context,parent, R.layout.item_homepage_food);
    }

    @Override
    public void onBindViewHolder(BaseHolder holder, int position) {
      holder.setText(R.id.homepage_food_item_article,datas.get(position).getTitle());
        holder.setText(R.id.homepage_food_item_author,datas.get(position).getSource());
        holder.setText(R.id.homepage_food_item_from,datas.get(position).getTail());
        holder.setImage(R.id.homepage_food_item_eye,datas.get(position).getImages().get(0));

    }

    @Override
    public int getItemCount() {
        return datas != null ? datas.size() : 0;
    }
}
