package com.jly.garfieldprojects.ui.design;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.jly.garfieldprojects.R;
import com.jly.garfieldprojects.ui.DeleteListViewItemActivity;
import com.jly.garfieldprojects.ui.EditTextActivity;
import com.jly.garfieldprojects.ui.QqHeaderActivity;

/**
 * Created by Administrator on 2016/5/10.
 *
 * @author Jingly
 * @version V1.0
 * @classname: ${FILE_NAME}
 * @description: ${TODO} android 侧滑菜单
 * 直接将DrawerLayout作为根布局，然后其内部第一个View为内容区域，
 * 第二个View为左侧菜单，第三个View为右侧侧滑菜单，当前第三个是可选的。
第一个View的宽高应当设置为match_parent，当然了，这也理所当然。
第二、三个View需要设置android:layout_gravity="left"，
和android:layout_gravity="right"且一搬高度设置为match_parent，宽度为固定值，即侧滑菜单的宽度
 */
public class SideslipActivity extends Activity {
    private DrawerLayout mDrawerLayout;
    private ListView mLeftLv;
    private String[] contents = new String[]{"新闻","订阅","图片"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sideslip);
        initViews();
        initEvent();
    }

    private void initViews(){
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        //设置事件
        mDrawerLayout.setDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        });

        mLeftLv = (ListView) findViewById(R.id.leftLv);

        mLeftLv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, contents));
    }

    private void initEvent(){
        mLeftLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    startActivity(new Intent(SideslipActivity.this, DeleteListViewItemActivity.class));
                }else if(position == 1){
                    startActivity(new Intent(SideslipActivity.this, QqHeaderActivity.class));
                }else if(position == 2){
                    startActivity(new Intent(SideslipActivity.this, EditTextActivity.class));
                }
            }
        });
    }

}
