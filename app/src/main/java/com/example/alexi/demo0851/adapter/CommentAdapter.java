package com.example.alexi.demo0851.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.alexi.demo0851.R;
import com.example.alexi.demo0851.model.Comment;
import com.example.alexi.demo0851.model.club;

import java.util.List;

/**
 * Created by alexi on 17-11-9.
 */

public class CommentAdapter extends BaseQuickAdapter<Comment, BaseViewHolder> {

    public CommentAdapter(@LayoutRes int layoutResId, @Nullable List<Comment> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Comment item) {
        //可链式调用赋值
        helper.setText(R.id.tv_title_zz, item.getContent())
                .setText(R.id.tv_time_zz, "...:")
                .setImageResource(R.id.iv_img, R.mipmap.ic_launcher);

    }
}