package com.example.alexi.demo0851.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

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

    public YiHuBaiYingAdapter(@LayoutRes int layoutResId, @Nullable List<Post> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Post item) {
        //可链式调用赋值
        helper.setText(R.id.tv_title_zz, item.getTitle())
                .setText(R.id.tv_time_zz, item.getSummary())
                .setGone(R.id.iv_img, false);
    }
}
