package com.liem.musicapp.fragments;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;

import com.liem.musicapp.R;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class DiaNhacFragment extends Fragment {
    public View view;
    CircleImageView circleImageView;
    ObjectAnimator objectAnimator;
    public DiaNhacFragment() {
    }

    @Override
    public void onPause() {
        super.onPause();
        circleImageView.animate().cancel();
    }

    @Override
    public void onResume() {
        super.onResume();
        PlayRotateDics();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_dia_nhac, container, false);
        circleImageView = view.findViewById(R.id.fmDiaNhac_CircleImageView);
//        objectAnimator= ObjectAnimator.ofFloat(circleImageView,"rotation",0f,359f);
//        objectAnimator.setDuration(10000);
//        objectAnimator.setRepeatCount(ValueAnimator.INFINITE);
//        objectAnimator.setRepeatMode(ValueAnimator.RESTART);
//        objectAnimator.setInterpolator(new LinearInterpolator());
//        circleImageView.animate().start();
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                circleImageView.animate().rotationBy(360).withEndAction(this).setDuration(10000).setInterpolator(new LinearInterpolator()).start();
//            }
//        };
//
//        circleImageView.animate().rotationBy(360).withEndAction(runnable).setDuration(10000).setInterpolator(new LinearInterpolator()).start();
            PlayRotateDics();
        return view;
    }

    private void PlayRotateDics() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                circleImageView.animate().rotationBy(360).withEndAction(this).setDuration(10000).setInterpolator(new LinearInterpolator()).start();
            }
        };

        circleImageView.animate().rotationBy(360).withEndAction(runnable).setDuration(10000).setInterpolator(new LinearInterpolator()).start();
    }

    public void setImgDiaNhac(String url){
        Picasso.get().load(url).into(circleImageView);
    }

}