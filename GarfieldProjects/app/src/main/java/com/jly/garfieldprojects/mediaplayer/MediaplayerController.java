package com.jly.garfieldprojects.mediaplayer;

import android.media.MediaPlayer;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2016/5/11.
 *
 * @author Jingly
 * @version V1.0
 * @classname: ${FILE_NAME}
 * @description: ${TODO}(用一句话描述该文件做什么)
 */
public class MediaplayerController implements MediaPlayer.OnCompletionListener {
    private static final String TAG = MediaplayerController.class.getSimpleName();
    private MediaPlayer mediaPlayer;
    private List<MusicEntity> mList;
    private ProgressBar mProgressBar;
    private TextView mTotalTv;
    private int index = 0;

    public MediaplayerController(List<MusicEntity> list,ProgressBar progressBar,TextView totalTv) {

        this.mList = list;
        this.mProgressBar = progressBar;
        this.mTotalTv = totalTv;
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setOnCompletionListener(this);

    }

    public void play(int position) {
        if (mediaPlayer != null) {
            try {
                Log.i(TAG, "musicEntity.getUrl() = " + mList.get(1).getUrl());
                mediaPlayer.reset();
                mediaPlayer.setDataSource(mList.get(index).getUrl());
                mediaPlayer.prepare();
                mediaPlayer.start();
                mTotalTv.setText(((float)mList.get(index).getDuration())/1000+"");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void pause(){
        if(mediaPlayer != null){
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.pause(); //播放音乐
            }
        }
    }

    public void resume(){
        if(mediaPlayer != null){
            if (!mediaPlayer.isPlaying()) {
                mediaPlayer.start();
            }
        }
    }

    public void stop(){
        if(mediaPlayer != null){
            mediaPlayer.stop();
        }
    }

    public void next(){
        index++;
        if(index < mList.size()){
            play(index);
        }else{
            index = 0;
            play(index);
        }
    }

    public void previous(){
        if(index > 0){
            index--;
            play(index);
        }else{
            index = mList.size()-1;
            play(index);
        }
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        index++;
        if(index < mList.size()){
            play(index);
        }
    }
}
