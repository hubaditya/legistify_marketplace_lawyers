package com.example.aditya.myapplication.activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aditya.myapplication.R;

public class ProfileActivity extends AppCompatActivity
{
    //Drawable upArrow;
    private Toolbar toolbar;
    ImageView iv, icontact, iemail, profile_back;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_mtrl_am_alpha, null);
        else upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_mtrl_am_alpha);

        upArrow.setColorFilter(getResources().getColor(R.color.textColorPrimary), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);*/

        iv = (ImageView) findViewById(R.id.iv);
        icontact = (ImageView) findViewById(R.id.icontact);
        iemail = (ImageView) findViewById(R.id.iemail);
        profile_back = (ImageView) findViewById(R.id.profile_back);

        profile_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        Drawable myIcon = getResources().getDrawable( R.drawable.edit);
        ColorFilter filter = new LightingColorFilter( Color.BLUE, getResources().getColor(R.color.colorPrimary) );
        myIcon.setColorFilter(filter);
        iv.setImageDrawable(myIcon);

        Drawable myIcon2 = getResources().getDrawable( R.drawable.call);
        ColorFilter filter2 = new LightingColorFilter( Color.BLUE, getResources().getColor(R.color.colorPrimary) );
        myIcon2.setColorFilter(filter2);
        icontact.setImageDrawable(myIcon2);

        Drawable myIcon3 = getResources().getDrawable( R.drawable.email);
        ColorFilter filter3 = new LightingColorFilter( Color.BLUE, getResources().getColor(R.color.colorPrimary) );
        myIcon3.setColorFilter(filter3);
        iemail.setImageDrawable(myIcon3);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id;
        id = item.getItemId();
        if(id==android.R.id.home)
        {
            Intent i = new Intent(ProfileActivity.this,MainActivity.class);
            startActivity(i);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed()
    {
        Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
