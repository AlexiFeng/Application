package com.example.alexi.demo0851.zhaozanzhu;

import android.app.Activity;
import android.content.Intent;
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
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.alexi.demo0851.R;
import com.example.alexi.demo0851.adapter.ZhaoZanZhuAdapter;
import com.example.alexi.demo0851.model.ZanzhuSearch;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhao_zz);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
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
            doSearch(rootView,getArguments().getInt(ARG_SECTION_NUMBER));
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

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
    public  static void doSearch(final View rootView, final int kind){
        BmobQuery<ZanzhuSearch> query = new BmobQuery<>();
        query.include("ac_club");
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


