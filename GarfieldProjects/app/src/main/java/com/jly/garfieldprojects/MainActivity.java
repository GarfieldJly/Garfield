package com.jly.garfieldprojects;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.jly.garfieldprojects.mediaplayer.MediaplayerActivity;
import com.jly.garfieldprojects.ui.DeleteListViewItemActivity;
import com.jly.garfieldprojects.ui.EditTextActivity;
import com.jly.garfieldprojects.ui.GridLayoutActivity;
import com.jly.garfieldprojects.ui.LayoutInflaterActivity;
import com.jly.garfieldprojects.ui.ProgressBarActivity;
import com.jly.garfieldprojects.ui.QqHeaderActivity;
import com.jly.garfieldprojects.ui.design.NavigationViewActivity;
import com.jly.garfieldprojects.ui.design.SideslipActivity;
import com.jly.garfieldprojects.ui.design.SnackBarViewsActivity;
import com.jly.garfieldprojects.ui.drawable.DrawableActivity;
import com.jly.garfieldprojects.ui.popupwindow.PopupWindowActivity;
import com.jly.garfieldprojects.ui.refreshlistview.RefreshListViewActivity;
import com.jly.garfieldprojects.ui.timeselector.TimeSelectorActivity;
import com.jly.garfieldprojects.ui.timeselector.TimeSelectorActivity1;
import com.jly.garfieldprojects.ui.viewpager.ChangeableViewpagerActivity;
import com.jly.garfieldprojects.ui.webview.WebViewActivity;

public class MainActivity extends Activity implements View.OnClickListener {
    private static final String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        retrieveMetaData();

        //每个应用程序最高可用内存是 128M
        int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        Log.d(TAG, "Max memory is " + maxMemory + "KB");

        GarfieldApplication.getInstance().addActivity(this);
    }

    private void initView(){
        ((Button)findViewById(R.id.QqHeaderActivityBtn)).setOnClickListener(this);
        ((Button)findViewById(R.id.EditTextActivityBtn)).setOnClickListener(this);
        ((Button)findViewById(R.id.DeleteListViewItemActivityBtn)).setOnClickListener(this);
        ((Button)findViewById(R.id.SideslipActivityBtn)).setOnClickListener(this);
        ((Button)findViewById(R.id.ChangeableViewpagerActivityBtn)).setOnClickListener(this);
        ((Button)findViewById(R.id.NavigationViewActivityBtn)).setOnClickListener(this);
        ((Button)findViewById(R.id.SnackBarViewsActivityBtn)).setOnClickListener(this);
        ((Button)findViewById(R.id.PopupWindowActivityBtn)).setOnClickListener(this);
        ((Button)findViewById(R.id.MediaplayerActivityBtn)).setOnClickListener(this);
        ((Button)findViewById(R.id.TimeSelectorActivityBtn)).setOnClickListener(this);
        ((Button)findViewById(R.id.TimeSelectorActivity1Btn)).setOnClickListener(this);
        ((Button)findViewById(R.id.DrawableActivityBtn)).setOnClickListener(this);
        ((Button)findViewById(R.id.LayoutInflaterActivityBtn)).setOnClickListener(this);
        ((Button)findViewById(R.id.GridLayoutActivityBtn)).setOnClickListener(this);
        ((Button)findViewById(R.id.RefreshListViewActivityBtn)).setOnClickListener(this);
        ((Button)findViewById(R.id.WebViewActivityBtn)).setOnClickListener(this);
        ((Button)findViewById(R.id.ProgressBarActivityBtn)).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.QqHeaderActivityBtn:
                startActivity(new Intent(MainActivity.this, QqHeaderActivity.class));
                break;
            case R.id.EditTextActivityBtn:
                startActivity(new Intent(MainActivity.this, EditTextActivity.class));
                break;
            case R.id.DeleteListViewItemActivityBtn:
                startActivity(new Intent(MainActivity.this, DeleteListViewItemActivity.class));
                break;
            case R.id.SideslipActivityBtn:
                startActivity(new Intent(MainActivity.this, SideslipActivity.class));
                break;
            case R.id.ChangeableViewpagerActivityBtn:
                startActivity(new Intent(MainActivity.this, ChangeableViewpagerActivity.class));
                break;
            case R.id.NavigationViewActivityBtn:
                startActivity(new Intent(MainActivity.this, NavigationViewActivity.class));
                break;
            case R.id.SnackBarViewsActivityBtn:
                startActivity(new Intent(MainActivity.this, SnackBarViewsActivity.class));
                break;
            case R.id.PopupWindowActivityBtn:
                startActivity(new Intent(MainActivity.this, PopupWindowActivity.class));
                break;
            case R.id.MediaplayerActivityBtn:
                startActivity(new Intent(MainActivity.this, MediaplayerActivity.class));
                break;
            case R.id.TimeSelectorActivityBtn:
                startActivity(new Intent(MainActivity.this, TimeSelectorActivity.class));
                break;
            case R.id.TimeSelectorActivity1Btn:
                startActivity(new Intent(MainActivity.this, TimeSelectorActivity1.class));
                break;
            case R.id.DrawableActivityBtn:
                startActivity(new Intent(MainActivity.this, DrawableActivity.class));
                break;
            case R.id.LayoutInflaterActivityBtn:
                startActivity(new Intent(MainActivity.this, LayoutInflaterActivity.class));
                break;
            case R.id.GridLayoutActivityBtn:
                startActivity(new Intent(MainActivity.this, GridLayoutActivity.class));
                break;
            case R.id.RefreshListViewActivityBtn:
                startActivity(new Intent(MainActivity.this, RefreshListViewActivity.class));
                break;
            case R.id.WebViewActivityBtn:
                startActivity(new Intent(MainActivity.this, WebViewActivity.class));
                break;
            case R.id.ProgressBarActivityBtn:
                startActivity(new Intent(MainActivity.this, ProgressBarActivity.class));
                break;
        }
    }

    private void retrieveMetaData() {
        ComponentName cn = new ComponentName(this, this.getClass()); // ComponentName（组件名称）是用来打开其他应用程序中的Activity或服务的。

        /**
         * PackageManager介绍： 本类API是对所有基于加载信息的数据结构的封装，包括以下功能： 安装，卸载应用
         * 查询permission相关信息 查询Application相关
         * 信息(application，activity，receiver，service，provider及相应属性等） 查询已安装应用
         * 增加，删除permission 清除用户数据、缓存，代码段等 非查询相关的API需要特定的权限。
         * 主要包含了，安装在当前设备上的应用包的相关信息 如下：获取已经安装的应用程序的信息
         */

        PackageManager pm = getPackageManager();
        Bundle bundle;
        try {
            bundle = pm.getActivityInfo(cn, PackageManager.GET_META_DATA).metaData;
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException("System fault!!!", e);
        }

        if (bundle == null) {
            Log.i(TAG, "in retrieveMetaData, no meta data");
            return;
        }
        int mLiveType  = bundle.getInt("garfieldType");
        Log.i(TAG,"mLiveType ========="+mLiveType);
    }
}
