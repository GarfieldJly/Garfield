package com.jly.garfieldprojects.mediaplayer;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.jly.garfieldprojects.BaseActivity;
import com.jly.garfieldprojects.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/5/11.
 *
 * @author Jingly
 * @version V1.0
 * @classname: ${FILE_NAME}
 * @description: ${TODO} 播放手机里的音乐
 */
public class MediaplayerActivity extends BaseActivity implements View.OnClickListener{
    private static final String TAG = MediaplayerActivity.class.getSimpleName();
    private MediaplayerController mediaplayerController;
    private List<MusicEntity> mList;

    private Button mPlayBtn,mPauseBtn,mResumeBtn,mPreviousBtn,mNextBtn;
    private TextView mStartTv,mEndTv;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mediaplayer);
        initViews();
    }

    private void initViews() {
        mList = getSongs();
        if(mList == null || mList.size() == 0){
            Toast.makeText(this,"list is null",Toast.LENGTH_SHORT).show();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            finish();
        }


        mPlayBtn = getView(R.id.playBtn);
        mPauseBtn = getView(R.id.pauseBtn);
        mResumeBtn = getView(R.id.resumeBtn);
        mPreviousBtn = getView(R.id.previousBtn);
        mNextBtn = getView(R.id.nextBtn);
        mStartTv = getView(R.id.startTv);
        mEndTv = getView(R.id.endTv);
        mProgressBar = getView(R.id.progressBar);

        mediaplayerController = new MediaplayerController(mList,mProgressBar,mEndTv);

        mPlayBtn.setOnClickListener(this);
        mPauseBtn.setOnClickListener(this);
        mResumeBtn.setOnClickListener(this);
        mPreviousBtn.setOnClickListener(this);
        mNextBtn.setOnClickListener(this);

    }

    private List<MusicEntity> getSongs(){
        ArrayList<MusicEntity> list = new ArrayList<MusicEntity>();
        Cursor cursor = getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, null, null, null,
                MediaStore.Audio.Media.DEFAULT_SORT_ORDER);

     //   得到cursor后，我们可以调用Cursor的相关方法具体的音乐信息:
        if (cursor == null) {
            Log.d(TAG, "No music has found!!!!!!" + '\n');
        } else if (cursor.getCount() == 0) {
            Log.d(TAG, "No music has found!!!!!! mCursor.getCount() == 0" + '\n');
        }else{
            int totalCount = cursor.getCount();
            cursor.moveToFirst();
            for (int i = 0;i < totalCount;i++){
                int id = cursor.getInt(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media._ID));
                MusicEntity entity = new MusicEntity();
                entity.setTitle(cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.TITLE)));
                entity.setAlbum(cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ALBUM)));
                entity.setUrl(cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA)));
                entity.setDuration(cursor.getInt(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DURATION)));
                list.add(entity);
                cursor.moveToNext();

            }
        }

/*// 歌曲ID：MediaStore.Audio.Media._ID
        int id =cursor.getInt(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media._ID));

// 歌曲的名称 ：MediaStore.Audio.Media.TITLE
        String tilte =cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.TITLE));

// 歌曲的专辑名：MediaStore.Audio.Media.ALBUM
        String album = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ALBUM));

// 歌曲的歌手名： MediaStore.Audio.Media.ARTIST
        String artist =cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ARTIST));


// 歌曲文件的路径 ：MediaStore.Audio.Media.DATA
        String url = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA));


// 歌曲的总播放时长 ：MediaStore.Audio.Media.DURATION
        int duration =cursor.getInt(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DURATION));


// 歌曲文件的大小 ：MediaStore.Audio.Media.SIZE
        long size = cursor.getLong(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.SIZE));
    */
        return list;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.playBtn:
                mediaplayerController.play(0);
                break;
            case R.id.pauseBtn:
                mediaplayerController.pause();
                break;
            case R.id.resumeBtn:
                mediaplayerController.resume();
                break;
            case R.id.previousBtn:
                mediaplayerController.previous();
                break;
            case R.id.nextBtn:
                mediaplayerController.next();
                break;
        }
    }
}
