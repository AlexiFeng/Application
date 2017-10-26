package com.example.alexi.demo0851;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.alexi.demo0851.adapter.QuickAdapter;
import com.example.alexi.demo0851.model.article;

import java.util.ArrayList;


import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

public class _zanzhu extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    public ArrayList<String> strings= new ArrayList();
    static public ArrayList<article> articleTotal = new ArrayList();
    static int totalSize;
    static int nowSize=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showArticle();
        setContentView(R.layout.activity_zanzhu);
        mRecyclerView = (RecyclerView) findViewById(R.id.rlv);


        //创建数据
        ArrayList<String> title= new ArrayList<>();

        for (article t : articleTotal)
            strings.add(t.getTitle());
        //创建数据适配器
        QuickAdapter myAdapter = new QuickAdapter(R.layout.view_rv_item,  strings);

        //设置布局管理者
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(myAdapter);
        //设置动画
        myAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        myAdapter.isFirstOnly(false);
        Toast.makeText(_zanzhu.this, "::"+strings.size(), Toast.LENGTH_SHORT).show();

        myAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                
                Toast.makeText(_zanzhu.this, "itemclick"+position, Toast.LENGTH_SHORT).show();
            }
        });

        myAdapter.setOnItemLongClickListener(new BaseQuickAdapter.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(_zanzhu.this, "setOnItemLongClickListener", Toast.LENGTH_SHORT).show();

                return false;
            }
        });
    }
    public void showArticle(){
        BmobQuery<article> query = new BmobQuery<article>();
        query.findObjects(new FindListener<article>() {
            @Override
            public void done(List<article> object, BmobException e) {
                if(e==null){
                    totalSize=object.size();
                    if(nowSize!=totalSize){
                        nowSize+=object.size();
                        for (article gameScore : object)
                            articleTotal.add(gameScore);
                        Intent intent = getIntent();
                        finish();
                        startActivity(intent);
                    }
                    else
                        Toast.makeText(_zanzhu.this,"已全部加载",Toast.LENGTH_SHORT).show();
                }else{
                    Log.i("bmob","失败："+e.getMessage()+","+e.getErrorCode());
                }

            }
        });

    }

}