package com.example.musicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnplay,btnnext,btnprevious,btnff,btnfr;
    TextView tvsongname,tvstart,tvstop;
    SeekBar seekmusic;

    String song_name;
    public static final String EXTRA_NAME="song_name";
    static MediaPlayer mediaPlayer;
    int position;
    ArrayList<File> mysongs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnprevious=findViewById(R.id.btnprevious);
        btnnext=findViewById(R.id.btnnext);
        btnplay=findViewById(R.id.playbtn);
        btnff=findViewById(R.id.btnff);
        btnfr=findViewById(R.id.btnfr);
        tvsongname=findViewById(R.id.tvsongname);
        tvstop=findViewById(R.id.tvstop);
        seekmusic=findViewById(R.id.seekbar);

        if(mediaPlayer !=null){
            mediaPlayer.stop();
            mediaPlayer.release();
        }
        Intent i=getIntent();
        Bundle bundle=i.getExtras();

        mysongs=(ArrayList)bundle.getParcelableArrayList("songs"); // key song get on the songlist
        String songname=i.getStringExtra("songname"); // songname get on the songlist
        position=bundle.getInt("pos",0);
        tvsongname.setSelected(true);
        Uri uri=Uri.parse(mysongs.get(position).toString());
        song_name=mysongs.get(position).getName();
        tvsongname.setText(song_name);

        mediaPlayer=MediaPlayer.create(getApplicationContext(),uri);
        mediaPlayer.start();

        btnplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mediaPlayer.isPlaying()){
                    btnplay.setBackgroundResource(R.drawable.ic_play);
                    mediaPlayer.pause();
                }
                else {
                    btnplay.setBackgroundResource(R.drawable.ic_pause);
                    mediaPlayer.start();
                }
            }
        });
    }

}