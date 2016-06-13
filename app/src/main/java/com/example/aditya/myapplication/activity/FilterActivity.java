package com.example.aditya.myapplication.activity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.aditya.myapplication.R;

public class FilterActivity extends AppCompatActivity
{
    private ImageView imageView, iLocation, iTimeline, iGo;
    private SeekBar seekBar1;
    private TextView seekPrice, time1, time2, time3;
    private AutoCompleteTextView autoArea;
    private CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);

        //cardView = (CardView) findViewById(R.id.cardViewServices);

        autoArea = (AutoCompleteTextView) findViewById(R.id.autoArea);
        imageView = (ImageView) findViewById(R.id.close);
        iLocation = (ImageView) findViewById(R.id.iLocation);
        iTimeline = (ImageView) findViewById(R.id.iTimeline);
        iGo = (ImageView) findViewById(R.id.iGo);
        seekBar1 = (SeekBar)  findViewById(R.id.seekBar1);
        seekPrice = (TextView) findViewById(R.id.seekPrice);
        time1 = (TextView) findViewById(R.id.time1);
        time2 = (TextView) findViewById(R.id.time2);
        time3 = (TextView) findViewById(R.id.time3);

        String[] countries = {"Delhi", "Lucknow", "Dehradun", "Derby"};
        ArrayAdapter<String> adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,countries);
        autoArea.setAdapter(adapter);

        Drawable myIcon = getResources().getDrawable(R.drawable.ic_close);
        ColorFilter filter = new LightingColorFilter(Color.BLUE, getResources().getColor(R.color.grey));
        myIcon.setColorFilter(filter);
        imageView.setImageDrawable(myIcon);

        Snackbar snackbar = Snackbar
                .make(findViewById(android.R.id.content), "Apply", Snackbar.LENGTH_INDEFINITE);
        View view = snackbar.getView();
        TextView tv = (TextView) view.findViewById(android.support.design.R.id.snackbar_text);
        tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tv.setTypeface(null, Typeface.BOLD);
        tv.setGravity(Gravity.CENTER_HORIZONTAL);
        view.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary));
        snackbar.show();

        //  TODO: View.OnClick()
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(FilterActivity.this, MainActivity.class);
                Bundle bundle = ActivityOptions.makeCustomAnimation(getApplicationContext(),
                        R.anim.animation4, R.anim.animation3).toBundle();
                startActivity(intent, bundle);
                finish();
            }
        });

        iGo.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent intent = new Intent(FilterActivity.this, ServicesActivity.class);
                Bundle bundle = ActivityOptions.makeCustomAnimation(getApplicationContext(),
                        R.anim.animation2, R.anim.animation).toBundle();
                startActivity(intent, bundle);
                finish();
            }
        });



        seekPrice.setText("Budget: " + seekBar1.getProgress());

        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
                progress = progresValue;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekPrice.setText("Budget: " + progress );
            }
        });

        Drawable myIcon2 = getResources().getDrawable( R.drawable.location);
        ColorFilter filter2 = new LightingColorFilter( Color.BLUE, getResources().getColor(R.color.grey) );
        myIcon2.setColorFilter(filter2);
        iLocation.setImageDrawable(myIcon2);

        Drawable myIcon3 = getResources().getDrawable( R.drawable.timeline);
        ColorFilter filter3 = new LightingColorFilter( Color.BLUE, getResources().getColor(R.color.grey) );
        myIcon3.setColorFilter(filter3);
        iTimeline.setImageDrawable(myIcon3);

        Drawable myIcon4 = getResources().getDrawable( R.drawable.go);
        ColorFilter filter4 = new LightingColorFilter( Color.BLUE, getResources().getColor(R.color.grey) );
        myIcon4.setColorFilter(filter4);
        iGo.setImageDrawable(myIcon4);


        time1.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                if(time1.getCurrentTextColor() == getResources().getColor(R.color.grey))
                    time1.setTextColor(Color.BLACK);

                else time1.setTextColor(getResources().getColor(R.color.grey));
            }
        });

        time2.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                if(time2.getCurrentTextColor() == getResources().getColor(R.color.grey))
                    time2.setTextColor(Color.BLACK);

                else time2.setTextColor(getResources().getColor(R.color.grey));
            }
        });

        time3.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                if(time3.getCurrentTextColor() == getResources().getColor(R.color.grey))
                    time3.setTextColor(Color.BLACK);

                else time3.setTextColor(getResources().getColor(R.color.grey));
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(FilterActivity.this, MainActivity.class);
        Bundle bundle = ActivityOptions.makeCustomAnimation(getApplicationContext(),
                R.anim.animation4, R.anim.animation3).toBundle();
        startActivity(intent, bundle);
        finish();
    }
}
