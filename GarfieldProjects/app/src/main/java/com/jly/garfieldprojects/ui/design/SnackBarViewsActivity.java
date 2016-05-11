package com.jly.garfieldprojects.ui.design;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.jly.garfieldprojects.R;

/**
 * Created by Administrator on 2016/5/11.
 *
 * @author Jingly
 * @version V1.0
 * @classname: ${FILE_NAME}
 * @description: ${TODO}SnackBar通过在屏幕底部展示简洁的信息，
 * 为一个操作提供了一个轻量级的反馈，并且在Snackbar中还可以包含一个操作，
 * 在同一时间内，仅且只能显示一个 Snackbar，它的显示依赖于UI，
 * 不像Toast那样可以脱离应用显示。它的用法和Toast很相似，
 * 唯一不同的就是它的第一个参数不是传入Context而是传入它所依附的父视图，但是他比Toast更强大。

 */
public class SnackBarViewsActivity extends Activity {
    private LinearLayout mContentLayout;
    /**
     * getEditText() 得到控件中包含的 EditText 控件
     setError(CharSequence error) 设置错误信息并显示在 EditText 下方 应用场景：比如用户输错了密码或者用户名等
     setHint(CharSequence hint) 设置提示信息
     setErrorEnabled(boolean enabled) 设置 setError(CharSequence error) 这个函数是否可用
     记住哦：这个函数一定要在 setError(CharSequence error) 这个函数之后执行哦！
     */
    private TextInputLayout mInputLayout1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snackbarviews);

        show();
    }

    private void show() {
        mContentLayout = (LinearLayout) findViewById(R.id.contentLayout);
        mInputLayout1 = (TextInputLayout) findViewById(R.id.inputLayout2);

        mInputLayout1.setError("输入错误");
        mInputLayout1.setErrorEnabled(true);//当设置成false的时候 错误信息不显示 反之显示

//        Snackbar.make(mContentLayout, "SnackBar", Snackbar.LENGTH_INDEFINITE).show();

        Snackbar.make(mContentLayout,"SnackBar Action",Snackbar.LENGTH_INDEFINITE).setAction("Action", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SnackBarViewsActivity.this,"点击Action",Toast.LENGTH_LONG).show();
            }
        }).setActionTextColor(Color.GREEN).show();
    }


}
