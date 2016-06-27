package com.jly.garfieldprojects.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.jly.garfieldprojects.service.CountNumIntentService;

/**
 * Created by Administrator on 2016/6/27.
 *
 * @author Jingly
 * @version V1.0
 * @classname: ${FILE_NAME}
 * @description: ${TODO}启动Service的广播
 */
public class CountNumReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent intent1 = new Intent(context, CountNumIntentService.class);
        context.startService(intent1);
    }
}
