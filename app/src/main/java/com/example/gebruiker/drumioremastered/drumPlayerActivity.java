package com.example.gebruiker.drumioremastered;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;


import com.example.gebruiker.drumioremastered.eventbus.MessageEvent;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class drumPlayerActivity extends AppCompatActivity {

    @BindView(R.id.playButton)
    Button playButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


    }



    @OnClick(R.id.playButton)
    public void playClicked(){

        EventBus.getDefault().post(new MessageEvent());
    }



}
