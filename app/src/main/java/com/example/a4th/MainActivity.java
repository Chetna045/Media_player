package com.example.a4th;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
int starttime=0,stoptime=0;
int forewardtime=5000, backwardtime=5000;
MediaPlayer mediaPlayer,mediaPlayernew;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer=MediaPlayer.create(this,R.raw.first);
        mediaPlayernew = MediaPlayer.create(this,R.raw.first);
        TextView songtitle=findViewById(R.id.song);
        songtitle.setText("Song");
        Button play=findViewById(R.id.Play);
        play.setOnClickListener(new View.OnClickListener(){
            @Override

            public void onClick(View v)

            {

                Toast.makeText(getApplicationContext(),"Playing Song",Toast.LENGTH_SHORT).show();

                mediaPlayer.start();


            }

        });


        Button pause = findViewById(R.id.Pause);
        pause.setOnClickListener(new View.OnClickListener(){
            @Override

            public void onClick(View v)

            {

                Toast.makeText(getApplicationContext(),"Pausing",Toast.LENGTH_LONG).show(); mediaPlayer.pause();
            }
        });
        Button forward = findViewById(R.id.Forward);
        forward.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                int currentpos = mediaPlayer.getCurrentPosition();

                if ((currentpos + forewardtime) <= (stoptime = mediaPlayer.getDuration())) {
                    mediaPlayer.seekTo(currentpos + forewardtime);

                }

            }

        });
        Button backward = findViewById(R.id.Back);
        backward.setOnClickListener(new View.OnClickListener(){
            @Override

            public void onClick(View v) {

                int currentpos = mediaPlayer.getCurrentPosition();
                if ((currentpos - backwardtime) >= 0) {
                    mediaPlayer.seekTo(currentpos - backwardtime);
                }
            }

        });

        Button stop = findViewById(R.id.Stop);
        stop.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),"Stopping song",Toast.LENGTH_LONG).show();
                mediaPlayer.stop();
                mediaPlayer = mediaPlayernew;

            }

        });
        Button restart = findViewById(R.id.Restart);
        restart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),"Stopping song",Toast.LENGTH_LONG).show();
                mediaPlayer.seekTo(0);
                mediaPlayer.start();

            }

        });


    }
}