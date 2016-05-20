package com.jly.garfieldprojects.ui;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.jly.garfieldprojects.R;

/**
 * Created by Administrator on 2016/5/18.
 *
 * @author Jingly
 * @version V1.0
 * @classname: ${FILE_NAME}
 * @description: ${TODO} drawable 使用微技巧
 * csdn: http://blog.csdn.net/guolin_blog/article/details/50727753
 */
public class DrawableActivity extends Activity {
    private static final String TAG = DrawableActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawable);

        float xdpi = getResources().getDisplayMetrics().xdpi;
        float ydpi = getResources().getDisplayMetrics().ydpi;
        Log.e(TAG,"xdpi ===="+xdpi);
        Log.e(TAG,"ydpi ===="+ydpi);
        /*用命令行
                adb shell wm size 查看手机尺寸
                adb shell wm density  查看手机密度*/
    }

    /**
     *我们当前的场景就是drawable-xxxhdpi文件夹，然后发现这里也没有android_logo这张图，接下来会尝试再找更高密度的文件夹，
     * 发现没有更高密度的了，这个时候会去drawable-nodpi文件夹找这张图，发现也没有，
     * 那么就会去更低密度的文件夹下面找，依次是drawable-xhdpi -> drawable-hdpi -> drawable-mdpi -> drawable-ldpi
     *
     * drawable-nodpi文件夹，这个文件夹是一个密度无关的文件夹，放在这里的图片系统就不会对它进行自动缩放，
     * 原图片是多大就会实际展示多大。但是要注意一个加载的顺序，drawable-nodpi文件夹是在匹配密度文件夹和更高密度文件夹都找不到
     * 的情况下才会去这里查找图片的，
     * 因此放在drawable-nodpi文件夹里的图片通常情况下不建议再放到别的文件夹里面
     *
     * 一张原图片被放大了之后显示就意味着要占用更多的内存了
     *
     * 就目前来讲，最佳放置图片资源的文件夹就是drawable-xxhdp
     */
}
