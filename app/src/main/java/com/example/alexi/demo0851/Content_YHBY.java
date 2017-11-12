package com.example.alexi.demo0851;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.alexi.demo0851.adapter.ClubAdapter;
import com.example.alexi.demo0851.adapter.CommentAdapter;
import com.example.alexi.demo0851.model.Comment;
import com.example.alexi.demo0851.model.MyUser;
import com.example.alexi.demo0851.model.Post;
import com.example.alexi.demo0851.model.club;
import com.example.alexi.demo0851.zhaozanzhu.Content_ZhaoZZ;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

import static com.example.alexi.demo0851.R.id.Register;
import static com.example.alexi.demo0851.R.id.comment_YHBY;
import static com.example.alexi.demo0851.R.id.container;

public class Content_YHBY extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content__yhby);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        MyUser currentUser = BmobUser.getCurrentUser(MyUser.class);
        Glide.with(this)
                .load("https://bmob-cdn-15019.b0.upaiyun.com/2017/11/10/51213eca4028951a80578e806dac0af9.jpeg")
                .into((ImageView) findViewById(R.id.headerAuthor_YHBY));
        Glide.with(this)
                .load("https://bmob-cdn-15019.b0.upaiyun.com/2017/11/10/2d1cd4ce402832d980e8ecf57c1112b5.jpeg")
                .into((ImageView)findViewById(R.id.head_answer));
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("bundle");
        Post tempPost=(Post)bundle.getSerializable("instance");

        TextView title=(TextView)findViewById(R.id.title_YHBY);
        TextView content=(TextView)findViewById(R.id.content_YHBY);
        TextView author=(TextView)findViewById(R.id.author_YHBY);
        author.setText("Alexi.F");
        TextView publish=(TextView)findViewById(R.id.publish_YHBY);
        publish.setText(tempPost.getCreatedAt().toString());
        title.setText(tempPost.getTitle());
        content.setText(tempPost.getContent());

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "快捷回复", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        BmobQuery<Comment> query = new BmobQuery<>();
        query.include("author");
        query.findObjects(new FindListener<Comment>() {
            @Override
            public void done(final List<Comment> object, BmobException e) {
                if(e!=null) {
                    Log.e("注意",e.getMessage());
                }
                final TextView comments = (TextView)findViewById(comment_YHBY);
                comments.setText("");
                for(Comment test : object){
                    comments.append("("+test.getCreatedAt().toString()+"):"+test.getContent());
                }
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
