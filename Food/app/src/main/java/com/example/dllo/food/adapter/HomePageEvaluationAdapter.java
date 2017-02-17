package com.example.dllo.food.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dllo.food.R;
import com.example.dllo.food.bean.HomePageEvaluationBean;
import com.example.dllo.food.util.BaseHolder;


import java.util.ArrayList;
import java.util.List;

/**
 * ✎﹏﹏﹏.₯㎕*﹏﹏﹏
 * 　　忍把浮名，
 * 　　　　换了浅斟低唱。
 * 　　　　 ﹏﹏﹏♥♥刘延涛✍♥♥﹏﹏
 */
public class HomePageEvaluationAdapter extends RecyclerView.Adapter<BaseHolder> {
    private Context context;
    private List<HomePageEvaluationBean.FeedsBean> datas;

    public HomePageEvaluationAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<HomePageEvaluationBean.FeedsBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public BaseHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return BaseHolder.createViewHolder(context, parent, R.layout.homepage_evaluation_item);
    }

    @Override
    public void onBindViewHolder(BaseHolder holder, int position) {
//        Glide.with(context).load(datas.get(position).getBackground()).into(holder.homepageIEvaluationIv);
//        holder.homepageEvaluatAionuthor.setText(datas.get(position).getSource());
//        holder.homepageEvaluationArticle.setText(datas.get(position).getTitle());
//        holder.homepageEvaluationRead.setText(datas.get(position).getTail());
        holder.setImage(R.id.homepage_evaluation_iv,datas.get(position).getBackground());
        holder.setText(R.id.homepage_evaluation_author,datas.get(position).getSource());
        holder.setText(R.id.homepage_evaluation_article,datas.get(position).getTitle());
        holder.setText(R.id.homepage_evaluation_read,datas.get(position).getTail());
    }


    
    @Override
    public int getItemCount() {
        return null != datas ? datas.size() : 0;
    }

    //自定义内部类
//    public class HomePageEvaluationViewHoder extends RecyclerView.ViewHolder {
//        ImageView homepageIEvaluationIv;
//        TextView homepageEvaluatAionuthor;
//        TextView homepageEvaluationArticle;
//        TextView homepageEvaluationRead;
//
//        public HomePageEvaluationViewHoder(View itemView) {
//            super(itemView);
//            homepageIEvaluationIv = (ImageView) itemView.findViewById(R.id.homepage_evaluation_iv);
//            homepageEvaluatAionuthor = (TextView) itemView.findViewById(R.id.homepage_evaluation_article);
//            homepageEvaluationArticle = (TextView) itemView.findViewById(R.id.homepage_evaluation_author);
//            homepageEvaluationRead = (TextView) itemView.findViewById(R.id.homepage_evaluation_read);
//        }
//    }

}
