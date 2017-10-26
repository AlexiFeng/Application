package com.example.alexi.demo0851.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.alexi.demo0851.R;

import java.util.ArrayList;

/**
 * Created by alexi on 17-10-24.
 */

public class QuickAdapter extends BaseQuickAdapter<String, BaseViewHolder> {


    public QuickAdapter(int item_recycler, ArrayList<String> strings) {
        super(item_recycler, strings);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tv_item, item);
        helper.setText(R.id.tv_test,"nihao");
    }

}

