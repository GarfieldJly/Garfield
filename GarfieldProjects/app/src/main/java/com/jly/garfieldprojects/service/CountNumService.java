package com.jly.garfieldprojects.service;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.util.Log;

import com.jly.garfieldprojects.broadcast.CountNumReceiver;

/**
 * Created by Administrator on 2016/6/23.
 *
 * @author Jingly
 * @version V1.0
 * @classname: ${FILE_NAME}
 * @description: ${TODO} 计数的Service
 */
public class CountNumService extends Service {
    private static final String TAG = CountNumService.class.getSimpleName();

    private int mCount = 0;
    private boolean isGoing;
    private CountService cs;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i("TAG", "调用 onBind~~~~~~~~~~~~~~~~");
        return cs;
    }

    public class CountService extends Binder {
        public CountNumService getService(){
            return CountNumService.this;
        }
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i("TAG", "调用 onUnbind~~~~~~~~~~~~~~~~");
        return super.onUnbind(intent);
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "调用  onStartCommand ======== ");
       /* try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.i(TAG, "调用  休眠结束 ======== ");*/

        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.i(TAG, "调用  onStartCommand结束 ======== ");
            }
        }).start();
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        long timeDelay = SystemClock.elapsedRealtime()+60*1000;
        Intent intent1 = new Intent(this, CountNumReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent1, 0);
        alarmManager.setExact(AlarmManager.ELAPSED_REALTIME_WAKEUP, timeDelay, pendingIntent);

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        new Thread(new Runnable() {

            @Override
            public void run() {
                while (!isGoing) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                    mCount++;
                    Log.v(TAG, "mCount is " + mCount);
                }
            }
        }).start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"调用 onDestroy");
        isGoing = true;

    }


}
