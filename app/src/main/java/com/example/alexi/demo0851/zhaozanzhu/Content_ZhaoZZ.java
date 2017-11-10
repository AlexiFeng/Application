package com.example.alexi.demo0851.zhaozanzhu;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.alexi.demo0851.R;
import com.example.alexi.demo0851.adapter.SchoolAdapter;
import com.example.alexi.demo0851.model.Course;
import com.example.alexi.demo0851.model.FengCaiSearch;
import com.example.alexi.demo0851.model.School;
import com.example.alexi.demo0851.model.ZanzhuSJSearch;
import com.example.alexi.demo0851.model.ZanzhuSearch;
import com.example.alexi.demo0851.model.club;

import org.w3c.dom.Text;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

public class Content_ZhaoZZ extends AppCompatActivity {
    private static School tempSchool;
    private static Context test;
    private static TableLayout tempLayout;
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
        else if (kind.equals("course")){
            final School instance = (School) bundle.getSerializable("instance");
            tempSchool=instance;
            tempLayout=(TableLayout)findViewById(R.id.testTableLayout);
            //tempLayout.removeAllViews();
            school(instance);
        }
        else if (kind.equals("zanzhu_sj")){
            final ZanzhuSJSearch instance = (ZanzhuSJSearch) bundle.getSerializable("instance");
            tempLayout=(TableLayout)findViewById(R.id.testTableLayout);
            zhaoZanZhuSJ(instance);
        }
        test= getApplicationContext();

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
    private void zhaoZanZhuSJ(final ZanzhuSJSearch instance) {
        TextView funcJianjie=(TextView)findViewById(R.id.textView16);
        funcJianjie.setText("活动形式:");
        TextView funcCourse=(TextView)findViewById(R.id.textView18);
        funcCourse.setText("我们能提供:");
        TextView funcDetails=(TextView)findViewById(R.id.textView12);
        funcDetails.setVisibility(View.VISIBLE);
        funcDetails.setText("其他细节:");

        TextView con=(TextView)findViewById(R.id.name_zz);
        con.setText(instance.getName());

        con=(TextView)findViewById(R.id.time_zz);
        con.setText(instance.getTime());
        con=(TextView)findViewById(R.id.need_zz);
        con.setText(instance.getRequire());
        con=(TextView)findViewById(R.id.provide_zz);
        con.setText(instance.getProvide());
        con=(TextView)findViewById(R.id.textView13);
        con.setVisibility(View.VISIBLE);
        con.setText(instance.getDetails());
        con=(TextView)findViewById(R.id.textView14);
        con.setVisibility(View.VISIBLE);
        con.setText(instance.getIntroduction());
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "联系我", Snackbar.LENGTH_LONG)
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
        con.setText(instance.getClub_manager().getNick());
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
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setVisibility(View.GONE);
        TextView funcJianjie=(TextView)findViewById(R.id.textView16);
        funcJianjie.setText("地点:");
        TextView funcContent=(TextView)findViewById(R.id.textView18);
        funcContent.setText("活动详情:");
        TextView con=(TextView)findViewById(R.id.name_zz);
        con.setText(instance.getFc_name());

        con=(TextView)findViewById(R.id.time_zz);
        con.setText(instance.getFc_date().getDate().toString());
        con=(TextView)findViewById(R.id.need_zz);
        con.setText(instance.getFc_location());
        con=(TextView)findViewById(R.id.provide_zz);
        con.setText(instance.getFc_content());

    }
    private void school(final School instance) {

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "联系我:"+instance.getTel(), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        doSearch_Course(getWindow().getDecorView());
    }
    public static void doSearch_Course(final View rootView){

        BmobQuery<Course> query = new BmobQuery<>();
        query.addWhereEqualTo("School",tempSchool.getName());
        query.findObjects(new FindListener<Course>() {
            @Override
            public void done(final List<Course> object, BmobException e) {
                if(e!=null) {
                    Log.e("注意",e.getMessage());
                    Snackbar.make(rootView,""+e.getMessage(),Snackbar.LENGTH_LONG).show();
                }
                addItem_Course(object);
            }

            private void addItem_Course(List<Course> object) {
                TextView schoolName=(TextView)rootView.findViewById(R.id.name_zz);
                schoolName.setText(tempSchool.getName());
                TextView schoolPlace=(TextView)rootView.findViewById(R.id.time_zz);
                schoolPlace.setText(tempSchool.getPlace());
                TextView funcJianjie=(TextView)rootView.findViewById(R.id.textView16);
                funcJianjie.setText("机构简介:");
                TextView schoolInfo=(TextView)rootView.findViewById(R.id.need_zz);
                schoolInfo.setText(tempSchool.getInformation());
                TextView funcCourse=(TextView)rootView.findViewById(R.id.textView18);
                funcCourse.setText("课程列表");
                TextView funcDrop=(TextView)rootView.findViewById(R.id.provide_zz);
                funcDrop.setVisibility(View.GONE);

                TableRow tableTitle = new TableRow(test);
                TextView textTitle= new TextView(test);
                TextView textTitle2 = new TextView(test);
                TextView textTitle3 = new TextView(test);
                textTitle.setText("课程名称");
                textTitle2.setText("时间");
                textTitle2.setGravity(Gravity.CENTER);
                textTitle3.setText("    价格");
                tableTitle.addView (textTitle);
                tableTitle.addView(textTitle2);
                tableTitle.addView(textTitle3);
                tempLayout.addView(tableTitle) ;
                for(Course temp:object){
                    TableRow tableRow = new TableRow(test);
                    TextView textView = new TextView(test);
                    TextView textView2 = new TextView(test);
                    TextView textView3 = new TextView(test);
                    textView.setText(temp.getName());
                       textView2.setText(temp.getTime());
                       textView3.setText("    "+temp.getPrice());
                    textView3.setGravity(Gravity.RIGHT);
                    tableRow.addView(textView);
                       tableRow.addView(textView2);
                       tableRow.addView(textView3);
                       tempLayout.addView(tableRow);
                   }
            }

        });
    }
}
