package com.jly.garfieldprojects.ui;//**

/**
 * User: garfield
 * Date: 2016-05-05
 * Time: 20:17
 * Des: 删除ListView选中的item
 * csdn: http://download.csdn.net/download/u012620150/8660951
 */

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ListView;
import android.widget.TextView;

import com.jly.garfieldprojects.Entity.ItemEntity;
import com.jly.garfieldprojects.R;
import com.jly.garfieldprojects.adapter.DeleteItemAdapter;

import java.util.ArrayList;
import java.util.List;

public class DeleteListViewItemActivity extends Activity implements OnClickListener {
    private ListView lv;
    public CheckBox allCb;
    public Button bSubmit;
    private TextView delete_icon;
    private TextView backTv;
    private RelativeLayout rlBottom;
    private ArrayList<ItemEntity> list;
    private DeleteItemAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_delete_listview_item);
        lv = (ListView) findViewById(R.id.lv);
        allCb = (CheckBox) findViewById(R.id.allCb);
        bSubmit = (Button) findViewById(R.id.bSubmit);
        backTv = (TextView) findViewById(R.id.backTv);
        backTv.setOnClickListener(this);
        rlBottom = (RelativeLayout) findViewById(R.id.rlBottom);
        delete_icon = (TextView) findViewById(R.id.delete_icon);
        delete_icon.setOnClickListener(this);
        initData();

        allCb.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if (!allCb.isChecked()) {
                    for (ItemEntity entity : list) {
                        entity.setChecked(false);
                    }
                    adapter.notifyDataSetChanged();
                }

            }
        });

        allCb.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
                if (arg1) {
                    for (ItemEntity entity : list) {
                        entity.setChecked(true);
                    }
                    adapter.notifyDataSetChanged();
                }
            }
        });


        bSubmit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                boolean flag = false;
                deleteMsg();
                if (!flag) {
                    return;
                }
                allCb.setVisibility(View.GONE);
                rlBottom.setVisibility(View.GONE);
            }
        });
        adapter = new DeleteItemAdapter(this, list);
        lv.setAdapter(adapter);
    }

    @Override
    public void onClick(View arg0) {
        switch (arg0.getId()) {
            case R.id.delete_icon:
                if (allCb.getVisibility() == View.GONE) {
                    rlBottom.setVisibility(View.VISIBLE);
                    allCb.setVisibility(View.VISIBLE);
                    delete_icon.setText("完成");
                    for (ItemEntity entity : list) {
                        entity.setChecked(true);
                    }
                } else {
                    delete_icon.setText("清理");
                    rlBottom.setVisibility(View.GONE);
                    allCb.setVisibility(View.GONE);
                }

                adapter.notifyDataSetChanged();

                break;
            case R.id.backTv:
                this.finish();
                break;
            default:
                break;
        }
    }

    public void initData() {
        list = new ArrayList<ItemEntity>();

        list.add(new ItemEntity(false, "aaaa1"));
        list.add(new ItemEntity(false, "aaaa2"));
        list.add(new ItemEntity(false, "aaaa3"));
        list.add(new ItemEntity(false, "aaaa4"));
        list.add(new ItemEntity(false, "aaaa5"));
        list.add(new ItemEntity(false, "aaaa6"));
        list.add(new ItemEntity(false, "aaaa7"));
        list.add(new ItemEntity(false, "aaaa8"));
        list.add(new ItemEntity(false, "aaaa9"));
        list.add(new ItemEntity(false, "aaaa10"));
        list.add(new ItemEntity(false, "aaaa11"));
        list.add(new ItemEntity(false, "aaaa12"));
        list.add(new ItemEntity(false, "aaaa13"));
        list.add(new ItemEntity(false, "aaaa14"));
        list.add(new ItemEntity(false, "aaaa15"));
        list.add(new ItemEntity(false, "aaaa16"));
        list.add(new ItemEntity(false, "aaaa17"));
        list.add(new ItemEntity(false, "aaaa18"));
        list.add(new ItemEntity(false, "aaaa19"));
        list.add(new ItemEntity(false, "aaaa20"));
        list.add(new ItemEntity(false, "aaaa21"));
        list.add(new ItemEntity(false, "aaaa22"));
        list.add(new ItemEntity(false, "aaaa23"));
        list.add(new ItemEntity(false, "aaaa24"));

    }

    public void deleteMsg() {
        List<ItemEntity> deleteList = new ArrayList<ItemEntity>();
        for (ItemEntity entity : list) {
            // (1-已读 0-未读)
            if (entity.isChecked()) {
                deleteList.add(entity);
            }
        }
        list.removeAll(deleteList);

        adapter.setList(list);
        adapter.notifyDataSetChanged();
    }
}

