package com.example.alexi.demo0851.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.alexi.demo0851.R;
import com.example.alexi.demo0851.model.ZanzhuSearch;

import java.util.Date;
import java.util.List;

import cn.bmob.v3.datatype.BmobDate;

/**
 * Created by alexi on 17-10-26.
 */

public class ZhaoZanZhuAdapter extends BaseQuickAdapter<ZanzhuSearch, BaseViewHolder> {

    public ZhaoZanZhuAdapter(@LayoutRes int layoutResId, @Nullable List<ZanzhuSearch> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ZanzhuSearch item) {
        //可链式调用赋值
        helper.setText(R.id.tv_title, item.getAc_name())
                .setText(R.id.tv_content, "时间:"+item.getAc_date().getDate().toString())
                .setText(R.id.tv_content, "时间:"+item.getAc_date().getDate().toString())
                .setImageResource(R.id.iv_img, R.mipmap.ic_launcher);
        
    }
}