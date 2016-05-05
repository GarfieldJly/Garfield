package com.jly.garfieldprojects.adapter;//**

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.jly.garfieldprojects.Entity.ItemEntity;
import com.jly.garfieldprojects.R;
import com.jly.garfieldprojects.ui.DeleteListViewItemActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * User: garfield
 * Date: 2016-05-05
 * Time: 20:21
 * Des:
 */
public class DeleteItemAdapter extends BaseAdapter{
    private DeleteListViewItemActivity activity;
    private ArrayList<ItemEntity> list;
    private LayoutInflater inflater;
    public DeleteItemAdapter(DeleteListViewItemActivity mContext,List<ItemEntity> list){
        this.activity = mContext;
        this.list = (ArrayList<ItemEntity>) list;

    }

    public ArrayList<ItemEntity> getList() {
        return list;
    }
    public void setList(ArrayList<ItemEntity> list) {
        this.list = list;
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return list.size();
    }

    @Override
    public Object getItem(int arg0) {
        // TODO Auto-generated method stub
        return arg0;
    }

    @Override
    public long getItemId(int arg0) {
        // TODO Auto-generated method stub
        return arg0;
    }

    @Override
    public View getView(int arg0, View convertView, ViewGroup arg2) {
        inflater = LayoutInflater.from(activity);
        holder h = null;
        if(convertView == null){
            h = new holder();
            convertView = inflater.inflate(R.layout.adapter_delete_item, null);
            h.checkBox = (CheckBox) convertView.findViewById(R.id.checkBox);
            h.contentTv = (TextView) convertView.findViewById(R.id.contentTv);
            convertView.setTag(h);
        }else{
            h = (holder) convertView.getTag();
        }

        final ItemEntity entity = list.get(arg0);
        h.contentTv.setText(entity.getContent());

        if(activity.allCb.getVisibility() == View.VISIBLE){
            h.checkBox.setVisibility(View.VISIBLE);
        }else{
            h.checkBox.setVisibility(View.GONE);
        }

        h.checkBox.setChecked(entity.isChecked());
        h.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton arg0, boolean isChecked) {
                if(!isChecked){
                    activity.allCb.setChecked(false);
                }

                entity.setChecked(isChecked);
                notifyDataSetChanged();

                if(isChecked){
                    selectConut();
                    if(selectConut==list.size()){
                        activity.allCb.setChecked(true);
                    }
                }

                if(changeState()){
                    activity.bSubmit.setEnabled(true);
                    activity.bSubmit.setBackgroundColor(Color.parseColor("#ff3933"));
                }else{
                    activity.bSubmit.setEnabled(false);
                    activity.bSubmit.setBackgroundColor(Color.parseColor("#B1B1B1"));
                }
            }
        });

        return convertView;
    }

    class holder{
        private CheckBox checkBox;
        private TextView contentTv;
    }

    public  int selectConut=0;
    public void selectConut() {
        selectConut=0;
        for (ItemEntity entity : list) {
            if(entity.isChecked()){
                selectConut++;
            }
        }
    }

    public boolean changeState(){
        for(ItemEntity entity:list){
            if(entity.isChecked()){
                return true;
            }
        }
        return false;
    }
}
