package com.example.aditya.myapplication.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.aditya.myapplication.R;
import com.example.aditya.myapplication.view.CircularImageView;

public class BidDetailsActivity extends AppCompatActivity
{
    //TextView tv7, tv8, tv9, tv10, tv11, tv12;
    private Toolbar toolbar;
    //Drawable upArrow;
    CardView cardView;
    ImageView bid_back;
    CircularImageView circularImageView;
    ImageView ifollowup;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bid_details);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_mtrl_am_alpha, null);
        else upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_mtrl_am_alpha);

        upArrow.setColorFilter(getResources().getColor(R.color.textColorPrimary), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);*/

        circularImageView = (CircularImageView) findViewById(R.id.imageView1);
        ifollowup = (ImageView) findViewById(R.id.ifollowup);

        bid_back = (ImageView) findViewById(R.id.bid_back);

        bid_back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(BidDetailsActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        cardView = (CardView) findViewById(R.id.cardView2);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            cardView.setClipToOutline(false);
        }

        /*tv7 = (TextView) findViewById(R.id.textView7);
        tv8 = (TextView) findViewById(R.id.textView8);
        tv9 = (TextView) findViewById(R.id.textView9);
        tv10 = (TextView) findViewById(R.id.textView10);
        tv11 = (TextView) findViewById(R.id.textView11);
        tv12 = (TextView) findViewById(R.id.textView12);

        tv12.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                if(tv11.getVisibility() == View.GONE)
                {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(80, 80);
                    layoutParams.setMargins(200, 20, 0, 100);
                    circularImageView.setLayoutParams(layoutParams);

                    tv7.setVisibility(View.VISIBLE);
                    tv8.setVisibility(View.VISIBLE);
                    tv9.setVisibility(View.VISIBLE);
                    tv10.setVisibility(View.VISIBLE);
                    tv11.setVisibility(View.VISIBLE);
                }

                else
                {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(120, 120);
                    layoutParams.setMargins(200, 20, 0, 100);
                    circularImageView.setLayoutParams(layoutParams);

                    tv7.setVisibility(View.GONE);
                    tv8.setVisibility(View.GONE);
                    tv9.setVisibility(View.GONE);
                    tv10.setVisibility(View.GONE);
                    tv11.setVisibility(View.GONE);
                }
            }
        });*/

        /*Drawable myIcon = getResources().getDrawable( R.drawable.followup);
        ColorFilter filter = new LightingColorFilter( Color.BLUE, getResources().getColor(R.color.colorPrimary) );
        myIcon.setColorFilter(filter);
        ifollowup.setImageDrawable(myIcon);*/
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id;
        id = item.getItemId();
        if(id==android.R.id.home){
            Intent i = new Intent(BidDetailsActivity.this,MainActivity.class);
            startActivity(i);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed()
    {
        Intent intent = new Intent(BidDetailsActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
