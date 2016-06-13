package com.example.aditya.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.aditya.myapplication.R;
import com.example.aditya.myapplication.view.CircularImageView;

public class UserActivity extends AppCompatActivity
{
    //TextView tv7, tv8, tv9, tv10, tv11, tv12, tv27, tv28, tv29, tv30, tv31, tv32;
    private Toolbar toolbar;
    //Drawable upArrow;
    CircularImageView circularImageView;
    private ImageView ifollowup, user_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        circularImageView = (CircularImageView) findViewById(R.id.imageView1);

        /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_mtrl_am_alpha, null);
        else upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_mtrl_am_alpha);

        upArrow.setColorFilter(getResources().getColor(R.color.textColorPrimary), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);*/

        ifollowup = (ImageView) findViewById(R.id.ifollowup);
        user_back = (ImageView) findViewById(R.id.user_back);

        user_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(UserActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        /*Drawable myIcon = getResources().getDrawable( R.drawable.followup);
        ColorFilter filter = new LightingColorFilter( Color.BLACK, getResources().getColor(R.color.colorPrimary) );
        myIcon.setColorFilter(filter);
        ifollowup.setImageDrawable(myIcon);*/

        /*tv7 = (TextView) findViewById(R.id.textView7);
        tv8 = (TextView) findViewById(R.id.textView8);
        tv9 = (TextView) findViewById(R.id.textView9);
        tv10 = (TextView) findViewById(R.id.textView10);
        tv11 = (TextView) findViewById(R.id.textView11);
        tv12 = (TextView) findViewById(R.id.textView12);

        tv27 = (TextView) findViewById(R.id.textView27);
        tv28 = (TextView) findViewById(R.id.textView28);
        tv29 = (TextView) findViewById(R.id.textView29);
        tv30 = (TextView) findViewById(R.id.textView30);
        tv31 = (TextView) findViewById(R.id.textView31);
        tv32 = (TextView) findViewById(R.id.textView32);


        tv12.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                if(tv11.getVisibility() == View.GONE)
                {
                    tv7.setVisibility(View.VISIBLE);
                    tv8.setVisibility(View.VISIBLE);
                    tv9.setVisibility(View.VISIBLE);
                    tv10.setVisibility(View.VISIBLE);
                    tv11.setVisibility(View.VISIBLE);
                }

                else
                {
                    tv7.setVisibility(View.GONE);
                    tv8.setVisibility(View.GONE);
                    tv9.setVisibility(View.GONE);
                    tv10.setVisibility(View.GONE);
                    tv11.setVisibility(View.GONE);
                }
            }
        });

        tv32.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                if(tv31.getVisibility() == View.GONE)
                {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(80, 80);
                    layoutParams.setMargins(200, 20, 0, 100);
                    circularImageView.setLayoutParams(layoutParams);

                    tv27.setVisibility(View.VISIBLE);
                    tv28.setVisibility(View.VISIBLE);
                    tv29.setVisibility(View.VISIBLE);
                    tv30.setVisibility(View.VISIBLE);
                    tv31.setVisibility(View.VISIBLE);
                }

                else
                {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(120, 120);
                    layoutParams.setMargins(180, 20, 0, 100);
                    circularImageView.setLayoutParams(layoutParams);

                    tv27.setVisibility(View.GONE);
                    tv28.setVisibility(View.GONE);
                    tv29.setVisibility(View.GONE);
                    tv30.setVisibility(View.GONE);
                    tv31.setVisibility(View.GONE);
                }
            }
        }); */

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id;
        id = item.getItemId();
        if(id==android.R.id.home)
        {
            Intent i = new Intent(UserActivity.this, MainActivity.class);
            startActivity(i);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed()
    {
        Intent intent = new Intent(UserActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
