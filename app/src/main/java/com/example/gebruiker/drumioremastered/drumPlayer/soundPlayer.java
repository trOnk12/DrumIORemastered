package com.example.gebruiker.drumioremastered.drumPlayer;

import android.content.Context;
import android.media.MediaPlayer;

import com.example.gebruiker.drumioremastered.R;

/**
 * Created by Gebruiker on 6-9-2017.
 */

public class soundPlayer {

    private MediaPlayer hihatPlayer,snarePlayer;
    private Context context;

    public soundPlayer(Context context){

        this.context = context;
        hihatPlayer= MediaPlayer.create(context, R.raw.hihat);
        hihatPlayer.setLooping(false);
        snarePlayer= MediaPlayer.create(context,R.raw.snare);
        snarePlayer.setLooping(false);

    }

    public  void playeHihat(){
        hihatPlayer.seekTo(0);
        hihatPlayer.start();
    }

    public  void playSnare(){
        snarePlayer.seekTo(0);
        snarePlayer.start();
    }



}
