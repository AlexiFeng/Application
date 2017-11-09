package com.example.alexi.demo0851.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.alexi.demo0851.R;
import com.example.alexi.demo0851.model.ZanzhuSearch;
import com.example.alexi.demo0851.model.club;

import java.util.List;

/**
 * Created by alexi on 17-11-7.
 */

public class ClubAdapter extends BaseQuickAdapter<club, BaseViewHolder> {

    public ClubAdapter(@LayoutRes int layoutResId, @Nullable List<club> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, club item) {
        //可链式调用赋值
        helper.setText(R.id.tv_title_zz, item.getClub_name())
                .setText(R.id.tv_time_zz, "人数:"+item.getClub_size())
                .setImageResource(R.id.iv_img, R.mipmap.ic_launcher);

    }
}
