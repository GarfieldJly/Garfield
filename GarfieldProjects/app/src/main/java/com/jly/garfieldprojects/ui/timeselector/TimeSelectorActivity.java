package com.jly.garfieldprojects.ui.timeselector;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jly.garfieldprojects.BaseActivity;
import com.jly.garfieldprojects.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Administrator on 2016/5/17.
 *
 * @author Jingly
 * @version V1.0
 * @classname: ${FILE_NAME}
 * @description: ${TODO} 时间，日期选择器,以PopupWindow的形式
 */
public class TimeSelectorActivity extends BaseActivity {
    private static final String TAG = TimeSelectorActivity.class.getSimpleName();
    private RelativeLayout timeRl;
    private TextView timeTv;
    private TimePopupWindow mTimeWindow;
    private LinearLayout contentLl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_selector);

        init();
    }

    @Override
    public void setupView() {

    }

    private void init() {
        timeRl = (RelativeLayout) findViewById(R.id.timeRl);
        timeTv = (TextView) findViewById(R.id.timeTv);
        contentLl = (LinearLayout) findViewById(R.id.contentLl);
        timeRl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDefaultTime();
            }
        });

        mTimeWindow = new TimePopupWindow(this, com.jly.garfieldprojects.ui.timeselector.TimePopupWindow.Type.ALL);
        mTimeWindow.setOnTimeSelectListener(new TimePopupWindow.OnTimeSelectListener() {

            @Override
            public void onTimeSelect(Date date) { // 选择的时间 date
                String birthday = new SimpleDateFormat("yyyy-MM-dd hh:mm").format(date);
                timeTv.setText(birthday);
            }
        });
    }

    /**
     * 弹出时间选择框，显示默认值
     */
    private void showDefaultTime(){
        Calendar calendar = Calendar.getInstance();// 现在的时间
        int year = calendar.get(Calendar.YEAR);//获取年份
        int month= calendar.get(Calendar.MONTH);//获取月份
        int day=calendar.get(Calendar.DATE);//获取日

        mTimeWindow.setRange(year,2100);
        mTimeWindow.showAtLocation(contentLl, Gravity.BOTTOM, 0, 0);
    }
}

