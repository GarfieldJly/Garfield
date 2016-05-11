package com.jly.garfieldprojects.ui.design;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.Window;

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
 * @description: ${TODO} 侧滑
 */
public class NavigationViewActivity extends Activity {
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_navigation);
        initViews();
    }

    private void initViews() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mNavigationView = (NavigationView) findViewById(R.id.navigationView);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.item1:
                        startActivity(new Intent(NavigationViewActivity.this, DeleteListViewItemActivity.class));
                        break;
                    case R.id.item2:
                        startActivity(new Intent(NavigationViewActivity.this, EditTextActivity.class));
                        break;
                    case R.id.item3:
                        startActivity(new Intent(NavigationViewActivity.this, QqHeaderActivity.class));
                        break;
                }
                return false;
            }
        });
    }
}
