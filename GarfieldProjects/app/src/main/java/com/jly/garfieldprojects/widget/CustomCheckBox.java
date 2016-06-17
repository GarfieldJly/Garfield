package com.jly.garfieldprojects.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;

import com.jly.garfieldprojects.R;

/**
 * Created by Administrator on 2016/6/14.
 *
 * @author Jingly
 * @version V1.0
 * @classname: ${FILE_NAME}
 * @description: ${TODO}(用一句话描述该文件做什么)
 */
public class CustomCheckBox extends RelativeLayout implements CompoundButton.OnCheckedChangeListener{
    CheckBox cb;
    public CustomCheckBox(Context context) {
        super(context);

        LayoutInflater.from(context).inflate(R.layout.custom_checkbox, this,true);

        this.cb = (CheckBox)findViewById(R.id.cb);

    }

    public CustomCheckBox(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomCheckBox(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setData(String values,int res){
        cb.setText(values);
        cb.setTextColor(res);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(isChecked){
            cb.setButtonDrawable(R.drawable.flowlayout_button_bg_press);
        }else{
            cb.setButtonDrawable(R.drawable.flowlayout_button_bg_normal);
        }
    }

}
