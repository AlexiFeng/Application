package com.example.alexi.demo0851;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alexi.demo0851.model.MyUser;
import com.example.alexi.demo0851.zhaozanzhu.ZhaoZZ;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;
import com.jude.rollviewpager.hintview.ColorPointHintView;


import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
        private View headerLayout;
        private NavigationView navigationView;
        private MyUser nowUser;
        private RollPagerView mRollViewPager;
        private Intent intent;
        private Bundle bundle;
    public void onRestart(){
        super.onRestart();

        getMenuInflater().inflate(R.menu.activity_main_drawer,navigationView.getMenu() );
        nowUser = MyUser.getCurrentUser(MyUser.class);
        navigationView.getMenu().clear();
        TextView myName = (TextView) headerLayout.findViewById(R.id.nav_header_name);
        TextView myEmail = (TextView) headerLayout.findViewById(R.id.nav_header_email);
        if(nowUser != null){
            if (nowUser.getNick() != null) {
                myEmail.setText(nowUser.getEmail());
                myName.setText(nowUser.getNick());
            } else {
                myName.setText("");
            }
            String[] inner;
            switch(nowUser.getStatus()){
                case 0:inner = new String[]{ "修改个人信息","审批申请","登出"};nV_Generator(0, inner);myName.append("[管理员]");break;
                case 1:inner = new String[]{"修改个人信息","社团管理","我的活动","我的筹一筹","交易记录","登出"};nV_Generator(1, inner);myName.append("[社团管理者]");break;
                case 2:inner = new String[]{ "修改个人信息", "我的社团","我的筹一筹","登出"};nV_Generator(2, inner);myName.append("[学生]");break;
                case 3:inner = new String[]{"修改个人信息", "我发布的赞助","我提供的赞助","交易记录","登出"};nV_Generator(3, inner);myName.append("[企业人士]");break;
            }
        }
        else{
            myName.setText("请先登录");
            myEmail.setText("username@email.com");
            navigationView.getMenu().add(1,0,1,"登录");
            navigationView.getMenu().add(1,1,1,"关于");
            navigationView.getMenu().setGroupVisible(0,false);
        }
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bmob.initialize(this, "b4bd95bc135ed4253b13b71fa22637f2");
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        headerLayout = navigationView.inflateHeaderView(R.layout.nav_header_main);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        TextView notice=(TextView)findViewById(R.id.notice);
        notice.setBackgroundColor(Color.parseColor("#DAA520"));
        notice.setText("目前入驻商家8户,入驻社团30个");
        TextView index_content=(TextView)findViewById(R.id.index_content);
        index_content.setText("Alexi发布了新的筹一筹信息");
        index_content.append("\n欢迎Love-Coding社团加入平台！");
        index_content.append("\n欢迎开智学堂加入认证商家！");
        index_content.append("\n欢迎新用户Alexi！");
        TextView index_time=(TextView)findViewById(R.id.index_time);
        index_time.setTextColor(Color.BLUE);
        index_time.setText("[32分钟前]");
        index_time.append("\n[54分钟前]");
        index_time.append("\n[6小时前]");
        index_time.append("\n[3天前]");
        //---轮播图

        mRollViewPager = (RollPagerView) findViewById(R.id.roll_view_pager);

        //设置播放时间间隔
        mRollViewPager.setPlayDelay(1000);
        //设置透明度
        mRollViewPager.setAnimationDurtion(500);
        //设置适配器
        mRollViewPager.setAdapter(new TestNormalAdapter());

        //设置指示器（顺序依次）
        //自定义指示器图片
        //设置圆点指示器颜色
        //设置文字指示器
        //隐藏指示器
        //mRollViewPager.setHintView(new IconHintView(this, R.drawable.point_focus, R.drawable.point_normal));
        mRollViewPager.setHintView(new ColorPointHintView(this, Color.YELLOW,Color.WHITE));
        //mRollViewPager.setHintView(new TextHintView(this));
        //mRollViewPager.setHintView(null);
        //---

        onRestart();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        int group=item.getGroupId();
        MyUser currentUser = BmobUser.getCurrentUser(MyUser.class);
        if(currentUser==null){
            if (id==0)
            turnLogin();
        }
        else{
            if(group==0){
               //TODO:管理员状态侧栏函数
                switch(id){
                    case 0: startActivity(new Intent(this,Information_Xiugai.class));break;
                    case 1: startActivity(new Intent(this,ShenQingShenpi.class));break;
                }

            }
            else if(group==1){
               //TODO:社团管理者状态侧栏函数
                switch(id){
                    case 0: startActivity(new Intent(this,Information_Xiugai.class));break;
                    case 1: startActivity(new Intent(this,ShenQingShenpi.class));break;
                    case 2: break;
                    case 3: break;
                    case 4: break;
                    case 5: logout();break;
                }
            }
            else if(group==2){
               //TODO:学生状态侧栏函数
                switch(id){
                    case 0: startActivity(new Intent(this,Information_Xiugai.class));break;
                    case 1: break;
                    case 2: break;
                    case 3: break;
                    case 4: break;
                    case 5: logout();break;
                }
            }
            else if(group==3){
                //TODO:社会人士状态侧栏函数
                switch(id){
                    case 0: startActivity(new Intent(this,Information_Xiugai.class));break;
                    case 1: break;
                    case 2: break;
                    case 3: break;
                    case 4: break;
                    case 5: logout();break;
                }
            }

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void turnLogin() {
            startActivity(new Intent(this,LoginActivity.class));
    }

    public void onClick_Zanzhu(View view){
        intent=new Intent(view.getContext(),ZhaoZZ.class);
        bundle = new Bundle();
        bundle.putSerializable("instance","zanzhu");
        intent.putExtra("bundle", bundle);
        startActivity(intent);
    }
    public void onClick_SheTuan(View view){
        intent=new Intent(view.getContext(),ZhaoZZ.class);
        bundle = new Bundle();
        bundle.putSerializable("instance","shetuan");
        intent.putExtra("bundle", bundle);
        startActivity(intent);
    }
    public void onClick_FengCai(View view){
        intent=new Intent(view.getContext(),ZhaoZZ.class);
        bundle = new Bundle();
        bundle.putSerializable("instance","fengcai");
        intent.putExtra("bundle", bundle);
        startActivity(intent);
    }
    public void logout(){
        MyUser.logOut();
        Snackbar.make(getWindow().getDecorView(), "登出成功", Snackbar.LENGTH_SHORT).show();
        MainActivity.this.onRestart();

    }
    public void nV_Generator(Integer group,String[] inner){
        for(int i=0;i<inner.length;i++)
        navigationView.getMenu().add(group,i,1,inner[i]);
        navigationView.getMenu().setGroupVisible(0,false);
    }

    ///------------------------轮播图
    private class TestNormalAdapter extends StaticPagerAdapter {
        private int[] imgs = {
                R.drawable.first,
                R.drawable.second

        };


        @Override
        public View getView(ViewGroup container, int position) {
            ImageView view = new ImageView(container.getContext());
            view.setImageResource(imgs[position]);
            view.setScaleType(ImageView.ScaleType.CENTER_CROP);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            return view;
        }


        @Override
        public int getCount() {
            return imgs.length;
        }
    }
    ///------------------------
    public void onClick_Yihubaiying(View view){
        intent=new Intent(view.getContext(),ZhaoZZ.class);
        bundle = new Bundle();
        bundle.putSerializable("instance","yihubaiying");
        intent.putExtra("bundle", bundle);
        startActivity(intent);
    }
    public void onClick_Course(View view){
        intent=new Intent(view.getContext(),ZhaoZZ.class);
        bundle = new Bundle();
        bundle.putSerializable("instance","course");
        intent.putExtra("bundle", bundle);
        startActivity(intent);
    }
}



