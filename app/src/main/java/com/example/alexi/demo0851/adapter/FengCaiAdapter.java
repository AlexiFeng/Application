package com.example.alexi.demo0851.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

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
    public FengCaiAdapter(@LayoutRes int layoutResId, @Nullable List<FengCaiSearch> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, FengCaiSearch item) {
        //可链式调用赋值
        helper.setText(R.id.tv_title_zz, item.getFc_name())
                .setText(R.id.tv_time_zz, "时间:"+item.getFc_club().getClub_name())
                .setImageResource(R.id.iv_img, R.mipmap.ic_launcher);

    }
}
