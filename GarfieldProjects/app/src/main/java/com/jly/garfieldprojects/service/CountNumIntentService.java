package com.jly.garfieldprojects.service;

import android.annotation.TargetApi;
import android.app.IntentService;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

/**
 * Created by Administrator on 2016/6/27.
 *
 * @author Jingly
 * @version V1.0
 * @classname: ${FILE_NAME}
 * @description: ${TODO}(用一句话描述该文件做什么)
 */
public class CountNumIntentService extends IntentService {

    private static final String TAG = CountNumIntentService.class.getSimpleName();
    public CountNumIntentService() {
        super("CountNumIntentService");
    }


    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    protected void onHandleIntent(Intent intent) {
        Log.i(TAG,"调用 IntentService开始");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.i(TAG,"调用 IntentService结束");

        if(intent.getStringExtra("type").equals("op1")){
            Log.i(TAG,"调用 IntentService,,type = +op1");
        }else{
            Log.i(TAG,"调用 IntentService,,type = +op2");
        }


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"调用 IntentService 的onDestroy");
    }
}
