package com.jly.garfieldprojects.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.jly.garfieldprojects.R;

/**
 * Created by Administrator on 2016/6/15.
 *
 * @author Jingly
 * @version V1.0
 * @classname: ${FILE_NAME}
 * @description: ${TODO} 两个Activity之间的传值
 */
public class MoveViewActivity extends Activity {
    private static final String TAG = MoveViewActivity.class.getSimpleName();
    private TextView back_tv;
    public static int RESULT_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        MoveView moveView = new MoveView(this);
//        setContentView(moveView);

        setContentView(R.layout.activity_moveview);
        initView();
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

        Log.i("Air", "测试  执行子类 onNewIntent");
        setIntent(intent);
        handleIntent(intent);
    }

    public void handleIntent(Intent intent) {

        Log.i("Air", "测试  执行子类 handleIntent");

        if (intent == null) return;
        refreshUI(intent);
    }

    public void refreshUI(Intent intent) {

        Log.i("Air", "测试  执行子类 refreshUI");

        String value = intent.getStringExtra("move");
        Log.i(TAG, "测试  value ===" + value);

    }

    private void initView() {
        back_tv = (TextView) findViewById(R.id.back_tv);

        back_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent();
                it.putExtra("back","MoveViewActivity back");
                setResult(RESULT_OK, it);
                finish();
            }
        });
    }
}
