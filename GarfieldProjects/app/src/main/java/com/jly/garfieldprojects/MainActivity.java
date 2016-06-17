package com.jly.garfieldprojects;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jly.garfieldprojects.mediaplayer.MediaplayerActivity;
import com.jly.garfieldprojects.ui.DeleteListViewItemActivity;
import com.jly.garfieldprojects.ui.EditTextActivity;
import com.jly.garfieldprojects.ui.FlowLayoutActivity;
import com.jly.garfieldprojects.ui.GridLayoutActivity;
import com.jly.garfieldprojects.ui.LayoutInflaterActivity;
import com.jly.garfieldprojects.ui.MoveViewActivity;
import com.jly.garfieldprojects.ui.ProgressBarActivity;
import com.jly.garfieldprojects.ui.QqHeaderActivity;
import com.jly.garfieldprojects.ui.design.NavigationViewActivity;
import com.jly.garfieldprojects.ui.design.SideslipActivity;
import com.jly.garfieldprojects.ui.design.SnackBarViewsActivity;
import com.jly.garfieldprojects.ui.drawable.DrawableActivity;
import com.jly.garfieldprojects.ui.drawable.TestDrawableActivity;
import com.jly.garfieldprojects.ui.popupwindow.PopupWindowActivity;
import com.jly.garfieldprojects.ui.recyclerview.RecyclerViewActivity;
import com.jly.garfieldprojects.ui.recyclerview.RecyclerViewTestActivity;
import com.jly.garfieldprojects.ui.refreshlistview.RefreshListViewActivity;
import com.jly.garfieldprojects.ui.timeselector.TimeSelectorActivity;
import com.jly.garfieldprojects.ui.timeselector.TimeSelectorActivity1;
import com.jly.garfieldprojects.ui.viewpager.ChangeableViewpagerActivity;
import com.jly.garfieldprojects.ui.webview.WebViewActivity;

/**
 * Created by Administrator on 2016/6/8.
 *
 * @author Jingly
 * @version V1.0
 * @classname: ${FILE_NAME}
 * @description: ${TODO}(用一句话描述该文件做什么)
 */
public class MainActivity extends Activity implements View.OnClickListener {

