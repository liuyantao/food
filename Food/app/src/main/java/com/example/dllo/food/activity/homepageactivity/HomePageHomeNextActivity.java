package com.example.dllo.food.activity.homepageactivity;

import android.content.Intent;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.ImageViewTargetFactory;
import com.example.dllo.food.R;
import com.example.dllo.food.base.BaseActivity;

import java.util.ArrayList;

/**
 * ✎﹏﹏﹏.₯㎕*﹏﹏﹏
 * <p>
 * <p>
 * 　　　　 ﹏﹏﹏♥♥刘延涛✍♥♥﹏﹏
 */
public class HomePageHomeNextActivity extends BaseActivity {
    private Button mButton;


    private ImageView corcleimageView, photoimageView;
    private TextView nameTextView, numberTextView;

    @Override
    protected int bindLayout() {
        return R.layout.activity_homepage_home_next;
    }

    @Override
    protected void initView() {
        corcleimageView = (ImageView) findViewById(R.id.activity_homepage_home_next_ci);
        photoimageView = (ImageView) findViewById(R.id.activity_homepage_home_next_iv);
        nameTextView = (TextView) findViewById(R.id.activity_homepage_home_next_tv);
        numberTextView = (TextView) findViewById(R.id.activity_home_first_number_tv);

        mButton = (Button) findViewById(R.id.activity_homepage_home_next);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        ArrayList<String> arrayList = intent.getStringArrayListExtra("NextActivity");
        Glide.with(this).load(arrayList.get(0)).into(corcleimageView);
       nameTextView.setText(arrayList.get(1) + "");
        Glide.with(this).load(arrayList.get(2)).into(photoimageView);
        numberTextView.setText(arrayList.get(3) + "");


    }

    @Override
    protected void bindEvent() {

    }
}
