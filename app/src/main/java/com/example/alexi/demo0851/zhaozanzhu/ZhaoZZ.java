package com.example.alexi.demo0851.zhaozanzhu;

import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.design.widget.TabLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.alexi.demo0851.LoginActivity;
import com.example.alexi.demo0851.R;
import com.example.alexi.demo0851.adapter.ClubAdapter;
import com.example.alexi.demo0851.adapter.FengCaiAdapter;
import com.example.alexi.demo0851.adapter.SchoolAdapter;
import com.example.alexi.demo0851.adapter.YiHuBaiYingAdapter;
import com.example.alexi.demo0851.adapter.ZhaoZanZhuAdapter;
import com.example.alexi.demo0851.model.Course;
import com.example.alexi.demo0851.model.FengCaiSearch;
import com.example.alexi.demo0851.model.MyUser;
import com.example.alexi.demo0851.model.Post;
import com.example.alexi.demo0851.model.School;
import com.example.alexi.demo0851.model.ZanzhuSearch;
import com.example.alexi.demo0851.model.club;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Objects;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.datatype.BmobFile;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.DownloadFileListener;
import cn.bmob.v3.listener.FindListener;

import static com.example.alexi.demo0851.R.id.time;

public class ZhaoZZ extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;
    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    private static Activity tActivity;
    private static String instance;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_zhao_zz);
        //---传值
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("bundle");
        instance = (String) bundle.getSerializable("instance");

        //---传值结束
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (instance.equals("shetuan")){
            toolbar.setTitle("社团信息");
        }
        else if(instance.equals("zanzhu")){
            toolbar.setTitle("找赞助");
        }
        else if(instance.equals("fengcai")){
            toolbar.setTitle("风采活动");
        }
        else if(instance.equals("yihubaiying")){
            toolbar.setTitle("一呼百应");

        }
        else if(instance.equals("course")){
            toolbar.setTitle("课程信息");
        }
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);

        mViewPager.setAdapter(mSectionsPagerAdapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        if(instance.equals("yihubaiying"))
            tabLayout.setVisibility(View.GONE);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //生成右侧发布赞助按钮
        getMenuInflater().inflate(R.menu.menu_zhao_zz, menu);
        MyUser currentUser = BmobUser.getCurrentUser(MyUser.class);
        if(currentUser != null&&currentUser.getStatus()==1&&instance.equals("zanzhu"))
            menu.getItem(0).setVisible(true);
        else
            menu.getItem(0).setVisible(false);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.add_zhaozz ){
            startActivity(new Intent(this,LoginActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void newZanzhu(MenuItem item) {
        startActivity(new Intent(this,NewZanzhu.class));
    }


    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            final View rootView = inflater.inflate(R.layout.fragment_zhao_zz, container, false);

            RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.my_recycler_view);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            tActivity=this.getActivity();
            if (instance.equals("shetuan")){
                doSearch_ST(rootView,getArguments().getInt(ARG_SECTION_NUMBER));
            }
            else if(instance.equals("zanzhu")){
                doSearch_ZZ(rootView,getArguments().getInt(ARG_SECTION_NUMBER));
            }
            else if(instance.equals("fengcai")){
                doSearch_FC(rootView,getArguments().getInt(ARG_SECTION_NUMBER));
            }
            else if(instance.equals("yihubaiying")){
                doSearch_YHBY(rootView);
            }
            else if(instance.equals("course")){
                doSearch_Course(rootView);
            }
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public static class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            // Show 6 total pages.
            return 6;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "全部";
                case 1:
                    return "文娱";
                case 2:
                    return "学术";
                case 3:
                    return "体育";
                case 4:
                    return "公益";
                case 5:
                    return "其他";
            }
            return null;
        }
    }
    public  static void doSearch_ZZ(final View rootView, final int kind){
        BmobQuery<ZanzhuSearch> query = new BmobQuery<>();
        query.include("ac_club");
        query.addWhereEqualTo("verifying",1);
        if(kind!=0)
            query.addWhereEqualTo("ac_kind",kind);

        query.findObjects(new FindListener<ZanzhuSearch>() {
            @Override
            public void done(final List<ZanzhuSearch> object, BmobException e) {
                if(e!=null) {
                    Log.e("注意",e.getMessage());
                    Snackbar.make(rootView,""+e.getMessage(),Snackbar.LENGTH_LONG).show();
                }
                final RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.my_recycler_view);
                //创建适配器
                ZhaoZanZhuAdapter adapter = new ZhaoZanZhuAdapter(R.layout.item_rv_zanzhu, object);
                adapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
                adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                        Intent intent=new Intent(rootView.getContext(),Content_ZhaoZZ.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("instance", object.get(position));
                        bundle.putSerializable("kind", "zanzhu");
                        intent.putExtra("bundle", bundle);
                        tActivity.startActivity(intent);
                    }
                });

                //给RecyclerView设置适配器
                recyclerView.setAdapter(adapter);

            }
        });
    }

    public  static void doSearch_FC(final View rootView, final int kind){
        BmobQuery<FengCaiSearch> query = new BmobQuery<>();
        query.include("fc_club");
        if(kind!=0)
            query.addWhereEqualTo("fc_kind",kind);
        query.findObjects(new FindListener<FengCaiSearch>() {
            @Override
            public void done(final List<FengCaiSearch> object, BmobException e) {
                if(e!=null) {
                    Log.e("注意",e.getMessage());
                    Snackbar.make(rootView,""+e.getMessage(),Snackbar.LENGTH_LONG).show();
                }

                final RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.my_recycler_view);
                //创建适配器
                FengCaiAdapter adapter = new FengCaiAdapter(R.layout.item_rv_zanzhu, object);
                adapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
                adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                        Intent intent=new Intent(rootView.getContext(),Content_ZhaoZZ.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("instance", object.get(position));
                        bundle.putSerializable("kind", "fengcai");
                        intent.putExtra("bundle", bundle);
                        tActivity.startActivity(intent);
                    }
                });
                //给RecyclerView设置适配器
                recyclerView.setAdapter(adapter);

            }
        });
    }
    public static void doSearch_ST(final View rootView, final int kind){
        BmobQuery<club> query = new BmobQuery<>();
        if(kind!=0)
            query.addWhereEqualTo("club_kind",kind);
        query.include("club_manager");
        query.findObjects(new FindListener<club>() {
            @Override
            public void done(final List<club> object, BmobException e) {
                if(e!=null) {
                    Log.e("注意",e.getMessage());
                    Snackbar.make(rootView,""+e.getMessage(),Snackbar.LENGTH_LONG).show();
                }


                final RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.my_recycler_view);
                //创建适配器
                ClubAdapter adapter = new ClubAdapter(R.layout.item_rv_zanzhu, object);
                adapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
                adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                        Intent intent=new Intent(rootView.getContext(),Content_ZhaoZZ.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("instance", object.get(position));
                        bundle.putSerializable("kind", "shetuan");
                        intent.putExtra("bundle", bundle);
                        tActivity.startActivity(intent);
                    }
                });
                //给RecyclerView设置适配器
                recyclerView.setAdapter(adapter);

            }
        });
    }
    public static void doSearch_YHBY(final View rootView){

        BmobQuery<Post> query = new BmobQuery<>();

        query.findObjects(new FindListener<Post>() {
            @Override
            public void done(final List<Post> object, BmobException e) {
                if(e!=null) {
                    Log.e("注意",e.getMessage());
                    Snackbar.make(rootView,""+e.getMessage(),Snackbar.LENGTH_LONG).show();
                }
                final RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.my_recycler_view);
                //创建适配器
                YiHuBaiYingAdapter adapter = new YiHuBaiYingAdapter(R.layout.item_rv_zanzhu, object);
                adapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
                adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                        Intent intent=new Intent(rootView.getContext(),Content_ZhaoZZ.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("instance", object.get(position));
                        bundle.putSerializable("kind", "yihubaiying");
                        intent.putExtra("bundle", bundle);
                        tActivity.startActivity(intent);
                    }
                });
                //给RecyclerView设置适配器
                recyclerView.setAdapter(adapter);

            }
        });
    }
    public static void doSearch_Course(final View rootView){

        BmobQuery<School> query = new BmobQuery<>();

        query.findObjects(new FindListener<School>() {
            @Override
            public void done(final List<School> object, BmobException e) {
                if(e!=null) {
                    Log.e("注意",e.getMessage());
                    Snackbar.make(rootView,""+e.getMessage(),Snackbar.LENGTH_LONG).show();
                }
                final RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.my_recycler_view);
                //创建适配器

                SchoolAdapter adapter = new SchoolAdapter(R.layout.item_rv_zanzhu, object,rootView);
                adapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
                adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                        Intent intent=new Intent(rootView.getContext(),Content_ZhaoZZ.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("instance", object.get(position));
                        bundle.putSerializable("kind", "course");
                        intent.putExtra("bundle", bundle);
                        tActivity.startActivity(intent);
                    }
                });
                //给RecyclerView设置适配器
                recyclerView.setAdapter(adapter);
            }
        });
    }

}


