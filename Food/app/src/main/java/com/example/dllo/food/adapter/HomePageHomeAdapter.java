package com.example.dllo.food.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.dllo.food.R;
import com.example.dllo.food.base.BaseHolder;
import com.example.dllo.food.bean.HomePageHomeBean;

import java.util.ArrayList;
import java.util.List;

/**
 * ✎﹏﹏﹏.₯㎕*﹏﹏﹏
 * 　　忍把浮名，
 * 　　　　换了浅斟低唱。
 * 　　　　 ﹏﹏﹏♥♥刘延涛✍♥♥﹏﹏
 */
public class HomePageHomeAdapter extends RecyclerView.Adapter<BaseHolder>{
    private Context context;
    private List<HomePageHomeBean.FeedsBean> datas;
    private ArrayList<Integer> heights;

    public HomePageHomeAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<HomePageHomeBean.FeedsBean> datas) {
        this.datas = datas;
//        heights = new ArrayList<Integer>();
//        Random random = new Random();
//        for (int i = 0; i < 10; i++) {
//            heights.add(random.nextInt(10)*50);
//        }

        notifyDataSetChanged();
    }


    @Override
    public BaseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return BaseHolder.createViewHolder(context,parent,R.layout.item_homepage_home);

    }

    @Override
    public void onBindViewHolder(BaseHolder holder, int position) {
//        ViewGroup.LayoutParams params = holder.getView().getLayoutParams();
//        params.height = heights.get(position);
//        holder.getView().setLayoutParams(params);
        holder.setImage(R.id.homepage_home_item_iv ,datas .get(position).getCard_image() );
        holder.setText(R.id.homepage_home_item_title,datas.get(position).getTitle());
        holder.setText(R.id.homepage_home_item_author_tv,datas.get(position).getPublisher());
        holder.setText(R.id.homepage_home_item_amout_tv, String.valueOf(datas.get(position).getLike_ct()));
    }



    @Override
    public int getItemCount() {
        return datas != null ? datas.size() : 0;
    }


}
