package com.example.alexi.demo0851.zhaozanzhu;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alexi.demo0851.LoginActivity;
import com.example.alexi.demo0851.R;
import com.example.alexi.demo0851.model.club;
import com.example.alexi.demo0851.model.MyUser;
import com.example.alexi.demo0851.model.ZanzhuSearch;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.datatype.BmobDate;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;

public class NewZanzhu extends AppCompatActivity {
    static private club ac_club=new club();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        doSearch(getWindow().getDecorView());
        setContentView(R.layout.activity_new_zanzhu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TextView t=(TextView) findViewById(R.id.clubName_NewZZ);

    }

    public  static void doSearch(final View rootView){
        MyUser user = BmobUser.getCurrentUser(MyUser.class);
        BmobQuery<MyUser> query = new BmobQuery<MyUser>();
        query.addWhereEqualTo("objectId", user.getObjectId());
        query.include("club_belong");
        query.findObjects(new FindListener<MyUser>() {
            @Override
            public void done(final List<MyUser> object, BmobException e) {
                if(e!=null) {
                    Log.e("注意",e.getMessage());
                    Snackbar.make(rootView,""+e.getMessage(),Snackbar.LENGTH_LONG).show();

                }
                TextView t=(TextView)rootView.findViewById(R.id.clubName_NewZZ);
                t.setText("当前社团:"+object.get(0).getClub_belong().getClub_name());
                NewZanzhu.ac_club=object.get(0).getClub_belong();
            }
        });

    }
    public void submit(View view){
            TextView tName=(TextView)this.findViewById(R.id.Name_NewZZ);
            TextView tTime=(TextView)this.findViewById(R.id.Time_NewZZ);
            TextView tNeed=(TextView)this.findViewById(R.id.Need_NewZZ);
            TextView tProvide=(TextView)this.findViewById(R.id.Provide_NewZZ);
            TextView tOther=(TextView)this.findViewById(R.id.Other_NewZZ);
            SubmitTask s=new SubmitTask(tName.getText().toString(),tTime.getText().toString(),tNeed.getText().toString(),tProvide.getText().toString(),tOther.getText().toString());
            s.execute((Void) null);
    }

    public class SubmitTask extends AsyncTask<Void, Void, Boolean> {

        private final ZanzhuSearch zzs;

        SubmitTask(String ac_name, String ac_time,String ac_need, String ac_provide, String ac_other) {
            zzs=new ZanzhuSearch();
            zzs.setAc_club(NewZanzhu.ac_club);
            zzs.setAc_name(ac_name);
            zzs.setAc_need(ac_need);
            BmobDate test=BmobDate.createBmobDate("yyyy-mm-dd",ac_time);
            zzs.setAc_date(test);
            zzs.setAc_provide(ac_provide);
            zzs.setVerifying(0);
            zzs.setOther(ac_other);
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            // TODO: attempt authentication against a network service.

            try {
                zzs.save(new SaveListener<String>() {
                    @Override
                    public void done(String objectId,BmobException e) {
                        if(e==null){
                            GetBack(getWindow().getDecorView());
                        }else{
                            Toast.makeText(getApplicationContext(), e.getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                return false;
            }

            return true;
        }
    }

    public void GetBack(View view){
        final View v=view;
        AlertDialog.Builder Dialog =
                new AlertDialog.Builder(view.getContext());
        Dialog.setTitle("申请成功，请等待管理员审核");
        Dialog.setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       finish();
                    }
                });
        Dialog.show();



    }

    }