    private Button QqHeaderActivityBtn;
    private Button EditTextActivityBtn;
    private Button DeleteListViewItemActivityBtn;
    private Button SideslipActivityBtn;
    private Button ChangeableViewpagerActivityBtn;
    private Button NavigationViewActivityBtn;
    private Button SnackBarViewsActivityBtn;
    private Button PopupWindowActivityBtn;
    private Button MediaplayerActivityBtn;
    private Button TimeSelectorActivityBtn;
    private Button TimeSelectorActivity1Btn;
    private Button DrawableActivityBtn;
    private Button LayoutInflaterActivityBtn;
    private Button GridLayoutActivityBtn;
    private Button RefreshListViewActivityBtn;
    private Button WebViewActivityBtn;
    private Button ProgressBarActivityBtn;
    private Button TestDrawableActivityBtn;
    private Button RecyclerViewActivityBtn;
    private Button RecyclerViewTestActivityBtn;
    private Button FlowLayoutActivityBtn;
    private Button MoveViewActivityBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }


    private void initView() {
        QqHeaderActivityBtn = (Button) findViewById(R.id.QqHeaderActivityBtn);
        EditTextActivityBtn = (Button) findViewById(R.id.EditTextActivityBtn);
        DeleteListViewItemActivityBtn = (Button) findViewById(R.id.DeleteListViewItemActivityBtn);
        SideslipActivityBtn = (Button) findViewById(R.id.SideslipActivityBtn);
        ChangeableViewpagerActivityBtn = (Button) findViewById(R.id.ChangeableViewpagerActivityBtn);
        NavigationViewActivityBtn = (Button) findViewById(R.id.NavigationViewActivityBtn);
        SnackBarViewsActivityBtn = (Button) findViewById(R.id.SnackBarViewsActivityBtn);
        PopupWindowActivityBtn = (Button) findViewById(R.id.PopupWindowActivityBtn);
        MediaplayerActivityBtn = (Button) findViewById(R.id.MediaplayerActivityBtn);
        TimeSelectorActivityBtn = (Button) findViewById(R.id.TimeSelectorActivityBtn);
        TimeSelectorActivity1Btn = (Button) findViewById(R.id.TimeSelectorActivity1Btn);
        DrawableActivityBtn = (Button) findViewById(R.id.DrawableActivityBtn);
        LayoutInflaterActivityBtn = (Button) findViewById(R.id.LayoutInflaterActivityBtn);
        GridLayoutActivityBtn = (Button) findViewById(R.id.GridLayoutActivityBtn);
        RefreshListViewActivityBtn = (Button) findViewById(R.id.RefreshListViewActivityBtn);
        WebViewActivityBtn = (Button) findViewById(R.id.WebViewActivityBtn);
        ProgressBarActivityBtn = (Button) findViewById(R.id.ProgressBarActivityBtn);
        TestDrawableActivityBtn = (Button) findViewById(R.id.TestDrawableActivityBtn);

        QqHeaderActivityBtn.setOnClickListener(this);
        EditTextActivityBtn.setOnClickListener(this);
        DeleteListViewItemActivityBtn.setOnClickListener(this);
        SideslipActivityBtn.setOnClickListener(this);
        ChangeableViewpagerActivityBtn.setOnClickListener(this);
        NavigationViewActivityBtn.setOnClickListener(this);
        SnackBarViewsActivityBtn.setOnClickListener(this);
        PopupWindowActivityBtn.setOnClickListener(this);
        MediaplayerActivityBtn.setOnClickListener(this);
        TimeSelectorActivityBtn.setOnClickListener(this);
        TimeSelectorActivity1Btn.setOnClickListener(this);
        DrawableActivityBtn.setOnClickListener(this);
        LayoutInflaterActivityBtn.setOnClickListener(this);
        GridLayoutActivityBtn.setOnClickListener(this);
        RefreshListViewActivityBtn.setOnClickListener(this);
        WebViewActivityBtn.setOnClickListener(this);
        ProgressBarActivityBtn.setOnClickListener(this);
        TestDrawableActivityBtn.setOnClickListener(this);
        RecyclerViewActivityBtn = (Button) findViewById(R.id.RecyclerViewActivityBtn);
        RecyclerViewActivityBtn.setOnClickListener(this);
        RecyclerViewTestActivityBtn = (Button) findViewById(R.id.RecyclerViewTestActivityBtn);
        RecyclerViewTestActivityBtn.setOnClickListener(this);
        FlowLayoutActivityBtn = (Button) findViewById(R.id.FlowLayoutActivityBtn);
        FlowLayoutActivityBtn.setOnClickListener(this);
        MoveViewActivityBtn = (Button) findViewById(R.id.MoveViewActivityBtn);
        MoveViewActivityBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.QqHeaderActivityBtn:
                startActivity(new Intent(this, QqHeaderActivity.class));
                break;
            case R.id.EditTextActivityBtn:
                startActivity(new Intent(this, EditTextActivity.class));
                break;
            case R.id.DeleteListViewItemActivityBtn:
                startActivity(new Intent(this, DeleteListViewItemActivity.class));
                break;
            case R.id.SideslipActivityBtn:
                startActivity(new Intent(this, SideslipActivity.class));
                break;
            case R.id.ChangeableViewpagerActivityBtn:
                startActivity(new Intent(this, ChangeableViewpagerActivity.class));
                break;
            case R.id.NavigationViewActivityBtn:
                startActivity(new Intent(this, NavigationViewActivity.class));
                break;
            case R.id.SnackBarViewsActivityBtn:
                startActivity(new Intent(this, SnackBarViewsActivity.class));
                break;
            case R.id.PopupWindowActivityBtn:
                startActivity(new Intent(this, PopupWindowActivity.class));
                break;
            case R.id.MediaplayerActivityBtn:
                startActivity(new Intent(this, MediaplayerActivity.class));
                break;
            case R.id.TimeSelectorActivityBtn:
                startActivity(new Intent(this, TimeSelectorActivity.class));
                break;
            case R.id.TimeSelectorActivity1Btn:
                startActivity(new Intent(this, TimeSelectorActivity1.class));
                break;
            case R.id.DrawableActivityBtn:
                startActivity(new Intent(this, DrawableActivity.class));
                break;
            case R.id.LayoutInflaterActivityBtn:
                startActivity(new Intent(this, LayoutInflaterActivity.class));
                break;
            case R.id.GridLayoutActivityBtn:
                startActivity(new Intent(this, GridLayoutActivity.class));
                break;
            case R.id.RefreshListViewActivityBtn:
                startActivity(new Intent(this, RefreshListViewActivity.class));
                break;
            case R.id.WebViewActivityBtn:
                startActivity(new Intent(this, WebViewActivity.class));
                break;
            case R.id.ProgressBarActivityBtn:
                startActivity(new Intent(this, ProgressBarActivity.class));
                break;
            case R.id.TestDrawableActivityBtn:
                startActivity(new Intent(this, TestDrawableActivity.class));
                break;
            case R.id.RecyclerViewActivityBtn:
                startActivity(new Intent(this, RecyclerViewActivity.class));
                break;
            case R.id.RecyclerViewTestActivityBtn:
                startActivity(new Intent(this, RecyclerViewTestActivity.class));
                break;
            case R.id.FlowLayoutActivityBtn:
                startActivity(new Intent(this, FlowLayoutActivity.class));
                break;
            case R.id.MoveViewActivityBtn:
                startActivity(new Intent(this, MoveViewActivity.class));
                break;
        }
    }
}
