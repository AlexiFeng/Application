package com.example.alexi.demo0851.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
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
    private static View rootView;
    public ZhaoZanZhuAdapter(@LayoutRes int layoutResId, @Nullable List<ZanzhuSearch> data,View rootView) {
        super(layoutResId, data);
        ZhaoZanZhuAdapter.rootView =rootView;
    }

    @Override
    protected void convert(BaseViewHolder helper, ZanzhuSearch item) {
        //可链式调用赋值
        helper.setText(R.id.tv_title_zz, item.getAc_name())
                .setText(R.id.tv_time_zz, "时间:"+item.getAc_date().getDate().toString());
        Glide.with(rootView)
                .load(item.getBanner().getUrl())
                .into((ImageView) helper.getView(R.id.iv_img));
        
    }
}