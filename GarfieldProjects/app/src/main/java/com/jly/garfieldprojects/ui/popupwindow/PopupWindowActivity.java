package com.jly.garfieldprojects.ui.popupwindow;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.jly.garfieldprojects.R;

/**
 * Created by Administrator on 2016/5/11.
 *
 * @author Jingly
 * @version V1.0
 * @classname: ${FILE_NAME}
 * @description: ${TODO}弹出popupwindow,类似于ActionBar
 *
 */
public class PopupWindowActivity extends Activity {
    private TitlePopup titlePopup;
    private ImageView mAddIv;
    private RelativeLayout mContentLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popupwindow);

        mContentLayout = (RelativeLayout) findViewById(R.id.contentLayout);
        mAddIv = (ImageView) findViewById(R.id.addIv);
        initPopWindow(this);
        mAddIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                titlePopup.show(v);
                //背景变暗
                WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
                layoutParams.alpha = 0.7f;
                getWindow().setAttributes(layoutParams);

            }
        });


    }

    private void initPopWindow(Context context) {
        // 实例化标题栏弹窗
        titlePopup = new TitlePopup(context, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        titlePopup.setItemOnClickListener(onitemClick);
        // 给标题栏弹窗添加子类
        titlePopup.addAction(new ActionItem(context, "发起群聊"));
        titlePopup.addAction(new ActionItem(context, "添加朋友"));

        //监听消失的接口
        titlePopup.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                // 设置背景恢复，不再变暗
                WindowManager.LayoutParams lp = getWindow().getAttributes();
                lp.alpha = 1.0f;
                getWindow().setAttributes(lp);
            }
        });

    }

    private TitlePopup.OnItemOnClickListener onitemClick = new TitlePopup.OnItemOnClickListener() {

        @Override
        public void onItemClick(ActionItem item, int position) {
            // mLoadingDialog.show();
            switch (position) {
                case 0:// 发起群聊
                    Snackbar.make(mContentLayout,"发起群聊",Snackbar.LENGTH_INDEFINITE).show();
                    break;
                case 1:// 添加朋友
                    Snackbar.make(mContentLayout,"添加朋友",Snackbar.LENGTH_INDEFINITE).show();
                    break;
                default:
                    break;
            }
        }
    };
}
