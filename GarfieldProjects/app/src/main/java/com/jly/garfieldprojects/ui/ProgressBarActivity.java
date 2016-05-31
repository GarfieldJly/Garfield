package com.jly.garfieldprojects.ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

import com.jly.garfieldprojects.R;


/**
 * Created by Administrator on 2016/5/31.
 *
 * @author Jingly
 * @version V1.0
 * @classname: ${FILE_NAME}
 * @description: $ 每隔一秒，更新ProgressBar的进度
 */
public class ProgressBarActivity extends Activity {
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progressbar);

        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);

        mHandler.post(mRunnable);
    }

    Handler mHandler = new Handler();

    Runnable mRunnable = new Runnable() {
        @Override
        public void run() {

            if (mProgressBar.getProgress() < mProgressBar.getMax()) {
                mProgressBar.setProgress(mProgressBar.getProgress() + 1);
                mHandler.postDelayed(mRunnable, 1000);
            }
        }
    };
}
