package com.example.aditya.myapplication.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.os.Handler;
import android.widget.TextView;

import com.example.aditya.myapplication.R;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends Activity
{
    TextView splashText;

    public int currentImageIndex=0;
    ImageView slidingImage;

    private int[] IMAGE_IDS = { R.drawable.splash0 };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        splashText = (TextView) findViewById(R.id.splashText);

        splashText.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        final Handler mHandler = new Handler();

        final Runnable mUpdateResults = new Runnable()
        {
            public void run() {
                AnimateandSlideShow();
            }
        };

        int delay = 100; // delay for 1 sec.
        int period = 4000; // repeat every 4 sec.
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {

            public void run() {
                mHandler.post(mUpdateResults);
            }

        }, delay, period);
    }

    private void AnimateandSlideShow()
    {
        slidingImage = (ImageView)findViewById(R.id.splashImage);
        slidingImage.setImageResource(IMAGE_IDS[currentImageIndex%IMAGE_IDS.length]);

        currentImageIndex++;

        Animation rotateimage = AnimationUtils.loadAnimation(this, R.anim.animation2);
        slidingImage.startAnimation(rotateimage);
    }
}