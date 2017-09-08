package com.example.gebruiker.drumioremastered.fragments;

import android.content.Context;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;

import com.example.gebruiker.drumioremastered.eventbus.MessageEvent;
import com.example.gebruiker.drumioremastered.R;

import com.example.gebruiker.drumioremastered.drumPlayer.soundPlayer;
import com.example.gebruiker.drumioremastered.noteContainers.noteContainer;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Gebruiker on 4-9-2017.
 */

public class four_division_fragment extends Fragment {

    @BindView(R.id.hh1)
    ImageView hh1;
    @BindView(R.id.hh2)
    ImageView hh2;
    @BindView(R.id.hh3)
    ImageView hh3;
    @BindView(R.id.hh4)
    ImageView hh4;

    @BindView(R.id.snare1)
    ImageView snare1;
    @BindView(R.id.snare2)
    ImageView snare2;
    @BindView(R.id.snare3)
    ImageView snare3;
    @BindView(R.id.snare4)
    ImageView snare4;

    private noteContainer noteContainer;
    private soundPlayer player;


    private void playNotes(int i) {


        if (noteContainer.getHihatContainer().getNoteState(i))
            player.playeHihat();

        if (noteContainer.getSnareContainer().getNoteState(i))
            player.playSnare();


    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.four_division_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onStart() {
        EventBus.getDefault().register(this);
        super.onStart();

    }

    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        player = new soundPlayer(getContext());
        noteContainer = new noteContainer();


    }

    @OnClick({R.id.hh1, R.id.hh2, R.id.hh3, R.id.hh4})
    public void hihatClicked(View view) {
        switch (view.getId()) {

            case R.id.hh1:
                if (noteContainer.getHihatContainer().getNoteState(0)) {
                    hh1.setColorFilter(Color.GRAY);
                } else {
                    hh1.setColorFilter(Color.BLACK);
                }

                noteContainer.getHihatContainer().changeNoteState(0);

                break;

            case R.id.hh2:
                if (noteContainer.getHihatContainer().getNoteState(1)) {
                    hh2.setColorFilter(Color.GRAY);
                } else {
                    hh2.setColorFilter(Color.BLACK);
                }
                noteContainer.getHihatContainer().changeNoteState(1);


                break;

            case R.id.hh3:
                if (noteContainer.getHihatContainer().getNoteState(2)) {
                    hh3.setColorFilter(Color.GRAY);
                } else {
                    hh3.setColorFilter(Color.BLACK);
                }

                noteContainer.getHihatContainer().changeNoteState(2);

                break;

            case R.id.hh4:
                if (noteContainer.getHihatContainer().getNoteState(3)) {
                    hh4.setColorFilter(Color.GRAY);
                } else {
                    hh4.setColorFilter(Color.BLACK);
                }

                noteContainer.getHihatContainer().changeNoteState(3);

                break;

            default:
                break;

        }
    }

    @OnClick({R.id.snare1, R.id.snare2, R.id.snare3, R.id.snare4})
    public void snareClicked(View view) {
        switch (view.getId()) {

            case R.id.snare1:
                if (noteContainer.getSnareContainer().getNoteState(0)) {
                    snare1.setColorFilter(Color.GRAY);
                } else {
                    snare1.setColorFilter(Color.BLACK);
                }

                noteContainer.getSnareContainer().changeNoteState(0);

                break;

            case R.id.snare2:
                if (noteContainer.getSnareContainer().getNoteState(1)) {
                    snare2.setColorFilter(Color.GRAY);
                } else {
                    snare2.setColorFilter(Color.BLACK);
                }

                noteContainer.getSnareContainer().changeNoteState(1);

                break;

            case R.id.snare3:
                if (noteContainer.getSnareContainer().getNoteState(2)) {
                    snare3.setColorFilter(Color.GRAY);
                } else {
                    snare3.setColorFilter(Color.BLACK);
                }

                noteContainer.getSnareContainer().changeNoteState(2);

                break;

            case R.id.snare4:
                if (noteContainer.getSnareContainer().getNoteState(3)) {
                    snare4.setColorFilter(Color.GRAY);
                } else {
                    snare4.setColorFilter(Color.BLACK);
                }

                noteContainer.getSnareContainer().changeNoteState(3);

                break;

            default:
                break;

        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onPlayButtonClicked(MessageEvent event) {

        Timer timer = new Timer();
        final Handler handler = new Handler();
        TimerTask task = new TimerTask() {

            int i = 0;

            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        playNotes(i);
                        i++;

                        if (i == 4)
                            i = 0;

                    }
                });

            }
        };

        timer.schedule(task, 0, 500);


    }

}
