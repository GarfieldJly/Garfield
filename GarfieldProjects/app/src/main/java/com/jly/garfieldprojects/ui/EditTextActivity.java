package com.jly.garfieldprojects.ui;//**

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import com.jly.garfieldprojects.R;

/**
 * User: garfield
 * Date: 2016-05-05
 * Time: 18:34
 * Des: EditText设置密码
 * csdn 地址：http://blog.csdn.net/u012620150/article/details/46647463
 */
public class EditTextActivity extends Activity{
    private EditText et;
    private ImageView iv1;
    private ImageView iv2;
    private ImageView iv3;
    private ImageView iv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edittext);

        initViews();
        setImageView(0);
        et.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
                int num = Integer.valueOf(et.getText().toString().trim().length());
                setImageView(num);

            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                          int arg3) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {
            }
        });
    }

    private void initViews(){
         et = (EditText) findViewById(R.id.et);
        iv1 = (ImageView) findViewById(R.id.pwdIv1);
        iv2 = (ImageView) findViewById(R.id.pwdIv2);
        iv3 = (ImageView) findViewById(R.id.pwdIv3);
        iv4 = (ImageView) findViewById(R.id.pwdIv4);

    }

    @Override
    protected void onResume() {
        super.onResume();
        mHandler.post(mRunnable);
    }

    private Handler mHandler = new Handler();

    int i = 0;
    Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            i++;
            if(i > 2){
                mHandler.removeCallbacks(mRunnable);
                return;
            }

            ((InputMethodManager)getSystemService(INPUT_METHOD_SERVICE))
                    .showSoftInput(et, 0);
            mHandler.postDelayed(mRunnable, 200);
        }
    };

    private void setImageView(int num){
        iv1.setImageBitmap(null);
        iv2.setImageBitmap(null);
        iv3.setImageBitmap(null);
        iv4.setImageBitmap(null);

        switch (num) {
            case 1:
                iv1.setImageResource(R.drawable.pwd_img_icon);
                break;
            case 2:
                iv1.setImageResource(R.drawable.pwd_img_icon);
                iv2.setImageResource(R.drawable.pwd_img_icon);
                break;
            case 3:
                iv1.setImageResource(R.drawable.pwd_img_icon);
                iv2.setImageResource(R.drawable.pwd_img_icon);
                iv3.setImageResource(R.drawable.pwd_img_icon);
                break;
            case 4:
                iv1.setImageResource(R.drawable.pwd_img_icon);
                iv2.setImageResource(R.drawable.pwd_img_icon);
                iv3.setImageResource(R.drawable.pwd_img_icon);
                iv4.setImageResource(R.drawable.pwd_img_icon);
                break;
            default:
                break;
        }
    }
}
