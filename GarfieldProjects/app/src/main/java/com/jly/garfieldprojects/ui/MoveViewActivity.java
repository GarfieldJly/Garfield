package com.jly.garfieldprojects.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.jly.garfieldprojects.BaseActivity;
import com.jly.garfieldprojects.widget.MoveView;

/**
 * Created by Administrator on 2016/6/15.
 *
 * @author Jingly
 * @version V1.0
 * @classname: ${FILE_NAME}
 * @description: ${TODO}(用一句话描述该文件做什么)
 */
public class MoveViewActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MoveView moveView = new MoveView(this);

        setContentView(moveView);

        Log.i("Air", "测试  执行子类 onCreate");
        setupView();
        handleIntent(getIntent());
    }


    public void setupView() {
        Log.i("Air", "测试  执行子类 setupView");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        Log.i("Air","测试  执行子类 onNewIntent");
        setIntent(intent);
        handleIntent(intent);
    }

    public void handleIntent(Intent intent) {

        super.handleIntent(intent);
        Log.i("Air","测试  执行子类 handleIntent");

        if (intent == null) return;
        refreshUI(intent);
    }

    public void refreshUI(Intent intent) {

        super.refreshUI(intent);
        Log.i("Air","测试  执行子类 refreshUI");
    }

}
