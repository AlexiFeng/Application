package com.example.alexi.demo0851;

import android.content.Intent;
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
import android.widget.TextView;
import android.widget.Toast;


import com.example.alexi.demo0851.bangyang.bangyang_ListActivity;
import com.example.alexi.demo0851.model.MyUser;
import com.example.alexi.demo0851.zhaozanzhu.ZhaoZZ;


import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
        private View headerLayout;
        private NavigationView navigationView;
        private MyUser nowUser;
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
                case 0:inner = new String[]{"管理员", "修改个人信息","申请审批","登出"};nV_Generator(0, inner);break;
                case 1:inner = new String[]{"学生", "修改个人信息", "我的社团","登出"};nV_Generator(1, inner);break;
                case 2:inner = new String[]{"社团负责人", "修改个人信息","社团管理","交易记录","登出"};nV_Generator(2, inner);break;
                case 3:inner = new String[]{"社会人士", "修改个人信息", "我的赞助","登出"};nV_Generator(3, inner);break;
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

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        int group=item.getGroupId();
        if (id == R.id.nav_login) {
            turnLogin();
        } else if (id == R.id.nav_register) {
            turnRegister();
        } else if (id == R.id.nav_slideshow) {
            logout();

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        } else if(id==0){
            turnLogin();
        }
        else if(id==1){
            logout();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void turnLogin() {
        MyUser currentUser = BmobUser.getCurrentUser(MyUser.class);
        if(currentUser != null){
            Snackbar.make(getWindow().getDecorView(), "登陆成功", Snackbar.LENGTH_SHORT).show();
        }else{
            startActivity(new Intent(this,LoginActivity.class));
        }
    }
    public void turnRegister() {
        startActivity(new Intent(this,RegisterActivity.class));
    }

    public void onClick_Zanzhu(View view){
        startActivity(new Intent(this, ZhaoZZ.class));
    }
    public void onClick_SheTuan(View view){
        startActivity(new Intent(this,bangyang_ListActivity.class));
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
}



