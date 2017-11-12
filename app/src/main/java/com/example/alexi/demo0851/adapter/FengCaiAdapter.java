package com.example.alexi.demo0851.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.alexi.demo0851.R;
import com.example.alexi.demo0851.model.FengCaiSearch;
import com.example.alexi.demo0851.model.ZanzhuSearch;
import com.example.alexi.demo0851.model.article;

import java.util.List;

/**
 * Created by alexi on 17-11-7.
 */

public class FengCaiAdapter extends BaseQuickAdapter<FengCaiSearch, BaseViewHolder> {
    private static View rootView;
    public FengCaiAdapter(@LayoutRes int layoutResId, @Nullable List<FengCaiSearch> data,View rootView) {
        super(layoutResId, data);
        FengCaiAdapter.rootView =rootView;
    }

    @Override
    protected void convert(BaseViewHolder helper, FengCaiSearch item) {
        //可链式调用赋值
        helper.setText(R.id.tv_title_zz, item.getFc_name())
                .setText(R.id.tv_time_zz, item.getFc_date().getDate().toString())
                .setText(R.id.tv_place_zz, item.getFc_location());
        Glide.with(rootView)
                .load(item.getBanner().getUrl())
                .into((ImageView) helper.getView(R.id.iv_img));
    }
}
