package com.jly.garfieldprojects.ui.viewpager;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jly.garfieldprojects.R;
import com.zhy.magicviewpager.transformer.AlphaPageTransformer;
import com.zhy.magicviewpager.transformer.RotateDownPageTransformer;
import com.zhy.magicviewpager.transformer.ScaleInTransformer;

/**
 * Created by Administrator on 2016/5/10.
 *
 * @author Jingly
 * @version V1.0
 * @classname: ${FILE_NAME}
 * @description: ${TODO} ViewPager一屏显示多个页面
 * csdn :http://blog.csdn.net/lmj623565791/article/details/51339751
 */
public class ChangeableViewpagerActivity extends Activity {
    private ViewPager mViewPager;
    private Integer[] resources = new Integer[]{R.drawable.cat1,R.drawable.cat2,R.drawable.cat3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changeable_viewpager);
        initViews();
    }

    private void initViews() {
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mViewPager.setPageMargin(40); //设置Page间间距
        mViewPager.setOffscreenPageLimit(3); //设置缓存的页面数量 >=3
        mViewPager.setAdapter(new MyPagerAdapter());
        // 依赖的是 compile 'com.zhy:magic-viewpager:1.0.1' 的动画效果
/**
 //setPageTransformer 决定动画效果
 mViewPager.setPageTransformer(true, new
 RotateDownPageTransformer());
 目前可选动画

 AlphaPageTransformer
 RotateDownPageTransformer
 RotateUpPageTransformer
 RotateYTransformer
 NonPageTransformer
 ScaleInTransformer
 动画间可以自由组合，例如：

 mViewPager.setPageTransformer(true,
 new RotateDownPageTransformer(new AlphaPageTransformer(new ScaleInTransformer())));
 */
        mViewPager.setPageTransformer(true,new RotateDownPageTransformer(new AlphaPageTransformer(new ScaleInTransformer()))); //setPageTransformer 决定动画效果
    }

    class  MyPagerAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return resources.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {

            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView iv = new ImageView(ChangeableViewpagerActivity.this);
            iv.setImageResource(resources[position]);
            container.addView(iv);
            return iv;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View)object);
        }
    }

}
