package com.example.dllo.food.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.dllo.food.R;
import com.example.dllo.food.activity.RegisterActivity;
import com.example.dllo.food.activity.SetActivity;
import com.example.dllo.food.base.BaseFragment;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformDb;

/**
 * ✎﹏﹏﹏.₯㎕*﹏﹏﹏
 * 　　忍把浮名，
 * 　　　　换了浅斟低唱。
 * 　　　　 ﹏﹏﹏♥♥刘延涛✍♥♥﹏﹏
 */
public class MyFragment extends BaseFragment implements View.OnClickListener {

    private Button button;
    private ImageButton imageButton;
    private RelativeLayout relativeLayout ,relativeLayout_collect ,
            relativeLayout_uploading ,relativeLayout_indent;
    private ImageView mImageView;

    @Override
    public int setLayout() {
        return R.layout.fragment_my;
    }

    @Override
    public void initView(View view) {
        mImageView = (ImageView) view.findViewById(R.id.imageView);


        button = (Button) view.findViewById(R.id.fragment_my_button);
        relativeLayout = (RelativeLayout) view.findViewById(R.id.fragment_my_RelativeLayout);
        relativeLayout_collect = (RelativeLayout) view.findViewById(R.id.fragment_my_RelativeLayout_collect);
        relativeLayout_uploading = (RelativeLayout) view.findViewById(R.id.fragment_my_RelativeLayout_uploading);

        relativeLayout_indent = (RelativeLayout) view.findViewById(R.id.fragment_my_RelativeLayout_indent);
        relativeLayout.setOnClickListener(this);
        relativeLayout_collect.setOnClickListener(this);
        relativeLayout_uploading.setOnClickListener(this);
        relativeLayout_indent.setOnClickListener(this);

        button.setOnClickListener(this);
        imageButton = (ImageButton) view.findViewById(R.id.fragment_my_imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SetActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getActivity(),RegisterActivity.class);
        startActivity(intent);
    }
}
