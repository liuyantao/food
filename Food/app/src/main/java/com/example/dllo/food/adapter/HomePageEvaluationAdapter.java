package com.example.dllo.food.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.dllo.food.R;
import com.example.dllo.food.bean.HomePageEvaluationBean;
import com.example.dllo.food.base.BaseHolder;
import com.example.dllo.food.util.OnRecycleViewItemClick;


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
    private OnRecycleViewItemClick onRecycleViewItemClick;
    public static final int REC = 1;
    public static final int SEND = 2;


    public void setOnRecycleViewItemClick(OnRecycleViewItemClick onRecycleViewItemClick) {
        this.onRecycleViewItemClick = onRecycleViewItemClick;
    }

    public HomePageEvaluationAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<HomePageEvaluationBean.FeedsBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public BaseHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        return BaseHolder.createViewHolder(context, parent, R.layout.item_homepage_evaluation);

    }

    @Override
    public void onBindViewHolder(BaseHolder holder, final int position) {
//        Glide.with(context).load(datas.get(position).getBackground()).into(holder.homepageIEvaluationIv);
//        holder.homepageEvaluatAionuthor.setText(datas.get(position).getSource());
//        holder.homepageEvaluationArticle.setText(datas.get(position).getTitle());
//        holder.homepageEvaluationRead.setText(datas.get(position).getTail());
        holder.setImage(R.id.homepage_evaluation_iv,datas.get(position).getBackground());
        holder.setText(R.id.homepage_evaluation_author,datas.get(position).getSource());
        holder.setText(R.id.homepage_evaluation_article,datas.get(position).getTitle());
        holder.setText(R.id.homepage_evaluation_read,datas.get(position).getTail());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onRecycleViewItemClick.Onclick(position);
            }
        });

        holder.itemView.setTag(datas);
    }



    @Override
    public int getItemCount() {
        return null != datas ? datas.size() : 0;
    }

//    @Override
//    public void onClick(View view) {
//       if (onRecycleViewItemClick != null){
//
//       }
//    }

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
