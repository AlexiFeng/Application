package com.example.alexi.demo0851.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.alexi.demo0851.R;
import com.example.alexi.demo0851.model.School;

import java.util.List;

/**
 * Created by alexi on 17-11-8.
 */

public class SchoolAdapter extends BaseQuickAdapter<School, BaseViewHolder> {
    public SchoolAdapter(@LayoutRes int layoutResId, @Nullable List<School> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, School item) {
        //可链式调用赋值
        helper.setText(R.id.tv_title_zz, item.getName())
                .setText(R.id.tv_time_zz, "时间:"+item.getPlace())
                .setImageResource(R.id.iv_img, R.mipmap.ic_launcher);

    }
}