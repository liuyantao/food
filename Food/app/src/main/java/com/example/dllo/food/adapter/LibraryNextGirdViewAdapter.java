package com.example.dllo.food.adapter;

import android.content.Context;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dllo.food.R;
import com.example.dllo.food.base.BaseHolder;
import com.example.dllo.food.bean.LibraryNutritionBean;
import com.example.dllo.food.util.OnRecycleViewItemClick;

import java.util.List;

/**
 * ✎﹏﹏﹏.₯㎕*﹏﹏﹏
 *
 *
 * 　　　　 ﹏﹏﹏♥♥刘延涛✍♥♥﹏﹏
 */
public class LibraryNextGirdViewAdapter extends BaseAdapter {
    private Context mContext;
    private List<LibraryNutritionBean.TypesBean> datas;
    private OnRecycleViewItemClick mOnRecycleViewItemClick;


    public LibraryNextGirdViewAdapter(Context context) {
        mContext = context;
    }

    public void setDatas(List<LibraryNutritionBean.TypesBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return datas != null ? datas.size():0;
    }

    @Override
    public Object getItem(int i) {
        return datas.size() > 0 && datas != null ? datas .get(i):0;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        MyViewHolder myViewHolder = null;
        if (view == null){
            view = LayoutInflater.from(mContext).inflate(R.layout.item_library_next_girdview,viewGroup,false);
            myViewHolder = new MyViewHolder(view);
            view.setTag(myViewHolder);
        }else {
            myViewHolder = (MyViewHolder) view.getTag();
        }

        myViewHolder.textView.setText(datas.get(i).getName());

        if (null!= mOnRecycleViewItemClick){
            myViewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mOnRecycleViewItemClick.Onclick(i);
                }
            });
        }
        return null;
    }

    public void setOnRecycleViewItemClick(OnRecycleViewItemClick onRecycleViewItemClick) {
        mOnRecycleViewItemClick = onRecycleViewItemClick;
    }

    class MyViewHolder {
        TextView textView;
        LinearLayout linearLayout;

        public MyViewHolder(View view) {
            textView = (TextView) view.findViewById(R.id.item_library_next_girdview_tv);
            linearLayout = (LinearLayout) view.findViewById(R.id.item_library_next_girdview_ll);
        }
    }
}

