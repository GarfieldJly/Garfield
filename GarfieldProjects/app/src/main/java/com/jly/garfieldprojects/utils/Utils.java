package com.jly.garfieldprojects.utils;

import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2016/6/12.
 *
 * @author Jingly
 * @version V1.0
 * @classname: ${FILE_NAME}
 * @description: ${TODO}  方法的集合
 */
public class Utils {

    /**
     * 设置View 的间隔
     */
    public static void setMargins(View v, int l, int t, int r, int b) {
        if (v.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) v
                    .getLayoutParams();
            p.setMargins(l, t, r, b);
            v.requestLayout();
        }
    }
}
