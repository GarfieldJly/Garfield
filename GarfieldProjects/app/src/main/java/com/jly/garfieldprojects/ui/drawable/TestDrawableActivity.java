package com.jly.garfieldprojects.ui.drawable;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.jly.garfieldprojects.R;

/**
 * Created by Administrator on 2016/6/8.
 *
 * @author Jingly
 * @version V1.0
 * @classname: ${FILE_NAME}
 * @description: ${TODO}(用一句话描述该文件做什么)
 */
public class TestDrawableActivity extends Activity {
    private static final String TAG = TestDrawableActivity.class.getSimpleName();
    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawable_test);
        initView();
    }

    private void initView() {
        iv = (ImageView) findViewById(R.id.iv);
        iv.setImageBitmap(decodeSampleBitmapFromResource(getResources(),R.drawable.cat3,60,60));

    }

    private Bitmap decodeSampleBitmapFromResource(Resources res,int resId,int width,int height){
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res,resId,options);
        options.inSampleSize = calculateInSampleSize(options,width,height);
        Log.i(TAG,"inSampleSize ===="+options.inSampleSize);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res,resId,options);
    }

    public static int calculateInSampleSize(BitmapFactory.Options options,int reqWidth,int reqHeight){
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;
        if(height > reqHeight || width > reqWidth){
            final int halfHeight = height/2;
            final int haleWidth = width/2;
            while (((halfHeight/inSampleSize) >= reqHeight) &&  ((haleWidth/inSampleSize) >= reqWidth) ){
                inSampleSize *= 2;
            }
        }
        return inSampleSize;
    }
}
