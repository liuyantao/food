package com.example.dllo.food.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.example.dllo.food.R;
import com.example.dllo.food.base.BaseHolder;
import com.example.dllo.food.bean.LibraryNextBean;

import java.util.List;

/**
 * ✎﹏﹏﹏.₯㎕*﹏﹏﹏
 *
 *
 * 　　　　 ﹏﹏﹏♥♥刘延涛✍♥♥﹏﹏
 */
public class LibraryNextAdapter extends RecyclerView.Adapter<BaseHolder> {
  private   Context mContext;
    private  List<LibraryNextBean.FoodsBean> datas;

    public LibraryNextAdapter(Context context) {
        mContext = context;
    }

    public void setDatas(List<LibraryNextBean.FoodsBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public BaseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return BaseHolder.createViewHolder(mContext,parent, R.layout.item_library_next);
    }

    @Override
    public void onBindViewHolder(BaseHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return datas != null ? datas.size() : 0;
    }
}
