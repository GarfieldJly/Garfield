package com.jly.garfieldprojects.ui.refreshlistview;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.jly.garfieldprojects.R;
import com.jly.garfieldprojects.utils.ULog;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qbw
 * @createtime 2016/05/18 16:29
 */


public class RefreshListViewActivity extends Activity implements RefreshLoadMoreLayout.CallBack {
    protected ListView mListview;
    protected RefreshLoadMoreLayout mRefreshloadmore;
    protected Adapter mAdapter;
    protected Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_refreshlistview);
        initView();
    }

    private void initView() {
        mListview = (ListView) findViewById(R.id.listview);
        mListview.setAdapter(mAdapter = new Adapter(this));
        mListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ULog.v("click:" + position);
            }
        });
        mRefreshloadmore = (RefreshLoadMoreLayout) findViewById(R.id.refreshloadmore);

        mRefreshloadmore.init(new RefreshLoadMoreLayout.Config(this).showLastRefreshTime(RefreshListViewActivity.class).autoLoadMore());
    }

    @Override
    public void onRefresh() {
        ULog.v("onRefresh");
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                long time = System.currentTimeMillis();
                mAdapter.clear();
                for (int i = 0; i < 10; i++) {
                    mAdapter.addItem(0, time - i + "");
                }
                mRefreshloadmore.stopRefresh();
            }
        }, 5000);

    }

    @Override
    public void onLoadMore() {
        ULog.v("onLoadMore");
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                long time = System.currentTimeMillis();
                for (int i = 0; i < 10; i++) {
                    mAdapter.addItem(time + i + "");
                }
                mRefreshloadmore.stopLoadMore();
            }
        }, 5000);
    }

    public static class Adapter extends BaseAdapter {
        private Context mContext;
        private List<String> mStringList = new ArrayList<>();

        public Adapter(Context context) {
            mContext = context;
        }

        public void addItem(String item) {
            mStringList.add(item);
            notifyDataSetChanged();
        }

        public void clear(){
            mStringList.clear();
            notifyDataSetChanged();
        }
        public void addItem(int pos, String item) {
            mStringList.add(pos, item);
            notifyDataSetChanged();
        }

        @Override
        public int getCount() {
            return mStringList.size();
        }

        @Override
        public String getItem(int position) {
            return mStringList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if (null == convertView) {
                convertView = LayoutInflater.from(mContext).inflate(R.layout.adapter_item, parent, false);
                convertView.setTag(viewHolder = new ViewHolder(convertView));
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.mTv.setText(getItem(position));
            return convertView;
        }

        class ViewHolder {
            protected TextView mTv;

            ViewHolder(View rootView) {
                initView(rootView);
            }

            private void initView(View rootView) {
                mTv = (TextView) rootView.findViewById(R.id.tv);
            }
        }
    }
}
