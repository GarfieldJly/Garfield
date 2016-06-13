package com.jly.garfieldprojects.ui.recyclerview;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
 * @description: ${TODO} 竖屏时以ListView显示，横屏时以GridView显示
 */
public class RecyclerViewTestActivity extends Activity {
    private RecyclerView recyclerView;
    private RecyclerViewAdapter mRecyclerViewAdapter;
    private ArrayList<String> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int mCurrentOrientation = getResources().getConfiguration().orientation;
        if ( mCurrentOrientation == Configuration.ORIENTATION_PORTRAIT ) {

            // If current screen is portrait

            Log.i("info", "portrait"); // 竖屏

            test();
            portraitView();
            mRecyclerViewAdapter = new RecyclerViewAdapter(this,mList);
            recyclerView.setAdapter(mRecyclerViewAdapter);
            initEvent();
        } else if ( mCurrentOrientation == Configuration.ORIENTATION_LANDSCAPE ) {

            //If current screen is landscape
            Log.i("info", "landscape"); // 横屏

            test();
            landscape();
            mRecyclerViewAdapter = new RecyclerViewAdapter(this,mList);
            recyclerView.setAdapter(mRecyclerViewAdapter);
            initEvent();
        }

    }

    private void portraitView() {
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void landscape() {
        recyclerView.addItemDecoration(new DividerGridItemDecoration(this));
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
    }

    private void initEvent(){
        mRecyclerViewAdapter.setOnClickListener(new RecyclerViewAdapter.OnClickListener() {
            @Override
            public void onItemClickListener(View view, int position) {
                Toast.makeText(RecyclerViewTestActivity.this, "onItemClickListener,,,position ===" + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongItemClickListener(View view, int position) {
                Toast.makeText(RecyclerViewTestActivity.this, "onLongItemClickListener,,,position ===" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void test(){
        setContentView(R.layout.activity_recyclerview);
        initData();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

    }


    private void initData(){
        mList = new ArrayList<String>();
        for (int i = 0; i < 21;i++){
            mList.add("garfield"+i);
        }
    }

    /**
     * 横竖屏的切换
     * @param newConfig
     */
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        int mCurrentOrientation = newConfig.orientation;

        if ( mCurrentOrientation == Configuration.ORIENTATION_PORTRAIT ) {

            // If current screen is portrait

            Log.i("info", "portrait"); // 竖屏

            recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
            portraitView();
            mRecyclerViewAdapter = new RecyclerViewAdapter(this,mList);
            recyclerView.setAdapter(mRecyclerViewAdapter);
            initEvent();

            Toast.makeText(this,"portrait",Toast.LENGTH_SHORT).show();
        } else if ( mCurrentOrientation == Configuration.ORIENTATION_LANDSCAPE ) {

            //If current screen is landscape
            Log.i("info", "landscape"); // 横屏
            recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
            landscape();
            mRecyclerViewAdapter = new RecyclerViewAdapter(this,mList);
            recyclerView.setAdapter(mRecyclerViewAdapter);
            initEvent();

            Toast.makeText(this,"landscape",Toast.LENGTH_SHORT).show();
        }
    }
}
