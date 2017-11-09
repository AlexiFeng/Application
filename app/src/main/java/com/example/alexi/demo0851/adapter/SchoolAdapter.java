package com.example.alexi.demo0851.adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.alexi.demo0851.R;
import com.example.alexi.demo0851.model.School;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import cn.bmob.v3.datatype.BmobFile;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.DownloadFileListener;

/**
 * Created by alexi on 17-11-8.
 */

public class SchoolAdapter extends BaseQuickAdapter<School, BaseViewHolder> {
    private static View rootView;
    public SchoolAdapter(@LayoutRes int layoutResId, @Nullable List<School> data,View rootView) {
        super(layoutResId, data);
        SchoolAdapter.rootView =rootView;
    }

    @Override
    protected void convert(BaseViewHolder helper, School item) {
        //可链式调用赋值
        helper.setText(R.id.tv_title_zz, "公司名称:"+item.getName())
                .setText(R.id.tv_time_zz, "地址:"+item.getPlace());
        Glide.with(rootView)
              .load(item.getBanner().getUrl())
              .into((ImageView) helper.getView(R.id.iv_img));

    }

}