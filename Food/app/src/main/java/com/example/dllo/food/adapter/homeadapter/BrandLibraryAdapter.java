package com.example.dllo.food.adapter.homeadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.example.dllo.food.R;
import com.example.dllo.food.base.BaseHolder;
import com.example.dllo.food.bean.CateGoriesBean;
import com.example.dllo.food.util.LibraryRecycleViewItemClick;

import java.util.List;

/**
 * ✎﹏﹏﹏.₯㎕*﹏﹏﹏
 * 　　忍把浮名，
 * 　　　　换了浅斟低唱。
 * 　　　　 ﹏﹏﹏♥♥刘延涛✍♥♥﹏﹏
 */
public class BrandLibraryAdapter extends RecyclerView.Adapter<BaseHolder>{
   private Context context;
    private LibraryRecycleViewItemClick mOnRecycleViewItemClick;
    private List<CateGoriesBean.GroupBean.CategoriesBean>  data;

    public void setDatas(List<CateGoriesBean.GroupBean.CategoriesBean> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public void setOnRecycleViewItemClick(LibraryRecycleViewItemClick onRecycleViewItemClick) {
        mOnRecycleViewItemClick = onRecycleViewItemClick;
        notifyDataSetChanged();
    }

    public BrandLibraryAdapter(Context context) {
        this.context = context;
    }

    @Override
    public BaseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return BaseHolder.createViewHolder(context,parent,R.layout.item_library);
    }

    @Override
    public void onBindViewHolder(BaseHolder holder, final int position) {
      holder.setImage(R.id.library_fragment_IV,data.get(position).getImage_url());
        final String title = data.get(position).getName();
        holder.setText(R.id.item_showtv,title);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnRecycleViewItemClick.onClick(position, title);

                Log.d("BrandLibraryAdapter", "data.get(position).getId():" + data.get(position).getId());
            }
        });
        holder.itemView.setTag(data);
    }

    @Override
    public int getItemCount() {
        return data != null ? data.size() : 0;
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
//
//    }
//
//   // 定义item有几个的方法
//    @Override
//    public int getItemCount() {
//        return datas != null ? datas .size() : 0;
//    }
//
//    public class MyViewHolder extends RecyclerView.ViewHolder {
//        TextView textView;
//        ImageView imageView;
//        public MyViewHolder(View itemView) {
//            super(itemView);
//            imageView = (ImageView) itemView.findViewById(R.id.library_fragment_IV);
//            textView = (TextView) itemView.findViewById(R.id.item_showtv);
//        }
//    }
}
