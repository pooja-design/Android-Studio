package com.example.mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.first);

        int time=3000;

        Button play = findViewById(R.id.Play);
        Button pause = findViewById(R.id.pause);
        Button restart = findViewById(R.id.restart);
        Button forward = findViewById(R.id.forward);
        Button backward = findViewById(R.id.backward);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Playing the song", Toast.LENGTH_SHORT).show();
                mediaPlayer.start();
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mediaPlayer.pause();
            }
        });

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.seekTo(0);
//                mediaPlayer.start();
            }
        });

        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int total = mediaPlayer.getDuration();
                int current = mediaPlayer.getCurrentPosition();

                if((current+time)<=total){
                    mediaPlayer.seekTo(current+time);
                }
                else{
                    mediaPlayer.seekTo(0);
                }
            }
        });
        backward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int current = mediaPlayer.getCurrentPosition();

                if((current-time)>=0){
                    mediaPlayer.seekTo(current-time);
                }
                else{
                    mediaPlayer.seekTo(0);
                }
            }
        });

    }

}