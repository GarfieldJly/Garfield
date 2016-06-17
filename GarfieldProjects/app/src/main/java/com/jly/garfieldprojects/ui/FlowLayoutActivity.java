package com.jly.garfieldprojects.ui;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.jly.garfieldprojects.R;
import com.jly.garfieldprojects.constant.AppConstant;
import com.jly.garfieldprojects.utils.Utils;
import com.jly.garfieldprojects.widget.FlowLayout;

/**
 * Created by Administrator on 2016/6/14.
 *
 * @author Jingly
 * @version V1.0
 * @classname: ${FILE_NAME}
 * @description: ${TODO}  流式布局
 */
public class FlowLayoutActivity extends Activity {

    private FlowLayout flow_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flowlayout);

        initView();
    }

    private void initView() {
        FlowLayout.LayoutParams btpParams = new FlowLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        btpParams.leftMargin = dip2px(8);
        btpParams.rightMargin = dip2px(2);
        btpParams.topMargin = dip2px(8);

        flow_layout = (FlowLayout) findViewById(R.id.flow_layout);
        for(int i = 0; i < AppConstant.girlLabel.length;i++){

            CheckBox checkBox = new CheckBox(FlowLayoutActivity.this);
            checkBox.setText(AppConstant.girlLabel[i]);
            checkBox.setTextColor(Color.GREEN);
            checkBox.setBackgroundResource(R.drawable.flowlayout_button_bg);
            checkBox.setChecked(false);
            checkBox.setButtonDrawable(android.R.color.transparent);

            checkBox.setLayoutParams(btpParams);
            checkBox.setPadding(dip2px(10),dip2px(10),dip2px(10),dip2px(10));
            flow_layout.addView(checkBox);
        }
    }


    private int dip2px(int dp){
        return Utils.dip2px(this, dp);
    }

}
