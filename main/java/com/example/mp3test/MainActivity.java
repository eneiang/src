package com.example.mp3test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mp3Player;
    private Button button;
    private Button stopButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.button);
        stopButton = (Button)findViewById(R.id.button2);
        mp3Player = new MediaPlayer();
        mp3Player = MediaPlayer.create(MainActivity.this, R.raw.test);
// 播放器跟音乐关联起来

        mp3Player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
             System.out.println("完成。");
                button.setEnabled(true);//“播放”按钮可用
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mp3Player.isPlaying() ) {
                    mp3Player.pause();//暂停播放
                    button.setEnabled(true);//“播放”按钮可用
                } else {
                   play();
                   stopButton.setEnabled(true);
                    button.setEnabled(false);//“播放”按钮不可用
                }
            }
        });
        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setEnabled(true);
                mp3Player.pause();
                stopButton.setEnabled(false);//“播放”按钮可用
            }
        });
    }

    private void play() {
        try {
            System.out.println("正在播放.....");
            mp3Player.start();
            button.setEnabled(true);//“播放”按钮可用
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
