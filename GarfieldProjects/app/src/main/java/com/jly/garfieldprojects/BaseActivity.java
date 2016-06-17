package com.jly.garfieldprojects;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.jly.garfieldprojects.utils.ViewUtils;

/**
 * Created by Administrator on 2016/5/11.
 *
 * @author Jingly
 * @version V1.0
 * @classname: ${FILE_NAME}
 * @description: ${TODO}(用一句话描述该文件做什么)
 */
public abstract class BaseActivity extends Activity {
    public <E extends View> E getView(int resId) {
        return ViewUtils.findViewById(this, resId);
    }

    private static final String TAG = BaseActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.i("Air", "测试  执行父类 onCreate");

        handleIntent(getIntent());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.i("Air","测试  执行父类 onNewIntent");
        //添加Activity
        handleIntent(intent);
    }

    public void handleIntent(Intent intent) {

        Log.i("Air", "测试  执行父类 handleIntent");

        refreshUI(intent);
    }

    public void refreshUI(Intent intent) {

        if (intent == null) return;
        Log.i("Air","测试  执行父类 refreshUI");
    }

    public abstract void setupView();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "执行BaseActivity ,,,onPause");
//        WeatherApplication.getInstance().getTtsEngine().removeAllUtteranceProgressListener();
    }


}
