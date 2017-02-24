package com.example.dllo.food.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.dllo.food.R;
import com.example.dllo.food.bean.HomePageKnowledgeBean;
import com.example.dllo.food.base.BaseHolder;
import com.example.dllo.food.util.OnRecycleViewItemClick;

import java.util.List;

/**
 * ✎﹏﹏﹏.₯㎕*﹏﹏﹏
 * 　　忍把浮名，
 * 　　　　换了浅斟低唱。
 * 　　　　 ﹏﹏﹏♥♥刘延涛✍♥♥﹏﹏
 */
public class HomePageKnowledgeAdapter extends RecyclerView.Adapter<BaseHolder>{
    private Context context;
    private List<HomePageKnowledgeBean.FeedsBean> datas;
    private OnRecycleViewItemClick  mOnRecycleViewItemClick;

    public void setOnRecycleViewItemClick(OnRecycleViewItemClick onRecycleViewItemClick) {
        mOnRecycleViewItemClick = onRecycleViewItemClick;
    }

    public HomePageKnowledgeAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<HomePageKnowledgeBean.FeedsBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public BaseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return BaseHolder.createViewHolder(context, parent, R.layout.item_homepage_knowledge);
    }

    @Override
    public void onBindViewHolder(final BaseHolder holder, final int position) {
        //用holder把解析次下来的数据放在对应的位置
        holder.setText(R.id.homepage_knowledge_item_article,datas.get(position).getTitle());
        holder.setText(R.id.homepage_knowledge_item_author,datas.get(position).getSource());
        holder.setText(R.id.homepage_knowledge_item_from,datas.get(position).getTail());
        holder.setImage(R.id.homepage_knowledge_item_eye,datas.get(position).getImages().get(0));
        //添加监听事件
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnRecycleViewItemClick.Onclick(position);
            }
        });
        holder.itemView.setTag(datas);
    }

    @Override
    public int getItemCount() {
        return datas !=null ? datas.size():0;
    }
}
