package com.example.alexi.demo0851.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.alexi.demo0851.R;
import com.example.alexi.demo0851.model.ZanzhuSJSearch;
import com.example.alexi.demo0851.model.ZanzhuSearch;

import java.util.List;

/**
 * Created by alexi on 17-11-10.
 */

public class ZanZhuSJAdapter extends BaseQuickAdapter<ZanzhuSJSearch, BaseViewHolder> {
private static View rootView;
public ZanZhuSJAdapter(@LayoutRes int layoutResId, @Nullable List<ZanzhuSJSearch> data,View rootView) {
        super(layoutResId, data);
        ZanZhuSJAdapter.rootView =rootView;
        }

@Override
protected void convert(BaseViewHolder helper, ZanzhuSJSearch item) {
        //可链式调用赋值
        helper.setText(R.id.tv_title_zz, item.getName())
        .setText(R.id.tv_time_zz, "时间:"+item.getTime());
        Glide.with(rootView)
        .load(item.getBanner().getUrl())
        .into((ImageView) helper.getView(R.id.iv_img));

        }
}