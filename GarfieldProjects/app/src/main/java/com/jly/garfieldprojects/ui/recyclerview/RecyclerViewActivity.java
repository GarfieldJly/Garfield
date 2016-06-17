package com.jly.garfieldprojects.ui.recyclerview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.jly.garfieldprojects.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/6/12.
 *
 * @author Jingly
 * @version V1.0
 * @classname: ${FILE_NAME}
 * @description: ${TODO} RecyclerView 的使用
 */
public class RecyclerViewActivity extends Activity {
    private RecyclerView recyclerView;
    private RecyclerViewAdapter mRecyclerViewAdapter;
    private ArrayList<String> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        initView();
    }

    private void initView() {
        initData();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerViewAdapter = new RecyclerViewAdapter(this,mList);
//        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        recyclerView.addItemDecoration(new DividerGridItemDecoration(this));
//        recyclerView.addItemDecoration(new SpaceItemDecoration(5,5));
//        recyclerView.addItemDecoration(new MyItemDecoration(this));
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL));
        recyclerView.setAdapter(mRecyclerViewAdapter);
        mRecyclerViewAdapter.setOnClickListener(new RecyclerViewAdapter.OnClickListener() {
            @Override
            public void onItemClickListener(View view, int position) {
                Toast.makeText(RecyclerViewActivity.this,"onItemClickListener,,,position ==="+position,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongItemClickListener(View view, int position) {
                Toast.makeText(RecyclerViewActivity.this,"onLongItemClickListener,,,position ==="+position,Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void initData(){
        mList = new ArrayList<String>();
        for (int i = 0; i < 21;i++){
            mList.add("garfield"+i);
        }
    }


}
