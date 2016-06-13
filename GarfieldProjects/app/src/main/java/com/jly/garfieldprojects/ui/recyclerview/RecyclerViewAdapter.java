package com.jly.garfieldprojects.ui.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jly.garfieldprojects.R;
import com.jly.garfieldprojects.constant.AppConstant;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Administrator on 2016/6/12.
 *
 * @author Jingly
 * @version V1.0
 * @classname: ${FILE_NAME}
 * @description: ${TODO}(用一句话描述该文件做什么)
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private Context mContext;
    private ArrayList<String> mDataList;
//    private ArrayList heights;
    private OnClickListener mOnClickListener;
    private DisplayImageOptions options;
    private Random mRandom;

    public RecyclerViewAdapter(Context context, ArrayList<String> dataList) {
        mContext = context;
        mDataList = dataList;
//        getRandomHeight(mDataList);

        options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.drawable.ic_stub)
                .showImageForEmptyUri(R.drawable.ic_empty)
                .showImageOnFail(R.drawable.ic_error)
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .considerExifParams(true)
                .displayer(new RoundedBitmapDisplayer(20))
                .build();

        mRandom = new Random();
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        mOnClickListener = onClickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View chilcView = LayoutInflater.from(mContext).inflate(R.layout.adapter_recyclerview, parent, false);
        MyViewHolder holder = new MyViewHolder(chilcView);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

//        ViewGroup.LayoutParams params =  holder.itemView.getLayoutParams();//得到item的LayoutParams布局参数
//        params.height = (int) heights.get(position);//把随机的高度赋予itemView布局
//        holder.itemView.setLayoutParams(params);//把params设置给itemView布局


//        ViewGroup.LayoutParams lp = holder.tv.getLayoutParams();
//        lp.height = (int) heights.get(position);
//        holder.tv.setLayoutParams(lp);

        holder.tv.setText(mDataList.get(position));
//        if(position == 5){
//            holder.iv.setImageResource(R.drawable.cat2);
//        }else{
//            holder.iv.setImageResource(R.mipmap.ic_launcher);
//        }

        int length = AppConstant.images.length;
        int index = mRandom.nextInt(length);

        ImageLoader.getInstance().displayImage("http://img0.imgtn.bdimg.com/it/u=2596167089,3414172685&fm=11&gp=0.jpg",holder.iv,options);

        if(mOnClickListener != null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnClickListener.onItemClickListener(holder.itemView,pos);
                }
            });

            holder.itemView.setOnLongClickListener(new View.OnLongClickListener(){

                @Override
                public boolean onLongClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnClickListener.onLongItemClickListener(holder.itemView, pos);
                    removeData(pos);
                    return true; //必须返回true,否则会触发onItemClickListener
                }
            });
        }

    }

    private void removeData(int position){
        mDataList.remove(position);
        notifyItemRemoved(position);
    }

//    private void getRandomHeight(List<String> lists){//得到随机item的高度
//        heights = new ArrayList<>();
//        for (int i = 0; i < lists.size(); i++) {
//            heights.add((int)(200+Math.random()*400));
//        }
//    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv;
        ImageView iv;


        public MyViewHolder(View itemView) {
            super(itemView);
            this.tv = (TextView) itemView.findViewById(R.id.content_tv);
            this.iv = (ImageView) itemView.findViewById(R.id.content_iv);
        }
    }

    public interface OnClickListener{
        void onItemClickListener(View view,int position);
        void onLongItemClickListener(View view,int position);
    }
}
