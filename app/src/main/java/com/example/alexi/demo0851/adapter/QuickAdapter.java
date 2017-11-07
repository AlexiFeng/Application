package com.example.alexi.demo0851.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.alexi.demo0851.R;

import java.util.ArrayList;

/**
 * Created by alexi on 17-10-24.
 */

public class QuickAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public QuickAdapter(ArrayList<String> test) {
        super(R.layout.item_rv_zanzhu, test);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, String item) {
        viewHolder.setText(R.id.tv_title_zz,"nihao");
    }
}
