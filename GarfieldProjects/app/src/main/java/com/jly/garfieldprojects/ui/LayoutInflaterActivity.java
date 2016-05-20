package com.jly.garfieldprojects.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.jly.garfieldprojects.R;

/**
 * Created by Administrator on 2016/5/19.
 *
 * @author Jingly
 * @version V1.0
 * @classname: ${FILE_NAME}
 * @description: ${TODO}(用一句话描述该文件做什么)
 */
public class LayoutInflaterActivity extends Activity {
    private static final String TAG = LayoutInflaterActivity.class.getSimpleName();
    private LinearLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layoutinflater);
        mainLayout = (LinearLayout) findViewById(R.id.main_layout);
        //最外层的布局是FrameLayout
//        ViewParent parent = mainLayout.getParent();
//        Log.i(TAG,"parent ===="+parent.toString());

        LayoutInflater layoutInflater = LayoutInflater.from(this);
        View buttonLayout = layoutInflater.inflate(R.layout.layoutinflater_item, null);
        mainLayout.addView(buttonLayout);
    }
}
