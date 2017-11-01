package com.example.alexi.demo0851.zhaozanzhu;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.alexi.demo0851.R;
import com.example.alexi.demo0851.model.ZanzhuSearch;

public class Content_ZhaoZZ extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content__zhao_zz);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "联系我", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("bundle");
        ZanzhuSearch instance = (ZanzhuSearch) bundle.getSerializable("instance");
        TextView con=(TextView)findViewById(R.id.name_zz);
        con.setText(instance.getAc_name());

        con=(TextView)findViewById(R.id.time_zz);
        con.setText(instance.getAc_date().getDate().toString());
        con=(TextView)findViewById(R.id.need_zz);
        con.setText(instance.getAc_need());
        con=(TextView)findViewById(R.id.provide_zz);
        con.setText(instance.getAc_provide());

    }
}
