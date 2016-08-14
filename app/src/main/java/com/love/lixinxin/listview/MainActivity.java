package com.love.lixinxin.listview;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.Toast;

import com.love.lixinxin.listview.view.PullUpListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {


    private SwipeRefreshLayout refreshLayout;
    private PullUpListView listView;
    private ArrayList<String> lists;
    private ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        refreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRe_fresh);
        listView = (PullUpListView) findViewById(R.id.list_view);

        refreshLayout.setOnRefreshListener(this);

        lists = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            lists.add("lixinxin" + i);
        }

        adapter = new ListAdapter(this, lists);

        listView.setAdapter(adapter);
        listView.initBottomView();

        listView.setPullUpListViewCallBack(new PullUpListView.PullUpListViewCallBack() {
            @Override
            public void scrollBottomState() {

                listView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        lists.add("上拉加载的数据");
                        adapter.mData=lists;
                        adapter.notifyDataSetChanged();
                        Toast.makeText(MainActivity.this, "加载更多...", Toast.LENGTH_SHORT).show();
                    }
                },2000);



            }
        });

//        View footerView=View.inflate(this,R.layout.foot_view,null);
//        listView.addFooterView(footerView);


    }

    @Override
    public void onRefresh() {

        refreshLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                lists.add(0,"下拉刷新的数据");
                adapter.mData=lists;
                adapter.notifyDataSetChanged();
                refreshLayout.setRefreshing(false);
                Toast.makeText(MainActivity.this, "下拉刷新。。。。。", Toast.LENGTH_SHORT).show();
            }
        },3000);


    }
}
