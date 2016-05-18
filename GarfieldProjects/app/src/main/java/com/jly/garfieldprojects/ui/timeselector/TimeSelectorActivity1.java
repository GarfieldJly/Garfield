package com.jly.garfieldprojects.ui.timeselector;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jly.garfieldprojects.BaseActivity;
import com.jly.garfieldprojects.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Administrator on 2016/5/17.
 *
 * @author Jingly
 * @version V1.0
 * @classname: ${FILE_NAME}
 * @description: ${TODO} 时间，日期选择器,以Dialog的形式
 */
public class TimeSelectorActivity1 extends BaseActivity {
    private static final String TAG = TimeSelectorActivity1.class.getSimpleName();
    private RelativeLayout timeRl;
    private TextView timeTv;
    WheelTime wheelTime;
    private View btnSubmit, btnCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_selector);

        init();
    }

    private void init() {
        timeRl = (RelativeLayout) findViewById(R.id.timeRl);
        timeTv = (TextView) findViewById(R.id.timeTv);
        timeRl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimeDialog(TimeSelectorActivity1.this);
            }
        });

    }

    private void showTimeDialog(Context context){
        final Dialog dialog = new Dialog(context, R.style.more_dialog);
        View rootView = LinearLayout.inflate(context, R.layout.pw_time, null);
        dialog.setContentView(rootView);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setCancelable(true);
        // -----确定和取消按钮
        btnSubmit = rootView.findViewById(R.id.btnSubmit);
        btnCancel = rootView.findViewById(R.id.btnCancel);
        // ----时间转轮
        final View timepickerview = rootView.findViewById(R.id.timepicker);
        ScreenInfo screenInfo = new ScreenInfo(this);
        wheelTime = new WheelTime(timepickerview, com.jly.garfieldprojects.ui.timeselector.TimePopupWindow.Type.ALL);

        wheelTime.screenheight = screenInfo.getHeight();

        //默认选中当前时间
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hours = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        wheelTime.setPicker(year, month, day, hours, minute);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    Date date = WheelTime.dateFormat.parse(wheelTime.getTime());
                    SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
                    String time = format.format(date);

                    timeTv.setText(time);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                dialog.dismiss();

            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
            }
        });

        dialog.show();
    }
}

