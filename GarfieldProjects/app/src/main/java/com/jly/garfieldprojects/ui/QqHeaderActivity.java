package com.jly.garfieldprojects.ui;//**

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.jly.garfieldprojects.R;

import java.util.ArrayList;

import cn.kongnannan.circularavatar.CircularImageView;

/**
 * User: garfield
 * Date: 2016-05-05
 * Time: 17:08
 * Des: Android 群组头像，仿QQ
 */
public class QqHeaderActivity extends Activity {
    private CircularImageView mCircularImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qqheader);

        initViews();
    }

    private void initViews(){
        mCircularImageView = (CircularImageView) findViewById(R.id.circularImageView);
        ArrayList<Bitmap> bitmaps = new ArrayList<Bitmap>();
        bitmaps.add(((BitmapDrawable) getResources().getDrawable(R.mipmap.ic_launcher)).getBitmap());
        bitmaps.add(((BitmapDrawable) getResources().getDrawable(R.mipmap.ic_launcher)).getBitmap());
        bitmaps.add(((BitmapDrawable) getResources().getDrawable(R.mipmap.ic_launcher)).getBitmap());
        bitmaps.add(((BitmapDrawable) getResources().getDrawable(R.mipmap.ic_launcher)).getBitmap());
        bitmaps.add(((BitmapDrawable) getResources().getDrawable(R.mipmap.ic_launcher)).getBitmap());
        mCircularImageView.setImageBitmaps(bitmaps);
    }
}
