package com.example.mp3test;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity implements SurfaceHolder.Callback {
    private Button btn;
    private SurfaceView surfaceView;
    private MediaPlayer mp;
    private SurfaceHolder mSurfaceHolder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btn=(Button)findViewById(R.id.button3);

        surfaceView =(SurfaceView)findViewById(R.id.surfaceView);
        mp=new MediaPlayer();
        mp= MediaPlayer.create(this,R.raw.demo);
        mSurfaceHolder = surfaceView.getHolder();
        mSurfaceHolder.addCallback((SurfaceHolder.Callback) this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
            }
        });
    }
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        mp.setDisplay(holder);//给mMediaPlayer添加预览的SurfaceHolder
    }
    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    }
    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
    }
}
