package com.example.alexi.demo0851.zhaozanzhu;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.alexi.demo0851.LoginActivity;
import com.example.alexi.demo0851.R;
import com.example.alexi.demo0851.model.ZanzhuSearch;

import org.w3c.dom.Text;

import java.util.List;

public class Zz_content extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zz_content);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Bundle bundle = getIntent().getBundleExtra("bundle");
        ZanzhuSearch instance = (ZanzhuSearch)bundle.getSerializable("momoda");
        TextView tv = (TextView) findViewById(R.id.zz_content_text);
        tv.setText(instance.getAc_name());

    }

}
