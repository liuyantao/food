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


import java.util.ArrayList;
import java.util.List;

/**
 * ✎﹏﹏﹏.₯㎕*﹏﹏﹏
 * 　　忍把浮名，
 * 　　　　换了浅斟低唱。
 * 　　　　 ﹏﹏﹏♥♥刘延涛✍♥♥﹏﹏
 */
public class HomePageEvaluationAdapter extends RecyclerView.Adapter<HomePageEvaluationAdapter.HomePageEvaluationViewHoder> {
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
    public HomePageEvaluationViewHoder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.homepage_evaluation_fragment,parent,false);
        HomePageEvaluationViewHoder viewHoder = new HomePageEvaluationViewHoder(view);
        return viewHoder;
    }

    @Override
    public void onBindViewHolder(HomePageEvaluationViewHoder holder, int position) {

        Glide.with(context).load(datas.get(position).getBackground()).into(holder.homepageIEvaluationIv);
        holder.homepageEvaluatAionuthor.setText(datas.get(position).getSource());
        holder.homepageEvaluationArticle.setText(datas.get(position).getTitle());
        holder.homepageEvaluationRead.setText(datas.get(position).getTail());
    }

    @Override
    public int getItemCount() {
        return null != datas ? datas.size() : 0;
    }

    //自定义内部类
    public class HomePageEvaluationViewHoder extends RecyclerView.ViewHolder {
        ImageView homepageIEvaluationIv;
        TextView homepageEvaluatAionuthor;
        TextView homepageEvaluationArticle;
        TextView homepageEvaluationRead;

        public HomePageEvaluationViewHoder(View itemView) {
            super(itemView);
            homepageIEvaluationIv = (ImageView) itemView.findViewById(R.id.homepage_evaluation_iv);
            homepageEvaluatAionuthor = (TextView) itemView.findViewById(R.id.homepage_evaluation_article);
            homepageEvaluationArticle = (TextView) itemView.findViewById(R.id.homepage_evaluation_author);
            homepageEvaluationRead = (TextView) itemView.findViewById(R.id.homepage_evaluation_read);
        }
    }

}
