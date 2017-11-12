package com.example.alexi.demo0851.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.alexi.demo0851.R;
import com.example.alexi.demo0851.model.Post;
import com.example.alexi.demo0851.model.club;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexi on 17-11-8.
 */

public class YiHuBaiYingAdapter extends BaseQuickAdapter<Post, BaseViewHolder> {
    private static View rootView;
    public YiHuBaiYingAdapter(@LayoutRes int layoutResId, @Nullable List<Post> data,View rootView) {
        super(layoutResId, data);
        YiHuBaiYingAdapter.rootView =rootView;
    }

    @Override
    protected void convert(BaseViewHolder helper, Post item) {
        //可链式调用赋值
        helper.setText(R.id.tv_title_zz, item.getTitle())
                .setText(R.id.tv_time_zz,"Alexi.F")
                .setText(R.id.tv_place_zz,item.getSummary())
                .setImageResource(R.id.imageView2,R.drawable.author)
                .setImageResource(R.id.imageView4,R.drawable.say);
        Glide.with(rootView)
                .load("https://bmob-cdn-15019.b0.upaiyun.com/2017/11/10/51213eca4028951a80578e806dac0af9.jpeg")
                .into((ImageView) helper.getView(R.id.iv_img));

    }
}
