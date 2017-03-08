package com.example.dllo.food.adapter.homeadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.food.R;
import com.example.dllo.food.base.BaseHolder;
import com.example.dllo.food.bean.CateGoriesBean;
import com.example.dllo.food.util.LibraryRecycleViewItemClick;
import com.example.dllo.food.util.OnRecycleViewItemClick;

import java.util.List;

/**
 * ✎﹏﹏﹏.₯㎕*﹏﹏﹏
 * 　　忍把浮名，
 * 　　　　换了浅斟低唱。
 * 　　　　 ﹏﹏﹏♥♥刘延涛✍♥♥﹏﹏
 */
public class LibraryAdapter extends RecyclerView.Adapter<BaseHolder>{
    private Context context;
    private List<CateGoriesBean.GroupBean.CategoriesBean> datas;
    private LibraryRecycleViewItemClick mOnRecycleViewItemClick;

    public void setOnRecycleViewItemClick(LibraryRecycleViewItemClick onRecycleViewItemClick) {
        mOnRecycleViewItemClick = onRecycleViewItemClick;
        notifyDataSetChanged();
    }

    public LibraryAdapter(Context context) {

        this.context = context;
    }

    public void setDatas(List<CateGoriesBean.GroupBean.CategoriesBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public BaseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return BaseHolder.createViewHolder(context,parent,R.layout.item_library);
    }

    @Override
    public void onBindViewHolder(BaseHolder holder, final int position) {
        final String title = datas.get(position).getName();
     holder.setImage(R.id.library_fragment_IV,datas.get(position).getImage_url());
        holder.setText(R.id.item_showtv,datas.get(position).getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnRecycleViewItemClick.onClick(position,title);
            }
        });
        holder.itemView.setTag(datas);
    }

    @Override
    public int getItemCount() {
        return datas != null ? datas.size() : 0;
    }

//    @Override
//    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View itemView = LayoutInflater.from(context).inflate(R.layout.item_library, parent, false);
//        // 创建内部类
//        MyViewHolder holder = new MyViewHolder(itemView);
//        return holder;
//    }
//
//    @Override
//    public void onBindViewHolder(MyViewHolder holder, int position) {
//        holder.textView.setText(datas.get(position).getName());
//    }
//
//    @Override
//    public int getItemCount() {
//        return datas != null ? datas.size() : 0;
//    }
//
//    public class MyViewHolder extends RecyclerView.ViewHolder {
//        private ImageView imageView;
//        private TextView textView;
//        public MyViewHolder(View itemView) {
//            super(itemView);
//            imageView = (ImageView) itemView.findViewById(R.id.library_fragment_IV);
//            textView = (TextView) itemView.findViewById(R.id.item_showtv);
//        }
//    }
}
