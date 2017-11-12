package com.example.alexi.demo0851.zhaozanzhu;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.alexi.demo0851.R;
import com.example.alexi.demo0851.model.Course;
import com.example.alexi.demo0851.model.FengCaiSearch;
import com.example.alexi.demo0851.model.MyUser;
import com.example.alexi.demo0851.model.PrivateMessage;
import com.example.alexi.demo0851.model.School;
import com.example.alexi.demo0851.model.ZanzhuSJSearch;
import com.example.alexi.demo0851.model.ZanzhuSearch;
import com.example.alexi.demo0851.model.club;

import org.w3c.dom.Text;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;

public class Content1_ZhaoZZ extends AppCompatActivity {
    private static School tempSchool;
    private static Context test;
    private static TableLayout tempLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content1__zhao_zz);
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
            ImageView clearImage =(ImageView)findViewById(R.id.imageView3) ;
            clearImage.setVisibility(View.INVISIBLE);
            clearImage=(ImageView)findViewById(R.id.imageView5);
            clearImage.setVisibility(View.INVISIBLE);
            TextView temp1=(TextView)findViewById(R.id.kindDate);
            temp1.setVisibility(View.GONE);
            temp1=(TextView)findViewById(R.id.club_Name);
            temp1.setVisibility(View.GONE);
            final School instance = (School) bundle.getSerializable("instance");
            tempSchool=instance;
            tempLayout=(TableLayout) findViewById(R.id.tempLayout);
            school(instance);
        }
        else if (kind.equals("zanzhu_sj")){
            final ZanzhuSJSearch instance = (ZanzhuSJSearch) bundle.getSerializable("instance");

            zhaoZanZhuSJ(instance);
        }
        test= getApplicationContext();

    }

    private void zhaoZanZhu(final ZanzhuSearch instance) {

        TextView con=(TextView)findViewById(R.id.name_zz);
        con.setText(instance.getAc_name());

        con=(TextView)findViewById(R.id.time_zz);
        con.setText("时间:"+instance.getAc_date().getDate().toString());
        con=(TextView)findViewById(R.id.need_zz);
        con.setText(instance.getAc_need());
        con=(TextView)findViewById(R.id.provide_zz);
        con.setText(instance.getAc_provide());
        con=(TextView)findViewById(R.id.place_zz);
        con.setText("地点:"+instance.getAc_location());
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });

    }
    private void zhaoZanZhuSJ(final ZanzhuSJSearch instance) {
        TextView temp1=(TextView)findViewById(R.id.kindDate);
        temp1.setVisibility(View.INVISIBLE);
        temp1=(TextView)findViewById(R.id.club_Name);
        temp1.setVisibility(View.INVISIBLE);
        TextView con=(TextView)findViewById(R.id.name_zz);
        con.setText(instance.getName());
        ImageView test =(ImageView)findViewById(R.id.imageView3) ;
        test.setVisibility(View.INVISIBLE);
        test=(ImageView)findViewById(R.id.imageView5);
        test.setVisibility(View.INVISIBLE);

        con=(TextView)findViewById(R.id.time_zz);
        con.setText("有效时间:"+instance.getTime());
        con=(TextView)findViewById(R.id.place_zz);
        con.setText("活动形式:"+instance.getRequire());
        con=(TextView)findViewById(R.id.need_zz);
        con.setText(instance.getProvide());
        con=(TextView)findViewById(R.id.provide_zz);
        con.setText(instance.getDetails());
        con=(TextView)findViewById(R.id.jianjie_Title);
        con.setVisibility(View.VISIBLE);
        con.setText("\n\n简介:");
        con=(TextView)findViewById(R.id.jianjie_ZZ);
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
        TextView club_Name=(TextView)findViewById(R.id.club_Name);
        club_Name.setText("曲艺团");
        TextView kindDate=(TextView)findViewById(R.id.kindDate);
        kindDate.setText("文娱 | 2017-10-25");
        TextView funcJianjie=(TextView)findViewById(R.id.textView16);
        funcJianjie.setVisibility(View.GONE);
        TextView funcContent=(TextView)findViewById(R.id.textView18);
        funcContent.setText("活动详情:");
        TextView con=(TextView)findViewById(R.id.name_zz);
        con.setText(instance.getFc_name());

        con=(TextView)findViewById(R.id.time_zz);
        con.setText("时间:"+instance.getFc_date().getDate().toString());
        con=(TextView)findViewById(R.id.place_zz);
        con.setText("地点:"+instance.getFc_location());
        con=(TextView)findViewById(R.id.need_zz);
        con.setVisibility(View.INVISIBLE);
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
                TextView schoolTel=(TextView)rootView.findViewById(R.id.time_zz);
                schoolTel.setText("联系电话:"+tempSchool.getTel());
                TextView schoolPlace=(TextView)rootView.findViewById(R.id.place_zz);
                schoolPlace.setText("地址:"+tempSchool.getPlace());
                TextView funcJianjie=(TextView)rootView.findViewById(R.id.textView16);
                funcJianjie.setText("机构简介:");
                TextView schoolInfo=(TextView)rootView.findViewById(R.id.need_zz);
                schoolInfo.setText(tempSchool.getInformation());
                TextView funcCourse=(TextView)rootView.findViewById(R.id.textView18);
                funcCourse.setText("课程列表:\n");
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
    private void showDialog() {

        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(this);
        builder.setTitle("向Alexi发私信");
        builder.setMessage("请输入私信内容");
        final EditText tT=new EditText(this);
        builder.setView(tT);
        builder.setNegativeButton("取消", null);
        builder.setPositiveButton("发送",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                PrivateMessage t=new PrivateMessage();
                MyUser nowUser = MyUser.getCurrentUser(MyUser.class);
                t.setFrom(nowUser);
                t.setContent(tT.getText().toString());
                t.setTo(nowUser);
                t.save(new SaveListener<String>() {
                    @Override
                    public void done(String objectId,BmobException e) {
                        if(e==null){
                        }else{
                            Log.e("创建数据失败：", e.getMessage());
                        }
                    }
                });

            }
        }).show();
    }

}
