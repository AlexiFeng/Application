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
import com.example.alexi.demo0851.model.FengCaiSearch;
import com.example.alexi.demo0851.model.School;
import com.example.alexi.demo0851.model.ZanzhuSearch;
import com.example.alexi.demo0851.model.club;

public class Content_ZhaoZZ extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content__zhao_zz);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("bundle");

        final String kind=(String)bundle.getSerializable("kind");
        if(kind.equals("zanzhu")){
            final ZanzhuSearch instance = (ZanzhuSearch) bundle.getSerializable("instance");
            zhaoZanZhu(instance);
        }
        else if(kind.equals("shetuan")){
            final club instance = (club) bundle.getSerializable("instance");
            sheTuan(instance);
        }
        else if (kind.equals("fengcai")){
            final FengCaiSearch instance = (FengCaiSearch ) bundle.getSerializable("instance");
            fengCai(instance);
        }
        else if (kind.equals("School")){
            final School instance = (School) bundle.getSerializable("instance");

        }
    }

    private void zhaoZanZhu(final ZanzhuSearch instance) {

            TextView con=(TextView)findViewById(R.id.name_zz);
            con.setText(instance.getAc_name());

            con=(TextView)findViewById(R.id.time_zz);
            con.setText(instance.getAc_date().getDate().toString());
            con=(TextView)findViewById(R.id.need_zz);
            con.setText(instance.getAc_need());
            con=(TextView)findViewById(R.id.provide_zz);
            con.setText(instance.getAc_provide());
            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view, "联系我"+instance.getAc_club().getClub_name(), Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            });

    }
    private void sheTuan(final club instance) {

        TextView con=(TextView)findViewById(R.id.name_zz);
        con.setText(instance.getClub_name());

        con=(TextView)findViewById(R.id.time_zz);
        con.setText("notime");
        con=(TextView)findViewById(R.id.need_zz);
        //con.setText(instance.getAc_need());
        con=(TextView)findViewById(R.id.provide_zz);
        //con.setText(instance.getAc_provide());
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "联系我"+instance.getClub_manager().getNick(), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }
    private void fengCai(final FengCaiSearch instance) {

        TextView con=(TextView)findViewById(R.id.name_zz);
        con.setText(instance.getFc_name());

        con=(TextView)findViewById(R.id.time_zz);
        con.setText(instance.getFc_date().getDate().toString());
        con=(TextView)findViewById(R.id.need_zz);
        con.setText("no need");
        con=(TextView)findViewById(R.id.provide_zz);
        con.setText("no provide");
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "联系我"+instance.getFc_club().getClub_name(), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }
    private void school(final School instance) {

        TextView con=(TextView)findViewById(R.id.name_zz);
        con.setText(instance.getName());

        con=(TextView)findViewById(R.id.time_zz);
        con.setText(instance.getPlace());
        con=(TextView)findViewById(R.id.need_zz);
        con.setText("no need");
        con=(TextView)findViewById(R.id.provide_zz);
        con.setText("no provide");
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "联系我:"+instance.getTel(), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }
}
