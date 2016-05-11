package com.jly.garfieldprojects;

import android.app.Activity;
import android.view.View;

import com.jly.garfieldprojects.utils.ViewUtils;

/**
 * Created by Administrator on 2016/5/11.
 *
 * @author Jingly
 * @version V1.0
 * @classname: ${FILE_NAME}
 * @description: ${TODO}(用一句话描述该文件做什么)
 */
public class BaseActivity extends Activity {
    public <E extends View> E getView(int resId) {
        return ViewUtils.findViewById(this, resId);
    }
}
