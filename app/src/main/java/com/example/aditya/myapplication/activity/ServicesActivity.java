package com.example.aditya.myapplication.activity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.aditya.myapplication.R;
import com.example.aditya.myapplication.adapter.ServiceAdapter;

import java.util.ArrayList;

public class ServicesActivity extends AppCompatActivity
{
    //private Drawable upArrow;
    private EditText searchService;
    private Toolbar toolbar;
    private ListView mListView;
    private ServiceAdapter mAdapter;
    private ArrayList<String> service;
    private ImageView service_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_mtrl_am_alpha, null);
        else upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_mtrl_am_alpha);

        upArrow.setColorFilter(getResources().getColor(R.color.textColorPrimary), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);*/

        service_back = (ImageView) findViewById(R.id.service_back);

        service_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(ServicesActivity.this, FilterActivity.class);
                Bundle bundle = ActivityOptions.makeCustomAnimation(getApplicationContext(),
                        R.anim.animation4, R.anim.animation3).toBundle();
                startActivity(intent, bundle);
                finish();
            }
        });

        Snackbar snackbar = Snackbar
                .make(findViewById(android.R.id.content), "Done", Snackbar.LENGTH_INDEFINITE);
        View view = snackbar.getView();
        TextView tv = (TextView) view.findViewById(android.support.design.R.id.snackbar_text);
        tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tv.setTypeface(null, Typeface.BOLD);
        tv.setGravity(Gravity.CENTER_HORIZONTAL);
        view.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary));
        snackbar.show();

        searchService = (EditText) findViewById(R.id.searchService);

        mListView = (ListView) findViewById(R.id.serviceList);
        mListView.setTextFilterEnabled(true);

        service = new ArrayList<>();
        service.add("Registration");
        service.add("Incorporation");
        service.add("Trade Licence");
        service.add("Trademark");

        mAdapter = new ServiceAdapter(this, service);
        mListView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();

        searchService.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
                // TODO Auto-generated method stub
                mAdapter.getFilter().filter(arg0);
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                          int arg3) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub

            }

        });
    }

    @Override
    public void onBackPressed()
    {
        Intent intent = new Intent(ServicesActivity.this, FilterActivity.class);
        Bundle bundle = ActivityOptions.makeCustomAnimation(getApplicationContext(),
                R.anim.animation4, R.anim.animation3).toBundle();
        startActivity(intent, bundle);
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();

        if(id==android.R.id.home)
        {
            Intent i = new Intent(ServicesActivity.this,FilterActivity.class);
            Bundle bundle = ActivityOptions.makeCustomAnimation(getApplicationContext(),
                    R.anim.animation4, R.anim.animation3).toBundle();
            startActivity(i, bundle);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
