package com.example.dllo.food.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.dllo.food.R;
import com.example.dllo.food.base.BaseActivity;
import com.example.dllo.food.bean.LibraryNextBean;
import com.example.dllo.food.bean.LibraryNutritionBean;

import java.util.List;

public class LibraryNextActivity extends BaseActivity {

private ImageButton mImageButton;
   private RecyclerView mRecyclerView;
    private List<LibraryNextBean.FoodsBean> data;
    private LibraryNutritionBean mBean;
    private LibraryNextBean mNextBean;
    private PopupWindow mPopupWindow;
    private TextView mTextView;
    @Override
    protected int bindLayout() {
        return R.layout.activity_library_next;
    }

    @Override
    protected void initView() {

    mImageButton = (ImageButton) findViewById(R.id.activity_library_next_ib);
    mImageButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            finish();
        }
    });
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void bindEvent() {

    }
}
