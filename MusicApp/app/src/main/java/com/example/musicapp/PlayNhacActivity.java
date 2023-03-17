package com.liem.musicapp.activities;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.liem.musicapp.R;
import com.liem.musicapp.adapters.ViewPagerAdapterPlayNhac;
import com.liem.musicapp.fragments.DiaNhacFragment;
import com.liem.musicapp.fragments.PlayDanhSachBaiHatFragment;
import com.liem.musicapp.models.BaiHat;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;

public class PlayNhacActivity extends AppCompatActivity {

    private BaiHat baiHat;
    public static ArrayList<BaiHat> baiHatArrayList = new ArrayList<>();

    private Toolbar toolbar;
    private SeekBar seekbar;
    private TextView txtTimeStart, txtTimeEnd;
    private ImageButton btnSuffle, btnPrev, btnPlay, btnNext, btnRepeat;
    private ViewPager viewPager;

    private PlayDanhSachBaiHatFragment playDanhSachBaiHatFragment;
    private DiaNhacFragment diaNhacFragment;
    private ViewPagerAdapterPlayNhac viewPagerAdapterPlayNhac;

    private boolean repeat, shuffle, play;
    private int positon;

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_nhac);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        mapping();
        getData();
        init();
        eventClick();

    }

    private void eventClick() {
        final Handler handler = new Handler();

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()) {
                    btnPlay.setImageResource(R.drawable.iconplay);
                    mediaPlayer.pause();
                    diaNhacFragment.onPause();
                } else {
                    btnPlay.setImageResource(R.drawable.iconpause);
                    mediaPlayer.start();
                    mediaPlayer.seekTo(seekbar.getProgress());
                    diaNhacFragment.onResume();
                }
            }
        });

        btnSuffle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!shuffle) {
                    shuffle = true;
                    btnSuffle.setImageResource(R.drawable.iconshuffled);
                } else {
                    shuffle = false;
                    btnSuffle.setImageResource(R.drawable.iconsuffle);
                }
            }
        });

        btnRepeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!repeat) {
                    repeat = true;
                    btnRepeat.setImageResource(R.drawable.iconsyned);
                } else {
                    repeat = false;
                    btnRepeat.setImageResource(R.drawable.iconrepeat);
                }
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextBaiHat();
            }
        });

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.seekTo(seekBar.getProgress());
            }
        });

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!repeat) {
                    if (!shuffle) {
                        if ((positon - 1) >= 0) {
                            mediaPlayer.stop();
                            baiHat = baiHatArrayList.get(--positon);
                            init();
                        } else {
                            mediaPlayer.stop();
                            positon = baiHatArrayList.size() - 1;
                            baiHat = baiHatArrayList.get(baiHatArrayList.size() - 1);
                            init();
                        }
                    } else {
                        Random ran = new Random();
                        int positon = ran.nextInt(baiHatArrayList.size());
                        if (positon < (baiHatArrayList.size() - 1)) {
                            mediaPlayer.stop();
                            baiHat = baiHatArrayList.get(positon);
                            init();
                        }
                    }
                } else {
                    mediaPlayer.stop();
                    init();
                }
            }
        });

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (mediaPlayer.isPlaying() && mediaPlayer.getCurrentPosition() < mediaPlayer.getDuration()) {
                    seekbar.setProgress(mediaPlayer.getCurrentPosition());
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
                    txtTimeStart.setText(simpleDateFormat.format(mediaPlayer.getCurrentPosition()));
                    handler.postDelayed(this, 500);
                }
            }
        }, 500);
    }

    private void setImgDiaNhac(String hinhanh) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    diaNhacFragment.setImgDiaNhac(hinhanh);
                    handler.removeCallbacks(this);
                } catch (Exception e) {
                    handler.postDelayed(this, 500);
                }
            }
        }, 500);
    }

    private void nextBaiHat() {
        if (!repeat) {
            if (!shuffle) {
                if (positon < baiHatArrayList.size() - 1) {
                    mediaPlayer.stop();
                    positon++;
                    baiHat = baiHatArrayList.get(positon);
                    customView();
                } else {
                    mediaPlayer.stop();
                    positon = 0;
                    baiHat = baiHatArrayList.get(0);
                    customView();
                }
            } else {
                Random ran = new Random();
                int positon = ran.nextInt(baiHatArrayList.size());
                if (positon < (baiHatArrayList.size() - 1) && positon >= 0) {
                    mediaPlayer.stop();
                    baiHat = baiHatArrayList.get(positon);
                    customView();
                }
            }
        } else {
            mediaPlayer.stop();
            customView();
        }
    }

    private void mapping() {
        toolbar = findViewById(R.id.activityPlayNhac_toolBar);
        seekbar = findViewById(R.id.activityPlayNhac_seekBar);
        txtTimeStart = findViewById(R.id.activityPlayNhac_timeStart);
        txtTimeEnd = findViewById(R.id.activityPlayNhac_timeEnd);
        btnSuffle = findViewById(R.id.activityPlayNhac_btnSuffle);
        btnPrev = findViewById(R.id.activityPlayNhac_btnPrevious);
        btnPlay = findViewById(R.id.activityPlayNhac_btnPlay);
        btnNext = findViewById(R.id.activityPlayNhac_btnNext);
        btnRepeat = findViewById(R.id.activityPlayNhac_btnRepeat);
        viewPager = findViewById(R.id.activityPlayNhac_viewPager);

        repeat = false;
        shuffle = false;
        play = false;
    }

    private void init() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
                finish();
            }
        });
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setNavigationIcon(R.drawable.ic_back_left_arrow);

        playDanhSachBaiHatFragment = new PlayDanhSachBaiHatFragment(baiHatArrayList);
        diaNhacFragment = new DiaNhacFragment();

        viewPagerAdapterPlayNhac = new ViewPagerAdapterPlayNhac(getSupportFragmentManager());
        viewPagerAdapterPlayNhac.addFragment(playDanhSachBaiHatFragment);
        viewPagerAdapterPlayNhac.addFragment(diaNhacFragment);
        viewPager.setAdapter(viewPagerAdapterPlayNhac);

        customView();

    }

    private void customView() {
        if (baiHat.getTenBaiHat() != null && baiHat.getHinhAnhBaiHat() != null) {
            getSupportActionBar().setTitle(baiHat.getTenBaiHat());
            new PlayMp3().execute(baiHat.getLinkBaiHat());
            btnPlay.setImageResource(R.drawable.iconpause);

            diaNhacFragment = (DiaNhacFragment) viewPagerAdapterPlayNhac.getItem(1);
            setImgDiaNhac(baiHat.getHinhAnhBaiHat());
        }
    }


    private void getData() {
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("listBaiHat") && intent.hasExtra("baiHat")) {
                baiHat = (BaiHat) intent.getParcelableExtra("baiHat");
                baiHatArrayList = intent.getParcelableArrayListExtra("listBaiHat");
                positon = baiHatArrayList.indexOf(baiHat);
                Log.d("tag", baiHatArrayList.get(0).getHinhAnhBaiHat());
            } else if (intent.hasExtra("baiHat")) {
                baiHat = (BaiHat) intent.getParcelableExtra("baiHat");
                baiHatArrayList = new ArrayList<>();
                baiHatArrayList.add(baiHat);
                positon = baiHatArrayList.indexOf(baiHat);
            }
        }
    }

    class PlayMp3 extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            return strings[0];
        }

        @Override
        protected void onPostExecute(String baiHat) {
            super.onPostExecute(baiHat);
            try {
                mediaPlayer = new MediaPlayer();
                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.stop();
                        mp.reset();
                    }
                });
                mediaPlayer.setDataSource(baiHat);
                mediaPlayer.prepare();
                mediaPlayer.start();
                TimeSong();

                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        nextBaiHat();
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    private void TimeSong() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
        txtTimeEnd.setText(simpleDateFormat.format(mediaPlayer.getDuration()));
        seekbar.setMax(mediaPlayer.getDuration());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mediaPlayer.stop();
        finish();
    }
}